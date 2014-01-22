'use strict';

javaTeamApp.controller('EventController',
    function EventController($scope){
        $scope.snippet='<span style="color: red">hi there</span>';
        $scope.event={
            name: 'Angular Boot Camp',
            date: '1/1/10',
            time: '10:10 am',
            location:{
                address: 'Melacha',
                city: 'Hashmonaim',
                province: 'CA'
            },
            imageUrl:'/img/angularjs-logo.png',
            sessions:[
                {
                    name: 'First Name',
                    creatorName:'Some Name',
                    duration:'1 hr',
                    level:'Advanced',
                    abstraction:'Some abstraction',
                    upVoteCount:0
                },
                {
                    name: 'Second Name',
                    creatorName:'Some Name',
                    duration:'30 mins',
                    level:'Introductory',
                    abstraction:'Some abstraction',
                    upVoteCount:0
                },
                {
                    name: 'Third Name',
                    creatorName:'Some Name',
                    duration:'2 hr',
                    level:'Intermediate',
                    abstraction:'Some abstraction',
                    upVoteCount:0
                }
            ]
        };
        $scope.upVoteSession=function(session){
            session.upVoteCount++;
        }
        $scope.downVoteSession=function(session){
            session.upVoteCount--;
        }
    }

);