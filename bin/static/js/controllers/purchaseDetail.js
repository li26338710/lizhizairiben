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
app.controller('PurchaseDetailController', [
		'$scope',
		'$http',
		'$state',
		'$location',
		function($scope, $http, $state, $location) {
			
			$scope.selectedProduct = {}
			$scope.selectedProduct.productId = 0;
			
			$scope.selectedBrand = {}
			$scope.selectedBrand.brandId = 0;
			
			$scope.selectedMarket = {}
			$scope.selectedMarket.marketId = 0;
			
			$scope.init = function() {
				$scope.purchaseId = $location.search().purchaseId;
				
				$scope.getMarket();
				$scope.getBrand();
				$scope.getProducts();
				$scope.getPurchaseDetail();
//				$scope.changeItem();
				
			};
			
			
			$scope.onSelectBrand = function(item){
				$scope.purchaseDetail.brandId = item.brandId;
			  }
			$scope.onSelectProduct = function(item){
				$scope.purchaseDetail.productId = item.productId;
			}
			$scope.onSelectMarket = function(item){
				$scope.purchaseDetail.marketId = item.marketId;
			}
			
			
			
			$scope.getMarket = function() {
				var $url = '/lizhi/market/findMarket.do';

				$http.get($url).then(function(resp) {
					$scope.markets = resp.data.aaData;
				});
			};
			$scope.getBrand = function() {
				var $url = '/lizhi/brand/list.do';

				$http.get($url).then(function(resp) {
					$scope.brands = resp.data.aaData;
				});
			};
			
			$scope.getProducts = function() {
				var $url = '/lizhi/product/findbyCategoryIdOrBrandId.do';

				$http.get($url).then(function(resp) {
					$scope.products = resp.data.aaData;
				});
			};
			
			$scope.getPurchaseDetail = function() {
				
				$http.get('/lizhi/purchase/findbyPurchaseId.do',
				{
					params : {
						purchaseId :  $scope.purchaseId,
						productId :$scope.selectedProduct.productId,
						brandId : $scope.selectedProduct.brandId
					}
				}).then(function(resp) {
					$scope.detailOptions = {
							data:  resp.data.aaData,
							aoColumns: [
								{ mData: 'purchaseId' , render: function (data) {
				                    return '<button class="btn m-b-xs btn-sm btn-info copyButton">复制</button>';
				                	} 
								},
								{ mData: 'purchaseId' },
								{ mData: 'marketName' },
								{ mData: 'brandName' },
								{ mData: 'productName' },
								{ mData: 'count' },
								{ mData: 'singlePrice' },
								{ mData: 'singlePriceJpy'},
								{ mData: 'sumPrice' },
								{ mData: 'sumPriceJpy'},
								{ mData: 'rate'},
								{ mData: 'productId' , bVisible : false },
								{ mData: 'brandId' , bVisible : false },
								{ mData: 'marketId' , bVisible : false }
							]
						};
					
					$scope.bandEvent();
				});
			};
			
			$scope.bandEvent = function() {
				$('#purchaseDetailTable tbody').on( 'click', '.copyButton', function (evt) {
					var table = $('#purchaseDetailTable').DataTable();
					var purchaseDetail = table.row(this.parentElement.parentElement).data();
					
					$('#purchaseDetailTable .selected').removeClass('selected');
					
					$scope.$apply(function () {
						
						$scope.purchaseDetail = {};
						$scope.purchaseDetail.purchaseId = purchaseDetail.purchaseId;
						$scope.purchaseDetail.marketId = purchaseDetail.marketId;
						$scope.purchaseDetail.productId = purchaseDetail.productId;
				    });
					
					$scope.updateDetail = false;
					evt.stopPropagation(); //阻止事件冒泡
					return false;
			    });
				
				$('#purchaseDetailTable tbody').on( 'click', 'tr', function () {
					var table = $('#purchaseDetailTable').DataTable();
					var purchaseDetail = table.row(this).data();
					
					$('#purchaseDetailTable .selected').removeClass('selected');
					
					$(this).addClass('selected');
					
					$scope.$apply(function () {
						
						$scope.purchaseDetail = {};
						$scope.purchaseDetail = purchaseDetail;
						$scope.purchaseDetail.purchaseId = purchaseDetail.purchaseId;
						$scope.purchaseDetail.marketId = purchaseDetail.marketId;
						$scope.purchaseDetail.productId = purchaseDetail.productId;
				    });
					
					$scope.updateDetail = true
			    });
			};
			
			$scope.changeBrandItem = function(item){
				$scope.selectedBrand.brandId = item.brandId;
				$scope.changeItem();
			};
			
			$scope.changeProductItem = function(item){
				$scope.selectedProduct.productId = item.productId;
				$scope.changeItem();
			};
			
			$scope.changeMarketItem = function(item){
				$scope.selectedMarket.marketId = item.marketId;
				$scope.changeItem();
			};
			
			$scope.changeItem = function() {
				var detailTable = $('#purchaseDetailTable').DataTable();
				
				$http.get('/lizhi/purchase/findbyPurchaseId.do',
				{
					params : {
						productId :$scope.selectedProduct.productId,
						brandId : $scope.selectedBrand.brandId,
						marketId : $scope.selectedMarket.marketId
					}
				}).then(function(resp) {

					 detailTable.clear();
					 detailTable.rows.add(resp.data.aaData);
					 detailTable.draw();
					 
					$scope.bandEvent();
				});
			};
			
			$scope.addNewDetail = function() {
				var table = $('#purchaseDetailTable').DataTable();
				var newObject;
				var data = {
					"brandId" : $scope.purchaseDetail.brandId,
					"productId" : $scope.purchaseDetail.productId,
					"marketId" : $scope.purchaseDetail.marketId,
					"singlePrice" :$scope.purchaseDetail.singlePrice,
					"rate" : $scope.purchaseDetail.rate,
					"purchaseDate" : $scope.purchaseDetail.purchaseDate,
					"purchaseId" : $scope.purchaseDetail.purchaseId,
					"purchaseDetailId" : $scope.purchaseDetail.purchaseDetailId,
					"count" : $scope.purchaseDetail.count
				};
				
				var url = '/lizhi/purchase/addNewPurchaseDetail.do';
				
				if($scope.updateDetail){
					url = '/lizhi/purchase/updatePurchaseDetail.do';
				}

				$http.post(url, JSON.stringify(data))
					.success(function(response) {
						newObject = response.aaData;
						var purchase = {

							"purchaseId" : newObject[0].purchaseId,
							"brandName" : newObject[0].brandName,
							"marketName" : newObject[0].marketName,
							"productName" : newObject[0].productName,
							"count" : newObject[0].count,
							"singlePrice" : newObject[0].singlePrice,
							"singlePriceJpy" : newObject[0].singlePriceJpy,
							"sumPrice" : newObject[0].sumPrice,
							"sumPriceJpy" : newObject[0].sumPriceJpy,
							"rate" : newObject[0].rate,
							"productId" : newObject[0].productId,
							"marketId" : newObject[0].marketId,
							"brandId" : newObject[0].brandId
						};
						if($scope.updateDetail){
							table.row('.selected').data(purchase).draw(false);
							$('#purchaseDetailTable .selected').removeClass('selected');
						}else{
							table.row.add(purchase).draw(false);
						}
						
						$scope.updateDetail = false;
						$scope.purchaseDetail = {};
					})
					.error(function(data, status, headers, config) {
					});
			};
			
			 $scope.dat = new Date();
			 $scope.format = "yyyy/MM/dd";
			 $scope.altInputFormats = ['yyyy/M!/d!'];
			 
			 $scope.popup1 = {
			 opened: false
			 };
			 $scope.open1 = function () {
			 $scope.popup1.opened = true;
			 };
			 
			$scope.clearButton = function () {
				
				$scope.updateDetail = false;
				$scope.purchaseDetail={};
			}
			$scope.init();

		} ]);
