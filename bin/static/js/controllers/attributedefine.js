'use strict';

/* Controllers */
// signin controller
app.controller('AttributeDefineController', [ '$scope', '$http', '$state',
		function($scope, $http, $state) {

			$scope.init = function() {
				var $categoryUrl = '/lizhi/category/list.do';
				var $url = '/lizhi/attributeDefine/findbyCategoryId.do';

				$http.get($categoryUrl).then(function(resp) {
					$scope.results = resp.data.aaData;
				});

				$http.get($url).then(function(resp) {
					$scope.options = {
						data : resp.data.aaData,
						aoColumns : [ 
						   { mData : 'attributeDefineId' }, 
						   { mData : 'categoryName' }, 
						   { mData : 'attributeName' }, 
						   { mData : 'categoryId', bVisible : false} 
						]
					};

					$('#attributeTable tbody').on('click', 'tr', function() {
						var table = $('#attributeTable').DataTable();
						var attribute = table.row(this).data();

						$('#attributeTable .selected').removeClass('selected');
						
						$(this).addClass('selected');

						$scope.$apply(function() {
							$scope.newAttribute = attribute;
						});

						$scope.update = true
					});
				});
			};

			$scope.changeItem = function() {
				var attributeTable = $.fn.dataTable.fnTables(true)[0];
				var table = $(attributeTable).DataTable();

				table.search($scope.selectedCategory).draw();
			};

			$('#clearButton').on('click', function() {
				$scope.$apply(function() {
					$scope.update = false;
					$scope.newAttribute = '';
				});

			});

			$scope.init();

		} ]);
