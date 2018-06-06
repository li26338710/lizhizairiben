'use strict';

app.filter('propsFilter', function() {
    return function(items, props) {
        var out = [];

        if (angular.isArray(items)) {
          items.forEach(function(item) {
            var itemMatches = false;

            var keys = Object.keys(props);
            for (var i = 0; i < keys.length; i++) {
              var prop = keys[i];
              var text = props[prop].toLowerCase();
              if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
                itemMatches = true;
                break;
              }
            }

            if (itemMatches) {
              out.push(item);
            }
          });
        } else {
          // Let the output be the input untouched
          out = items;
        }

        return out;
    };
})

/* Controllers */
// signin controller
app.controller('ProductController', [
		'$scope',
		'$http',
		'$state',
		function($scope, $http, $state) {
			
			$scope.newCategory={};
			$scope.newBrand={};
			$scope.currentRate={};
			$scope.discountsetting={};
			$scope.onSelectBrand = function(item){
				$scope.newBrand = item;
			  }
			$scope.onSelectCategory = function(item){
				$scope.newCategory = item;
			  }
			
			$scope.getCategory = function() {
				var $url = '/lizhi/category/list.do';

				$http.get($url).then(function(resp) {
					$scope.categorys = resp.data.aaData;
				});
			};
			
			$scope.getBrand = function() {
				var $url = '/lizhi/brand/list.do';

				$http.get($url).then(function(resp) {
					$scope.brands = resp.data.aaData;
				});
			};
			
			$scope.getDiscountSetting = function() {
				var $url = '/lizhi/discountSetting/list.do';

				$http.get($url).then(function(resp) {
					$scope.discountsettings = resp.data.aaData;
				});
			};
			
			$scope.init = function(){
				$scope.getCategory();
				$scope.getBrand();
				$scope.getDiscountSetting();
				
				$scope.selectedCategory = 0;
				$scope.selectedBrand = 0;
				$scope.currentRate = 0.0629;
				
				
				var $url = '/lizhi/product/findbyCategoryIdOrBrandId.do';
				
				$http.get($url ,{
						params : {
							categoryId : $scope.selectedCategory,
							brandId : $scope.selectedBrand
						}})
					 .then(function(resp) {
					$scope.options = {
					     data: resp.data.aaData,
					     aoColumns: [
					      { mData: 'brandName' },
					      { mData: 'categoryName' },
					      { mData: 'productName' },
					      { mData: 'productNameJapan' },
					      { mData: 'weight' },
					      { mData: 'officalPrice' },
					      { mData: 'discountsettingname' },
					      { mData: 'discountsettingcomment' },
					      { mData: 'discount' },
					      { mData: 'costPriceRmb' },
					      { mData: 'salePrice' },
					      { mData: 'productId' , bVisible : false},
					      { mData: 'brandId' , bVisible : false},
					      { mData: 'categoryId' , bVisible : false },
					      { mData: 'iddiscountsetting' , bVisible : false },
					     ]
					 };
					
					$('#productTable tbody').on( 'click', 'tr', function () {
						var table = $('#productTable').DataTable();
						var product = table.row(this).data();
						
						$('#productTable .selected').removeClass('selected');
						
						$(this).addClass('selected');
						
						$scope.$apply(function () {
							$scope.newBrand = {
								'brandId':product.brandId,
				        		'brandName':product.brandName,
					        };
							$scope.newCategory = {
				        		'categoryId':product.categoryId,
				        		'categoryName':product.categoryName,
					        };
							
							 $scope.productDetail = product;
							 $scope.productDetail.brand = $scope.newBrand ;
							 $scope.productDetail.category = $scope.newCategory ;
							 $scope.discountsetting =  $scope.discountsettings.find(function(item){return item.idDiscountSetting == product.iddiscountsetting}) ;
					    });
						
						$scope.update = true
				    });
				});
				
			};
			
			$scope.getAttribute = function(productDetail) {
				$http.get('/lizhi/attribute/findbyProductId.do',
					{
						params : {
							productId : productDetail.productId,
							categoryId : productDetail.categoryId
						}
					}).then(function(resp) {
						$scope.attributes = resp.data.aaData;
				});
			};
			
			$scope.addNew = function() {
				var table = $('#productTable').DataTable();
				var newObject;
				var data = {
					"productId" : $scope.productDetail.productId,
					"brandId" : $scope.newBrand.brandId,
					"categoryId" :$scope.newCategory.categoryId,
					"iddiscountsetting" : $scope.discountsetting.idDiscountSetting,
					"productName" : $scope.productDetail.productName,
					"productNameJapan" : $scope.productDetail.productNameJapan,
					"officalPrice" : $scope.productDetail.officalPrice,
					"recentlyBookPrice" : $scope.productDetail.recentlyBookPrice,
					"istax" : $scope.productDetail.istax,
					"taxfee" : $scope.productDetail.taxfee,
					"discount" : $scope.productDetail.discount,
					"salePrice" : $scope.productDetail.salePrice,
					"weight" : $scope.productDetail.weight
				};
				
				var url = '/lizhi/product/addNew.do';
				
				if($scope.update){
					url = '/lizhi/product/update.do';
				}

				$http.post(url, JSON.stringify(data))
					.success(function(response) {
						newObject = response.aaData;
						var product = {
							"productId" : newObject[0].productId,
							"brandName" : newObject[0].brandName,
							"categoryName" : newObject[0].categoryName,
							"productName" : newObject[0].productName,
							"productNameJapan" : newObject[0].productNameJapan,
							"officalPrice" : newObject[0].officalPrice,
							"recentlyBookPrice" : newObject[0].recentlyBookPrice,
							"istax" : newObject[0].istax,
							"brandId" : newObject[0].brandId,
							"categoryId" : newObject[0].categoryId,
							"taxfee" : newObject[0].taxfee,
							"discount" : newObject[0].discount,
							"weight" : newObject[0].weight,
							"costPrice" : newObject[0].costPrice,
							"costPriceRmb": newObject[0].costPriceRmb,
							"salePrice" : newObject[0].salePrice,
							"iddiscountsetting": newObject[0].iddiscountsetting,
							"discountsettingname": newObject[0].discountsettingname,
							"discountsettingcomment": newObject[0].discountsettingcomment
						};
						if($scope.update){
							table.row('.selected').data(product).draw(false);
							$('#productTable .selected').removeClass('selected');
						}else{
							table.row.add(product).draw(false);
						}
						
						$scope.update = false;
						$scope.productDetail = {};
						$scope.productDetail.brand = {'brandId':'','brandName':''};
						$scope.productDetail.category = {'categoryId':'','categoryName':''};
						$scope.productDetail.discountsetting = {'iddiscountsetting':'','discountSettingName':''};
					})
					.error(function(data, status, headers, config) {
					});
			};
			
			$scope.changeItem = function() {
				var productTable = $.fn.dataTable.fnTables(true)[0];
				var table = $(productTable).DataTable();
				
				var $url = '/lizhi/product/findbyCategoryIdOrBrandId.do';
				
				$http.get($url ,{
						params : {
							categoryId : $scope.selectedCategory,
							brandId : $scope.selectedBrand
						}})
					 .then(function(resp) {
						 
						 table.clear();
						 table.rows.add(resp.data.aaData);
							
						 table.draw();
					
					$('#productTable tbody').on( 'click', 'tr', function () {
						var table = $('#productTable').DataTable();
						var product = table.row(this).data();
						
						$('#productTable .selected').removeClass('selected');
						
						$(this).addClass('selected');
						
						$scope.$apply(function () {
					        $scope.productDetail = product;
					    });
						
						$scope.update = true
				    });
				});
			};
		
			$scope.init();
}]);
