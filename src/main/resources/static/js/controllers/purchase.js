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
app.controller('PurchaseController', [
		'$scope',
		'$http',
		'$state',
		function($scope, $http, $state) {
			
			$scope.newPurchase={};
			$scope.formats = ['yyyy-MM-dd','dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
			$scope.purchaseDatepickerInit = function(){

				$scope.purchaseToday = function() {
			      $scope.newPurchase.purchaseDate = new Date();
			    };
			    $scope.purchaseToday();

			    $scope.purchaseClear = function () {
			      $scope.newPurchase.purchaseDate = null;
			    };

			    // Disable weekend selection
			    $scope.disabled = function(date, mode) {
			      return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
			    };

			    $scope.toggleMin = function() {
			      $scope.minDate = $scope.minDate ? null : new Date();
			    };
			    $scope.toggleMin();

			    $scope.purchaseOpen = function($event) {
			      $event.preventDefault();
			      $event.stopPropagation();

			      $scope.purchaseOpened = true;
			    };

			    $scope.purchaseDateOptions = {
			      formatYear: 'yy',
			      startingDay: 1,	
			      class: 'datepicker'
			    };

			    $scope.purchaseFormat = $scope.formats[0];
			}
			
			$scope.init = function() {
				$scope.getMarket();
				$scope.selectedMarket = 0;
				$scope.purchaseDatepickerInit();
				$scope.getPurchase();
				//$scope.changeItem();
				
			};
			$scope.getMarket = function() {
				var $url = '/lizhi/market/findMarket.do';

				$http.get($url).then(function(resp) {
					$scope.markets = resp.data.aaData;
				});
			};
			$scope.changeItem = function() {
				var purchaseTable = $.fn.dataTable.fnTables(true)[0];
				var table = $(purchaseTable).DataTable();
				
				$http.get('/lizhi/purchase/findPurchaseByBrandOrDate.do',
				{
					params : {
						marketId : $scope.selectedMarket,
						startDate : $scope.startDate
					}
				}).then(function(resp) {

					$scope.newPurchase = null;
					 
					 table.clear();
					 table.rows.add(resp.data.aaData);
					 table.draw();
					
					$('#purchaseTable tbody').on( 'click', 'tr', function () {
						var table = $('#purchaseTable').DataTable();
						var purchase = table.row(this).data();
						
						$('#purchaseTable .selected').removeClass('selected');
						
						$(this).addClass('selected');
						
						$scope.$apply(function () {
							 $scope.newPurchase = purchase;
					    });
						
						$scope.update = true
				    });
				});
			};
			
			
			$scope.addNew = function() {
				var table = $('#purchaseTable').DataTable();
				var newObject;
				var data = {
					"marketId" : $scope.newPurchase.marketId,
					"price" :$scope.newPurchase.price,
					"rate" : $scope.newPurchase.rate,
					"score" : $scope.newPurchase.score,
					"purchaseDate" : $scope.newPurchase.purchaseDate,
					"purchaseType" : $scope.newPurchase.purchaseType,
					"cardNo" : $scope.newPurchase.cardNo,
					"purchaseId" : $scope.newPurchase.purchaseId
				};
				
				var url = '/lizhi/purchase/addNew.do';
				
				if($scope.update){
					url = '/lizhi/purchase/update.do';
				}

				$http.post(url, JSON.stringify(data))
					.success(function(response) {
						newObject = response.aaData;
						var purchase = {
							"marketName" : newObject[0].marketName,
							"price" : newObject[0].price,
							"rate" : newObject[0].rate,
							"score" : newObject[0].score,
							"purchaseDate" : newObject[0].purchaseDate,
							"priceRmb" : newObject[0].priceRmb,
							"purchaseType" : newObject[0].purchaseType,
							"cardNo" : newObject[0].cardNo,
							"purchaseId" : newObject[0].purchaseId,
							"marketId" : newObject[0].marketId
						};
						if($scope.update){
							table.row('.selected').data(purchase).draw(false);
							$('#purchaseTable .selected').removeClass('selected');
						}else{
							table.row.add(purchase).draw(false);
						}
						
						$scope.update = false;
						$scope.newPurchase = {};
						$scope.newPurchase.market = {'marketId':'','marketName':''};
					})
					.error(function(data, status, headers, config) {
					});
			};
			
			
			
			$scope.getPurchase = function(purchase) {
				$http.get('/lizhi/purchase/findPurchaseByBrandOrDate.do',
						{
							params : {
								marketId : $scope.selectedMarket,
								startDate : $scope.startDate
							}
						}).then(function(resp) {
							$scope.options = {
								     data: resp.data.aaData,
								     aoColumns: [
									      { mData: 'purchaseId',render: function (data) {
									    	  return '<a class="btn m-b-xs btn-sm btn-info purchaseDetailButton" href="#/app/table/purchasedetail?purchaseId='+data[0]+'" >详细信息</a>';
						                    }
									      },
									      { mData: 'marketName' },
									      { mData: 'price' },
									      { mData: 'rate' },
									      { mData: 'priceRmb' },
									      { mData: 'score' },
									      { mData: 'purchaseDate' },
									      { mData: 'purchaseType' },
									      { mData: 'cardNo' },
									      { mData: 'marketId' , bVisible : false},
								     ]
								 };
								
								$('#purchaseTable tbody').on( 'click', 'tr', function () {
									var table = $('#purchaseTable').DataTable();
									var purchase = table.row(this).data();
									
									$('#purchaseTable .selected').removeClass('selected');
									
									$(this).addClass('selected');
									
									$scope.$apply(function () {
										 $scope.newPurchase = purchase;
								    });
									
									$scope.update = true
							    });
							});
				};
			
			$scope.editItem = function(purchase) {
				purchase.editing = true;
			};

			$scope.doneEditing = function(purchase) {
				purchase.editing = false;
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
			
			$scope.init();

		} ]);
