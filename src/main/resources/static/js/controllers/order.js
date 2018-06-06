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
		function($scope, $http, $state) {
		    
			$scope.currentRate={};
			
			$scope.newCustomer={};
			$scope.newProduct = {};
			$scope.order={}
			$scope.orderDetail={};
			
			var selectedOrder ;
			
			$scope.onSelectCustomer = function(item){
				$scope.newCustomer = item;
			  }
			$scope.onSelectProduct = function(item){
				$scope.newProduct = item;
				$scope.orderDetail.estiBookPriceJpy=item.costPrice;
				$scope.orderDetail.costPriceJpy=item.costPrice;
				$scope.orderDetail.bookPrice=item.salePrice;
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
			
//			$scope.orderDetailDatepickerInit = function(){
//
//				$scope.orderDetailToday = function() {
//			      $scope.orderDetail.bookDate = new Date();
//			    };
//			    $scope.orderDetailToday();
//
//			    $scope.orderDetailClear = function () {
//			      $scope.orderDetail.bookDate = null;
//			    };
//
//			    // Disable weekend selection
//			    $scope.disabled = function(date, mode) {
//			      return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
//			    };
//
//			    $scope.toggleMin = function() {
//			      $scope.minDate = $scope.minDate ? null : new Date();
//			    };
//			    $scope.toggleMin();
//
//			    $scope.orderDetailOpen = function($event) {
//			      $event.preventDefault();
//			      $event.stopPropagation();
//
//			      $scope.orderDetailOpened = true;
//			    };
//
//			    $scope.orderDateOptions = {
//			      formatYear: 'yy',
//			      startingDay: 1,
//			      class: 'datepicker'
//			    };
//
//			    $scope.orderDetaiFormat = $scope.formats[0];
//			}
			
			$scope.init = function() {
				
				$scope.getCustomer();
				$scope.getProducts();
				$scope.getStatus();
				$scope.orderDatepickerInit();
//				$scope.orderDetailDatepickerInit();
				$scope.selectedCustomer = 0;
				$scope.selectedStatus = '';
				$scope.currentRate = 0.0629;
				
				$scope.getOrder();
				
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
						statusType : 1
					}
				}).then(function(resp) {
					$scope.statuses = resp.data.aaData;
				});
			};
			
			$scope.getOrder = function() {
				$http.get('/lizhi/order/findOrderByCustomerAndStatus.do',
				{
					params : {
						customerId : $scope.selectedCustomer,
						status : $scope.selectedStatus
					}
				}).then(function(resp) {
					$scope.options = {
						data:  resp.data.aaData,
						aoColumns: [
							{ mData: 'orderId',render: function (data) {
			                    return '<a class="btn m-b-xs btn-sm btn-info orderDetailButton" href="#/app/table/orderdetailtable?orderId='+data+'" >详细信息</a>';
			                	} 
							},
							{ mData: 'customerName' },
							{ mData: 'wxid' },
							{ mData: 'bookDate' },
							{ mData: 'deposit' },
							{ mData: 'payment' },
							{ mData: 'postprice' },
							{ mData: 'remaindprice' },
							{ mData: 'sumprice' },
							{ mData: 'sumprofit' },
							{ mData: 'statusStr' },
							{ mData: 'status' , bVisible : false},
							{ mData: 'customerId' , bVisible : false}
						],
					};
					
					$('#orderTable tbody').on( 'click', 'tr', function () {
						var table = $('#orderTable').DataTable();
						var order = table.row(this).data();
						
						$('#orderTable .selected').removeClass('selected');
						
						$(this).addClass('selected');
						
						$scope.$apply(function () {
							$scope.newCustomer = {
					        	'customerId':order.customerId,
					        };
							
							$scope.order = order;
							$scope.order.customer = $scope.newCustomer;
							selectedOrder = order.orderId;
					    });
						
						$scope.updateOrder = true
//						$scope.getOrderDetail();
				    });
					
//					$('#orderTable tbody').on( 'click', '.orderDetailButton' , function () {
//						var table = $('#orderTable').DataTable();
//						var order = table.row(this).data();
////						window.location.href='/orderdetailtable?orderId='+ order.orderId;
////						this.router.navigate(['/orderdetailtable', order.orderId]);
//				    });
				});
			};
			
			$scope.addNewOrder = function(attr){
				var table = $('#orderTable').DataTable();
				var newObject;
				var data = {
					"orderId" : $scope.order.orderId,
					"customerId" : $scope.newCustomer.customerId,
					"bookDate" :$scope.order.bookDate,
					"deposit" : $scope.order.deposit,
					"payment" : $scope.order.payment,
					"postprice" : $scope.order.postprice,
					"remaindprice" : $scope.order.remaindprice,
					"paymentType": $scope.order.paymentType,
					"depositType": $scope.order.depositType,
					"status" : $scope.order.status
				};
				
				var url = '/lizhi/order/addNew.do';
				
				if($scope.updateOrder){
					data.customerId = $scope.order.customerId;
					url = '/lizhi/order/update.do';
				}

				$http.post(url, JSON.stringify(data))
					.success(function(response) {
						newObject = response.aaData;
						var order = {
							"orderId" : newObject[0].orderId,
							"customerId" : newObject[0].customerId,
							"customerName" : newObject[0].customerName,
							"wxid" : newObject[0].wxid,
							"bookDate" : newObject[0].bookDate,
							"deposit" : newObject[0].deposit,
							"depositType" : newObject[0].depositType,
							"payment" : newObject[0].payment,
							"paymentType" : newObject[0].paymentType,
							"postprice" : newObject[0].postprice,
							"remaindprice" : newObject[0].remaindprice,
							"sumprice" : newObject[0].sumprice,
							"sumprofit" : newObject[0].sumprofit,
							"status" : newObject[0].status,
							"statusStr" : newObject[0].statusStr
						};
						if($scope.updateOrder){
							table.row('.selected').data(order).draw(false);
							$('#orderTable .selected').removeClass('selected');
						}else{
							table.row.add(order).draw(false);
						}
						
						$scope.updateOrder = false;
						$scope.order = '';
						$scope.orderDetail = {};
						$scope.orderDetail.orderId = "";
						$scope.orderDetail.product = {};
						
//						var orderDetailTable = $.fn.dataTable.fnTables(true)[1];
//						var detailTable = $(orderDetailTable).DataTable();
//						detailTable.clear();
//						detailTable.draw();
				})
				.error(function(data, status, headers, config) {
				});					
			};
			
