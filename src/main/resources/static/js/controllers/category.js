'use strict';

/* Controllers */
// signin controller
app.controller('CategoryListController', [
		'$scope',
		'$http',
		'$state',
		function($scope, $http, $state) {
		
		$scope.init = function(){
			var $url = '/lizhi/category/list.do';
			
			$http.get($url).then(function(resp) {
				$scope.options = {
				     data: resp.data.aaData,
				     aoColumns: [
					      { mData: 'categoryId' },
				          { mData: 'categoryName' }
				      ]
				 };
				
				$('#categoryTable tbody').on( 'click', 'tr', function () {
					var table = $('#categoryTable').DataTable();
					var category = table.row(this).data();
					
					$('#categoryTable .selected').removeClass('selected');
					
					$(this).addClass('selected');
					
					$scope.$apply(function () {
				        $scope.newCategory = category;
				    });
					
					$scope.update = true
			    } );
			});
		};
		
		$scope.addNew = function() {
			var table = $('#categoryTable').DataTable();
			
			var newObject;

			var data = {
				'categoryId' : $scope.newCategory.categoryId,
				'categoryName' : $scope.newCategory.categoryName
			};
			
			var url = '/lizhi/category/addNew.do';
			
			if($scope.update){
				url = '/lizhi/category/update.do';
			}

			$http.post(url, JSON.stringify(data))
				.success(function(response) {
					newObject = response.aaData;
					var category = {
							categoryId : newObject[0].categoryId,
							categoryName : newObject[0].categoryName
					};
					if($scope.update){
						table.row('.selected').data(category).draw(false);
						$('#categoryTable .selected').removeClass('selected');
					}else{
						table.row.add(category).draw(false);
					}
					
					$scope.update = false;
					$scope.newCategory = '';
				}).error(function(data, status, headers, config) {
				});
		};
		$('#clearButton').on( 'click', function () {
			
			$scope.$apply(function () {
				$scope.update = false;
				$scope.newCategory = '';
		    });
		});
		
		$scope.init();

	} ]);
