'use strict';

/* App Module */

var paibanApp = angular.module('paibanApp',
    ['ngRoute', 'ngSanitize', 'ngAnimate', 'paibanControllers',
        'paibanServices'/*, 'readerAnimations','readerFilters' */]);

paibanApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/employee/:page', {
        templateUrl: 'partials/employee.htm',
        controller: 'EmployeeCtrl'
    }).when('/employee/', {
        redirectTo: '/employee/0'
    }).when('/department', {
        templateUrl: 'partials/department.htm',
        controller: 'DepartmentCtrl'
    }).when('/shift/:week/:deptno', {
        templateUrl: 'partials/shift.html',
        controller: 'ShiftCtrl'
    }).when('/shiftcfg', {
        templateUrl: 'partials/shiftcfg.html',
        controller: 'ShiftcfgCtrl'
    }).when('/stat/:m', {
        templateUrl: 'partials/stat.html',
        controller: 'StatCtrl'
    }).when('/search', {
        templateUrl: 'partials/search.html',
        controller: 'SearchCtrl'
    }).when('/about', {
        templateUrl: 'partials/help.html',
    }).otherwise({
        redirectTo: '/employee/0'
    });
}]);


var paibanControllers = angular.module('paibanControllers', []);
