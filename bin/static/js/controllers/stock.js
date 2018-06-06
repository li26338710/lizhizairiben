'use strict';

/* Controllers */
// signin controller
app.controller('OrderController', [
		'$scope',
		'$http',
		'$state',
		function($scope, $http, $state) {
			
			$scope.init = function() {
				$scope.getCustomer();
				$scope.selectedCustomer = 0;
				$scope.selectedState = '';
				$scope.getOrder();
				
			};
			$scope.getCustomer = function() {
				var $url = '/lizhi/customer/list.do';

				$http.get($url).then(function(resp) {
					$scope.customers = resp.data.aaData;
				});
			};
			$scope.getOrder = function() {
				var $url = '/lizhi/order/list.do';

				$http.get($url).then(function(resp) {
					$scope.orders = resp.data.aaData;
				});
			};
			$scope.changeItem = function() {
				$http.get('/lizhi/order/findOrderByCustomerAndState.do',
						{
							params : {
								customerId : $scope.selectedCustomer,
								state : $scope.selectedState
							}
						}).then(function(resp) {
							$scope.orders = resp.data.aaData;
							$scope.selectedCustomer = customerId;
							$scope.selectedBrand = state;
							
							
				});
			};
			$scope.getOrderDetail = function(order) {
				$http.get('/lizhi/order/findbyOrderId.do',
						{
							params : {
								orderId : order.orderId
							}
						}).then(function(resp) {
							$scope.orderDetails = resp.data.aaData;
				});
			};
			
			$scope.addNew = function(attr){
				alert(attr.brandName);
				alert(attr.url);
					
			};
			$scope.editItem = function(order) {
				order.editing = true;
			};

			$scope.doneEditing = function(order) {
				order.editing = false;
			};
			
			$scope.init();

		} ]);
