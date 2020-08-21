customerManager.controller("loginController", function($scope, $http, $location, $rootScope, $window){

    $scope.user = {};
    $scope.login = function(){

        $scope.loginForm.document.$setTouched();
        $scope.loginForm.password.$setTouched();

        if ($scope.loginForm.$invalid) {
            return;
        }

        $rootScope.changeLoading();

        $http.post('api/user/login', data=$scope.user).then(

            function (response){
                
                $window.localStorage.setItem('user',response.data.id)

                $rootScope.changeLoading();

                $scope.loginForm.document.$setUntouched();
                $scope.loginForm.password.$setUntouched();
                
                $scope.loginForm.document.$setPristine();
                $scope.loginForm.password.$setPristine();
            
                $scope.user = {};

                $location.path('/home');
                $location.replace();
                
            }, 
            function (response) {
                
                $rootScope.changeLoading();

                alert(response.data.message);
                console.log(response.data);
                console.log(response.status);

            }
        
        );

    };

});