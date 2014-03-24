'use strict';

eventsApp.controller('EventController',
    function EventController($scope, eventData,$routeParams,$route,$http) {
    	$scope.sortorder = 'name';
        $scope.event = eventData.getEvent($routeParams.eventId);

        $scope.event
        console.log($route.current.foo);
        $scope.reload = function(){
          $route.reload();
        };
        $scope.upVoteSession = function(session) {
            session.upVoteCount++;
        };

        $scope.downVoteSession = function(session) {
            session.upVoteCount--;
        };
    }
);
 