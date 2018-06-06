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
app.controller('OrderController', [
		'$scope',
		'$http',
		'$state',
		'$location',
		function($scope, $http, $state, $location) {
		    
			$scope.currentRate={};
			
			$scope.newCustomer={};
			$scope.newProduct = {};
			$scope.order={}
			$scope.orderDetail={};
			$scope.selectedProduct = {}
			$scope.selectedProduct.productId = 0;
			
			$scope.selectedCustomer = {};
			$scope.selectedCustomer.customerId = 0;
			
			var selectedOrder ;
			
			$scope.onSelectCustomer = function(item){
				$scope.newCustomer = item;
				$scope.orderDetail.customerId = item.customerId;
			  }
			$scope.onSelectProduct = function(item){
				$scope.newProduct = item;
				$scope.orderDetail.productId = item.productId;
			}
			$scope.formats = ['yyyy-MM-dd','dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
			
			
			$scope.orderDatepickerInit = function(){

				$scope.orderToday = function() {
			      $scope.order.bookDate = new Date();
			    };
			    $scope.orderToday();

			    $scope.orderClear = function () {
			      $scope.order.bookDate = null;
			    };

			    // Disable weekend selection
			    $scope.disabled = function(date, mode) {
			      return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
			    };

			    $scope.toggleMin = function() {
			      $scope.minDate = $scope.minDate ? null : new Date();
			    };
			    $scope.toggleMin();

			    $scope.orderOpen = function($event) {
			      $event.preventDefault();
			      $event.stopPropagation();

			      $scope.orderOpened = true;
			    };

			    $scope.orderDateOptions = {
			      formatYear: 'yy',
			      startingDay: 1,
			      class: 'datepicker'
			    };

			    $scope.orderFormat = $scope.formats[0];
			}
			
			$scope.orderDetailDatepickerInit = function(){

				$scope.orderDetailToday = function() {
			      $scope.orderDetail.bookDate = new Date();
			    };
			    $scope.orderDetailToday();

			    $scope.orderDetailClear = function () {
			      $scope.orderDetail.bookDate = null;
			    };

			    // Disable weekend selection
			    $scope.disabled = function(date, mode) {
			      return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
			    };

			    $scope.toggleMin = function() {
			      $scope.minDate = $scope.minDate ? null : new Date();
			    };
			    $scope.toggleMin();

			    $scope.orderDetailOpen = function($event) {
			      $event.preventDefault();
			      $event.stopPropagation();

			      $scope.orderDetailOpened = true;
			    };

			    $scope.orderDateOptions = {
			      formatYear: 'yy',
			      startingDay: 1,
			      class: 'datepicker'
			    };

			    $scope.orderDetaiFormat = $scope.formats[0];
			}
			
			$scope.init = function() {
				
				$scope.orderId = $location.search().orderId;
				selectedOrder = $scope.orderId;
				$scope.getCustomer();
				$scope.getProducts();
				$scope.getStatus();
				$scope.orderDetailDatepickerInit();
				
				$scope.selectedStatus = '';
				$scope.currentRate = 0.0629;
				
				$scope.getOrderDetail();
				
			};
			$scope.getCustomer = function() {
				var $url = '/lizhi/customer/list.do';

				$http.get($url).then(function(resp) {
					$scope.customers = resp.data.aaData;
				});
			};
			
			$scope.getProducts = function() {
				var $url = '/lizhi/product/findbyCategoryIdOrBrandId.do';

				$http.get($url).then(function(resp) {
					$scope.products = resp.data.aaData;
				});
			};
			
			$scope.getStatus = function() {
				var $url = '/lizhi/status/findbyStatusType.do';

				$http.get($url , {
					params : {
						statusType : 2
					}
				}).then(function(resp) {
					$scope.statuses = resp.data.aaData;
				});
			};
			$scope.getOrderDetail = function() {
				
				$http.get('/lizhi/order/findbyOrderId.do',
				{
					params : {
						orderId :  $scope.orderId,
						customerId : $scope.selectedCustomer.customerId,
						status : $scope.selectedStatus
					}
				}).then(function(resp) {
					$scope.detailOptions = {
							data:  resp.data.aaData,
							aoColumns: [
								{ mData: 'orderId' , render: function (data) {
				                    return '<button class="btn m-b-xs btn-sm btn-info copyButton">复制</button>';
				                	} 
								},
								{ mData: 'orderId' },
								{ mData: 'customerName' },
								{ mData: 'productName' },
								{ mData: 'bookDate' },
								{ mData: 'count' },
								{ mData: 'bookPrice' },
								{ mData: 'estiBookPriceJpy' },
								{ mData: 'estiBookPrice' },
								{ mData: 'costPriceJpy' },
								{ mData: 'costPrice' },
								{ mData: 'bookPriceSum' },
								{ mData: 'profit' },
								{ mData: 'statusStr' },
								{ mData: 'status' , bVisible : false },
								{ mData: 'customerId' , bVisible : false},
								{ mData: 'orderDetailId' , bVisible : false},
								{ mData: 'productId' , bVisible : false}
							]
						};
					
					$scope.bandEvent();
				});
			};
			
			$scope.addNewDetail = function(attr){
				var table = $('#orderDetailTable').DataTable();
				var newObject;
				var data = {
					"customerId" :  $scope.orderDetail.customerId,
					"orderId" :  $scope.orderDetail.orderId,
					"orderDetailId" : $scope.orderDetail.orderDetailId,
					"productId" :$scope.orderDetail.productId,
					"count" : $scope.orderDetail.count,
					"bookDate" : $scope.orderDetail.bookDate,
					"bookPrice" : $scope.orderDetail.bookPrice,
					"estiBookPriceJpy" : $scope.orderDetail.estiBookPriceJpy,
					"bookRate" : $scope.currentRate,
					"costPriceJpy": $scope.orderDetail.costPriceJpy,
					"costRate": $scope.currentRate,
					"status" : $scope.orderDetail.status
				};
				
				var url = '/lizhi/order/addNewDetail.do';
				
				if($scope.updateDetail){
					url = '/lizhi/order/updateDetail.do';
				}

				$http.post(url, JSON.stringify(data))
					.success(function(response) {
						newObject = response.aaData;
						var order = {
							"orderDetailId" :  newObject[0].orderDetailId,
							"orderId" :  newObject[0].orderId,
							"customerId" :  newObject[0].customerId,
							"customerName" :  newObject[0].customerName,
							"productId" :  newObject[0].productId,
							"productName" :  newObject[0].productName,
							"bookDate" :  newObject[0].bookDate,
							"count" :  newObject[0].count,
							"bookPrice" :  newObject[0].bookPrice,
							"estiBookPriceJpy" :  newObject[0].estiBookPriceJpy,
							"estiBookPrice" :  newObject[0].estiBookPrice,
							"costPriceJpy" :  newObject[0].costPriceJpy,
							"costPrice" :  newObject[0].costPrice,
							"bookPriceSum" :  newObject[0].bookPriceSum,
							"profit" :  newObject[0].profit,
							"status" :  newObject[0].status,
							"statusStr" :  newObject[0].statusStr
							
						};
						if($scope.updateDetail){
							table.row('.selected').data(order).draw(false);
							$('#orderDetailTable .selected').removeClass('selected');
						}else{
							table.row.add(order).draw(false);
						}
						
						$scope.getOrderDetail();
						$scope.updateDetail = false;
						$scope.orderDetail = '';
					})
					.error(function(data, status, headers, config) {
					});					
			};
			
			$scope.changeProductItem = function(item){
				$scope.selectedProduct.productId = item.productId;
				$scope.changeItem();
			};
			
			$scope.changeCustomerItem = function(item){
				$scope.selectedCustomer.customerId = item.customerId;
				$scope.changeItem();
			};
			
			$scope.changeItem = function() {
				
				var detailTable = $('#orderDetailTable').DataTable();
				
				$scope.orderDetail = null;
				var $url = '/lizhi/order/findbyOrderId.do';
				
				$http.get($url ,{
						params : {
							customerId : $scope.selectedCustomer.customerId,
							productId :$scope.selectedProduct.productId,
							status : $scope.selectedStatus
							
						}})
					 .then(function(resp) {
						 
						 
						 detailTable.clear();
						 detailTable.rows.add(resp.data.aaData);
						 detailTable.draw();
						 
					
						 $scope.bandEvent();
					 });
			};
			
			$scope.bandEvent = function(){
				$('#orderDetailTable tbody').on( 'click', '.copyButton', function (evt) {
					var table = $('#orderDetailTable').DataTable();
					var orderDetail = table.row(this.parentElement.parentElement).data();
					
					$('#orderDetailTable .selected').removeClass('selected');
					
					$scope.$apply(function () {
						
//						$scope.newProduct = {
//				        	'productId':orderDetail.productId,
//				        };
						$scope.orderDetail={};
						$scope.orderDetail.customerId = orderDetail.customerId;
						$scope.orderDetail.bookDate = orderDetail.bookDate;
						//$scope.orderDetail = orderDetail;
						$scope.orderDetail.orderId = orderDetail.orderId;
//						$scope.orderDetail.product = $scope.newProduct;
						$scope.orderDetail.productId = orderDetail.productId;
				    });
					$scope.updateDetail = false;
					evt.stopPropagation(); //阻止事件冒泡
					return false;
				}); 
				
				$('#orderDetailTable tbody').on( 'click', 'tr', function (evt) {
					var table = $('#orderDetailTable').DataTable();
					var orderDetail = table.row(this).data();
					
					$('#orderDetailTable .selected').removeClass('selected');
					
					$(this).addClass('selected');
					
					$scope.$apply(function () {
						
						$scope.newProduct = {
				        	'productId':orderDetail.productId,
				        };
						$scope.orderDetail = orderDetail;
						$scope.orderDetail.customerId = orderDetail.customerId;
						$scope.orderDetail.bookDate = orderDetail.bookDate;
						$scope.orderDetail.orderId = orderDetail.orderId;
						$scope.orderDetail.product = $scope.newProduct;
				    });
					
					$scope.updateDetail = true;
			    });
				
				
				
			}
			
			$scope.clearButton = function () {
				
				$scope.updateDetail = false;
				$scope.orderDetail={};
			}
			
			$scope.init();

		} ]);
