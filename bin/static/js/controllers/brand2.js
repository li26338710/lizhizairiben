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
				$scope.results=resp.data.aaData;
				
//				$scope.options = {
//				     data: resp.data.aaData,
//				     aoColumns: [
//				      { mData: '' },
//				      { mData: 'brandId' },
//				      { mData: 'brandName' },
//				      { mData: 'type' },
//				      { mData: 'url' }
//				     ],
//				     "aoColumnDefs": [{
//					     "aTargets": [ 0 ],
//					     "mData": "action",
//					     "mRender": function ( data, type, full ) {
//					        return '<a class="btn btn-xs btn-default" ng-hide="brand.editing" click="editItem('+full+')">Edit</a><a class="btn btn-xs btn-default" ng-show="brand.editing" click="doneEditing('+full+')">Done</a>';
//					     }
//				     }]
//				 };
			});
		};
		
		$scope.addNew = function() {
			var brandTable = $.fn.dataTable.fnTables(true)[0];
			var table = $(brandTable).DataTable();
			
			var newObject;

			var data = {
				'brandName' : $scope.newBrand.brandName,
				'type' : $scope.newBrand.type,
				'url' : $scope.newBrand.url
			};

			$http.post('/lizhi/brand/addNew.do', JSON.stringify(data))
				.success(function(response) {
					newObject = response.aaData;
					var brand = {
						"data": {
						"brandId" : newObject[0].brandId,
						"brandName" : newObject[0].brandName,
						"type" : newObject[0].type,
						"url" : newObject[0].url,
						"editing" :false
					}};
					table.row().remove().draw();
					table.row.add(brand).draw(false);
					
					$scope.newBrand = '';
				}).error(function(data, status, headers, config) {
				});
		};

		$scope.editItem = function(brand) {
			brand.editing = true;
		};

		$scope.doneEditing = function(brand) {
			brand.editing = false;
		};
		
		$scope.init();
		
	} ]);
