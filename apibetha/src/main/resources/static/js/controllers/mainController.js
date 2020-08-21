customerManager.controller("mainController", function($scope, $location){

    $scope.goToRouting =  function (path) {
        $location.path(path);
        $location.replace();
    }

});