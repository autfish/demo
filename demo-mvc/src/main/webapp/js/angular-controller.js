var app = angular.module("demoApp", ['ngCookies']);

app.controller('firstController', function($scope) {
    //$scope.name = "John Doe";
    $scope.save = function() {
        alert($scope.name);
    }
});