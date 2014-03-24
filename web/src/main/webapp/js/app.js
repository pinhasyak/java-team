'use strict';

var eventsApp = angular.module('eventsApp', ['ngResource','ngRoute'])
    .config(function($routeProvider){
        $routeProvider.when('/SampleDirective',
            {
                templateUrl:'templates/SampleDirective.html',
                controller: 'SampleDirectiveController'
            });
        $routeProvider.when('/editTeam',
            {
                templateUrl:'templates/EditTeam.html',
                controller: 'EditTeamController'

            });
        $routeProvider.when('/events',
            {
               templateUrl:'templates/EventList.html',
                controller:'EventListController'
            });
        $routeProvider.when('/teams',
            {
            templateUrl:'templates/Teams.html',
            controller:'TeamDataController'
            });
        $routeProvider.when('/event/:eventId',
            {
                templateUrl:'templates/EventDetails.html',
                controller:'EventController'
            });
        $routeProvider.when('/user',
            {
                templateUrl:'templates/UserDetails.html',
                controller:'UserController'
            });

//      $routeProvider.otherwise({redirectTo:'/events'});
    });