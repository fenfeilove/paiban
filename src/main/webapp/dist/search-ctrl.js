'use strict';

paibanControllers.controller('SearchCtrl', [
		'$scope',
		'$routeParams',
		'$http',
		'$route',
		function($scope, $routeParams, $http, $route) {
			$('#navLink>li').removeClass();
			$('#navLink>li:nth-child(6)').addClass('active');

			
			
			
			
		     $http.get("department").success(function (data) {
		            $scope.allDepartment = data;
});
			
			
		     $('#datepicker').datepicker({
		    	    format: 'yyyy-mm-dd',
		    	    orientation: "top left"
		    	})
		     
			$scope.search = function() {
				var d = $scope.searchDate;
				$http.get(
						"api?date=" + d)
						.success(function(data) {
							data.forEach(function (empl) {
				                for (var i in $scope.allDepartment) {
				                    if ($scope.allDepartment[i].deptno == empl.deptno) {
				                        empl.deptName = $scope.allDepartment[i].dname;
				                        break;
				                    }
				                }
				            });
							$scope.rows = data;
						});
			}

		} ]);
