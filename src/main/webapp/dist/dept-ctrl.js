'use strict';

paibanControllers.controller('DepartmentCtrl', ['$scope', '$routeParams',
    '$http', '$route', function ($scope, $routeParams,  $http, $route) {
        $('#navLink>li').removeClass();
        $('#navLink>li:nth-child(2)').addClass('active');


        $http.get("department").success(function (data) {
            $scope.allDepartment = data;
        });
        $scope.add = function () {
            $scope.selectedDept = null;
            $('#deptModal').modal('show');
        }

        $scope.edit = function (dept) {
            $scope.selectedDept = JSON.parse(JSON.stringify(dept));
            $('#deptModal').modal('show');
        }

        $('#deptModal').modal('hide');

        $scope.save = function () {
            var dept = $scope.selectedDept;
            if (dept) {
                console.log(dept);
                var url = 'department/'+(dept.deptno?'edit':'add');
                $http.post(url, dept).success(function () {
                    $('#deptModal').modal('hide');
                    $('#deptModal').on('hidden.bs.modal', function (e) {
                        $route.reload();
                    })

                }).error();
            }
        }


    }]);