//			$scope.getOrderDetail = function() {
//				var orderDetailTable = $.fn.dataTable.fnTables(true)[1];
//				var table = $(orderDetailTable).DataTable();
//				
//				$http.get('/lizhi/order/findbyOrderId.do',
//				{
//					params : {
//						orderId :  $scope.order.orderId
//					}
//				}).then(function(resp) {
//					table.clear();
//					table.rows.add(resp.data.aaData);
//					table.draw();
//					
//					$('#orderDetailTable tbody').on( 'click', 'tr', function () {
//						var table = $('#orderDetailTable').DataTable();
//						var orderDetail = table.row(this).data();
//						
//						$('#orderDetailTable .selected').removeClass('selected');
//						
//						$(this).addClass('selected');
//						
//						$scope.$apply(function () {
//							
//							$scope.newProduct = {
//					        	'productId':orderDetail.productId,
//					        };
//							$scope.orderDetail = orderDetail;
//							$scope.orderDetail.orderId = selectedOrder;
//							$scope.orderDetail.product = $scope.newProduct;
//					    });
//						
//						$scope.updateDetail = true
//				    });
//				});
//			};
//			
//			$scope.addNewDetail = function(attr){
//				var table = $('#orderDetailTable').DataTable();
//				var newObject;
//				var data = {
//					"orderId" : selectedOrder,
//					"orderDetailId" : $scope.orderDetail.orderDetailId,
//					"productId" :$scope.orderDetail.productId,
//					"count" : $scope.orderDetail.count,
//					"bookDate" : $scope.orderDetail.bookDate,
//					"bookPrice" : $scope.orderDetail.bookPrice,
//					"estiBookPriceJpy" : $scope.orderDetail.estiBookPriceJpy,
//					"bookRate" : $scope.currentRate,
//					"costPriceJpy": $scope.orderDetail.costPriceJpy,
//					"costRate": $scope.currentRate,
//					"state" : $scope.orderDetail.state
//				};
//				
//				var url = '/lizhi/order/addNewDetail.do';
//				
//				if($scope.updateDetail){
//					url = '/lizhi/order/updateDetail.do';
//				}
//
//				$http.post(url, JSON.stringify(data))
//					.success(function(response) {
//						newObject = response.aaData;
//						var order = {
//							"orderDetailId" :  newObject[0].orderDetailId,
//							"orderId" :  newObject[0].orderId,
//							"productId" :  newObject[0].productId,
//							"productName" :  newObject[0].productName,
//							"bookDate" :  newObject[0].bookDate,
//							"count" :  newObject[0].count,
//							"bookPrice" :  newObject[0].bookPrice,
//							"estiBookPriceJpy" :  newObject[0].estiBookPriceJpy,
//							"estiBookPrice" :  newObject[0].estiBookPrice,
//							"costPriceJpy" :  newObject[0].costPriceJpy,
//							"costPrice" :  newObject[0].costPrice,
//							"bookPriceSum" :  newObject[0].bookPriceSum,
//							"profit" :  newObject[0].profit,
//							"state" :  newObject[0].state
//						};
//						if($scope.updateDetail){
//							table.row('.selected').data(order).draw(false);
//							$('#orderDetailTable .selected').removeClass('selected');
//						}else{
//							table.row.add(order).draw(false);
//						}
//						
//						$scope.getOrderDetail();
//						$scope.updateDetail = false;
//						$scope.orderDetail = '';
//					})
//					.error(function(data, status, headers, config) {
//					});					
//			};
			
			$scope.changeItem = function() {
				var orderTable = $.fn.dataTable.fnTables(true)[0];
				var table = $(orderTable).DataTable();
				
				var orderDetailTable = $.fn.dataTable.fnTables(true)[1];
				var detailTable = $(orderDetailTable).DataTable();
				
				
				var $url = '/lizhi/order/findOrderByCustomerAndStatus.do';
				
				$http.get($url ,{
						params : {
							customerId : $scope.selectedCustomer,
							status : $scope.selectedStatus
						}})
					 .then(function(resp) {
						 
						 $scope.order = null;
						 
						 table.clear();
						 table.rows.add(resp.data.aaData);
						 table.draw();
//						 detailTable.draw();
					
					 $('#orderTable tbody').on( 'click', 'tr', function () {
						var table = $('#orderTable').DataTable();
						var order = table.row(this).data();
						
						$('#orderTable .selected').removeClass('selected');
//						$('#orderDetailTable .selected').removeClass('selected');
						
						$(this).addClass('selected');
						
						$scope.$apply(function () {
					        $scope.order = order;
					    });
						
						$scope.updateOrder = true;
//						$scope.getOrderDetail();
				    });
				});
			};
			
			$scope.init();
			
//			$scope.goToOrderDetails = function(id) {
//				  this.router.navigate(['/orderdetailtable', id]);
//				};

		} ]);
