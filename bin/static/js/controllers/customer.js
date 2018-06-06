'use strict';

/* Controllers */
// signin controller
app.controller('CustomerController', [
		'$scope',
		'$http',
		'$state',
		function($scope, $http, $state) {
			
			$scope.init = function(){
				var $url = '/lizhi/customer/list.do';
				
				$http.get($url).then(function(resp) {
					$scope.options = {
					     data: resp.data.aaData,
					     aoColumns: [
					      { mData: 'customerId' },
					      { mData: 'customerName' },
					      { mData: 'wxId' },
					      { mData: 'recommonder' },
					      { mData: 'phone' },
					      { mData: 'address' },
					      { mData: 'credit' }
					     ]
					 };
					
					$('#customerTable tbody').on( 'click', 'tr', function () {
						var table = $('#customerTable').DataTable();
						var customer = table.row(this).data();
						
						$(this).addClass('selected');
						
						$scope.$apply(function () {
					        $scope.newCustomer = customer;
					    });
						
						$scope.update = true
				    });
				});
				
			};
			$scope.addNew = function() {
				var table = $('#customerTable').DataTable();
				
				var newObject;

				var data = {
					"customerId" : $scope.newCustomer.customerId,
					'customerName' : $scope.newCustomer.customerName,
					'wxId' : $scope.newCustomer.wxId,
					'recommonder' : $scope.newCustomer.recommonder,
					'phone' : $scope.newCustomer.phone,
					'address' : $scope.newCustomer.address,
					'credit' : $scope.newCustomer.credit
				};
				
				var url = '/lizhi/customer/addNew.do';
				
				if($scope.update){
					url = '/lizhi/customer/update.do';
				}

				$http.post(url, JSON.stringify(data))
					.success(function(response) {
						newObject = response.aaData;
						var customer = {
							"customerId" : newObject[0].customerId,
							'customerName' : newObject[0].customerName,
							'wxId' : newObject[0].wxId,
							'recommonder' : newObject[0].recommonder,
							'phone' : newObject[0].phone,
							'address' : newObject[0].address,
							'credit' : newObject[0].credit
						};
						if($scope.update){
							table.row('.selected').data(customer).draw(false);
							$('#customerTable .selected').removeClass('selected');
						}else{
							table.row.add(customer).draw(false);
						}
						
						$scope.update = false;
						$scope.newCustomer = '';
					}).error(function(data, status, headers, config) {
					});
			};
			$scope.init();
			
			$('#clearButton').on( 'click', function () {
				
				$scope.$apply(function () {
					$scope.update = false;
					$scope.newCustomer = '';
			    });
			});

		} ]);
