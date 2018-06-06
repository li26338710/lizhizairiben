'use strict';

/* Controllers */
// signin controller
app.controller('BrandListController', [
		'$scope',
		'$http',
		'$state',
		function($scope, $http, $state) {
			
		$scope.init = function(){
			var $url = '/lizhi/brand/list.do';
			
			$http.get($url).then(function(resp) {
				$scope.options = {
				     data: resp.data.aaData,
				     aoColumns: [
				      { mData: 'brandId' },
				      { mData: 'brandName' },
				      { mData: 'type' },
				      { mData: 'url' }
				     ]
				 };
				
				$('#brandTable tbody').on( 'click', 'tr', function () {
					var table = $('#brandTable').DataTable();
					var brand = table.row(this).data();
					
					$(this).addClass('selected');
					
					$scope.$apply(function () {
				        $scope.newBrand = brand;
				    });
					
					$scope.update = true
			    });
			});
			
		};
		
		$scope.addNew = function() {
			var table = $('#brandTable').DataTable();
			
			var newObject;

			var data = {
				"brandId" : $scope.newBrand.brandId,
				'brandName' : $scope.newBrand.brandName,
				'type' : $scope.newBrand.type,
				'url' : $scope.newBrand.url
			};
			
			var url = '/lizhi/brand/addNew.do';
			
			if($scope.update){
				url = '/lizhi/brand/update.do';
			}

			$http.post(url, JSON.stringify(data))
				.success(function(response) {
					newObject = response.aaData;
					var brand = {
						"brandId" : newObject[0].brandId,
						"brandName" : newObject[0].brandName,
						"type" : newObject[0].type,
						"url" : newObject[0].url
					};
					if($scope.update){
						table.row('.selected').data(brand).draw(false);
						//table.row('.selected').removeClass('selected');
						$('#brandTable .selected').removeClass('selected');
					}else{
						table.row.add(brand).draw(false);
					}
					
					$scope.update = false;
					$scope.newBrand = '';
				}).error(function(data, status, headers, config) {
				});
		};
		$scope.clearButton = function () {
			
			$scope.update = false;
			$scope.newBrand = '';
		}
		
		$scope.init();
		
	} ]);
