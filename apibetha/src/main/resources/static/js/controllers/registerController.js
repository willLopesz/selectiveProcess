customerManager.controller("registerController", function($scope, $http, $location, $rootScope, $window){

    $scope.user = {};
    $scope.confirmPassword = "";
    $scope.registerUser = function(){
        
        //sweetAlert.swal("Good job!", "You clicked the button!", "success");

        $scope.registerForm.name.$setTouched();
        $scope.registerForm.document.$setTouched();
        $scope.registerForm.password.$setTouched();
        $scope.registerForm.confirmPassword.$setTouched();

        if ($scope.registerForm.$invalid) {
            return;
        }

        $rootScope.changeLoading();

        $http.post('api/user', data=$scope.user).then(

            function (response){

                $rootScope.changeLoading();
                $scope.registerForm.name.$setUntouched();
                $scope.registerForm.document.$setUntouched();
                $scope.registerForm.password.$setUntouched();
                $scope.registerForm.confirmPassword.$setUntouched();
                $scope.registerForm.name.$setPristine();
                $scope.registerForm.document.$setPristine();
                $scope.registerForm.password.$setPristine();
                $scope.registerForm.confirmPassword.$setPristine();
                $scope.confirmPassword = "";
                $scope.user = {};
                alert("Registrado com sucesso!");

                $location.path('/login');
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

customerManager.directive("compareTo", function ()  {  

      return {  

          require: "ngModel",  
          scope:  {  

              repeatPassword: "=compareTo"  

          },  

          link: function (scope, element, attributes, paramval)  {  
              paramval.$validators.compareTo = function (val)  {  

                  return val == scope.repeatPassword;  

              };  

              scope.$watch("repeatPassword", function ()  {  

                  paramval.$validate();  

              });  

          }  

      };  

  });