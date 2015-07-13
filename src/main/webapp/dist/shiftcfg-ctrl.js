'use strict';

paibanControllers.controller('ShiftcfgCtrl', [ '$scope', '$routeParams',
		'$http', '$route', function($scope, $routeParams, $http, $route) {
			$('#navLink>li').removeClass();
			$('#navLink>li:nth-child(3)').addClass('active');

		     $('#datepicker').datepicker({
		    	    format: 'yyyy-mm',
		    	    orientation: "top left"
		    	})
			
			
			$scope.mode = 1;
//			$scope.year = new Date().getFullYear();
//			$scope.month = new Date().getMonth() - (-1);
			$scope.message = '';
			$scope.submit = function() {
				$http.post("shiftcfg", {
					year : $scope.searchDate.substr(0,4),
					month : $scope.searchDate.substr(5,2),
					mode : $scope.mode
				}).success(function(data) {
					alert(data.ok);
					$scope.message = data.ok;
				}).error(function() {
					alert("error occured");
					$scope.message = "error occured!!"
				});
			}

		} ]);
