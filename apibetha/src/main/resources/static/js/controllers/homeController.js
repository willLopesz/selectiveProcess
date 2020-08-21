customerManager.controller("homeController", function($scope, $http, $location, $rootScope, $window){

    $scope.clients = [];
    $scope.insertBy = {};
    $scope.insertBy.id = $window.localStorage.getItem('user');

    $scope.navigate =  function (path) {
        $location.path(path);
    }

    $scope.getAllClients = function(){

        $http.post('/api/client/list', data = $scope.insertBy).then(
            function(response){

                $scope.clients = response.data;

            },
            function(response){

                $rootScope.changeLoading();
                alert(response.data.message);
                console.log(response.data);
                console.log(response.status);

            }

        );

    }

    $scope.deleteClient = function(id){

        if(confirm("Realmente deseja excluir o cliente?")){
            $http.get('/api/client/delete/' + id).then(
                function(response){
    
                    $scope.clients = response.data;
    
                },
                function(response){
    
                    $rootScope.changeLoading();
                    alert(response.data.message);
                    console.log(response.data);
                    console.log(response.status);
    
                }
    
            );
        }

    }

    $scope.getAllClients();

});