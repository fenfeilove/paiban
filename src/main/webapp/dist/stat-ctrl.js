'use strict';

paibanControllers.controller('StatCtrl', [ '$scope', '$routeParams', '$http',
		'$route', function($scope, $routeParams, $http, $route) {
			$('#navLink>li').removeClass();
			$('#navLink>li:nth-child(5)').addClass('active');

	        $http.get("department").success(function (data) {
	
	        	
	        	
	            $scope.allDepartment = data;
	        });
			
			
			
			$scope.m = $routeParams.m - 0;

			
			$scope.d=new Date();
			$scope.d.setMonth($scope.d.getMonth()+$scope.m);
			
			
			
			$http.get("statistics?m=" + $routeParams.m).success(function(data) {
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

		} ]);
