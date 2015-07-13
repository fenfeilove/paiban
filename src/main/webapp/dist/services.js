'use strict';

/* Services */

var paibanServices = angular.module('paibanServices', ['ngResource']);
/*

 paibanServices.factory('UserFac', [ '$resource', function($resource) {
 return $resource('user', {}, {
 query : {
 method : 'GET',
 params : {},
 isArray : false
 }
 });
 } ]);

 */

paibanServices.factory('EmplFac', ['$resource', function ($resource) {
    return $resource('employee.html',  //'/rssChannel/:channelId/items?sort=publishedDate,desc&size=12&page=:page',
        {}, {});
}]);

