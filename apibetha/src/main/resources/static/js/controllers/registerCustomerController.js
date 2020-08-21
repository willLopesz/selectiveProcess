customerManager.controller("registerCustomerController", function($scope, $http, $location, $rootScope, $window){

    $scope.customer = {};
    
    $scope.address = {
        code: 0,
        address: '',
        number: '',
        cep: '',
        district: '',
        city: '',
        state: '',
        country: '',
        type: ''
    };
    $scope.phone = {
        code: 0,
        name: '',
        phone: '',
        type: ''
    }

    $scope.mainPhone = {code: 0};
    $scope.mainAddress = {code: 0};

    $scope.addresses = [$scope.address];
    $scope.phones = [$scope.phone];

    $scope.verifyAddresses = function(){
        if($scope.addresses.length == 1)
            return false;
        
        if($scope.addresses.length > 1)
            return true;
    }
    $scope.verifyPhones = function(){
        if($scope.phones.length == 1)
            return false;
        
        if($scope.phones.length > 1)
            return true;
    }

    $scope.addAddress = function(){
        var i = $scope.addresses.length;
        var a = $scope.addresses[i-1];
        $scope.addresses.push({code:a.code + 1});
    }
    $scope.addPhone = function(){
        var i = $scope.phones.length;
        var p = $scope.phones[i-1];
        $scope.phones.push({code:p.code + 1});
    }

    $scope.removeAddress = function(index) { 
        var a = $scope.addresses.splice(index, 1);
        if(a[0].code == $scope.mainAddress.code){
            $scope.mainAddress.code = $scope.addresses[0].code;
        }
    }
    $scope.removePhone = function(index) { 
        var p = $scope.phones.splice(index, 1);
        if(p[0].code == $scope.mainPhone.code){
            $scope.mainPhone.code = $scope.phones[0].code;
        }
    }

    $scope.saveNewClient = function(){
        
        $scope.registerForm.name.$setTouched();
        $scope.registerForm.document.$setTouched();
        $scope.registerForm.address.$setTouched();
        $scope.registerForm.number.$setTouched();
        $scope.registerForm.cep.$setTouched();
        $scope.registerForm.district.$setTouched();
        $scope.registerForm.city.$setTouched();
        $scope.registerForm.state.$setTouched();
        $scope.registerForm.country.$setTouched();
        $scope.registerForm.nickname.$setTouched();
        $scope.registerForm.phone.$setTouched();

        if ($scope.registerForm.$invalid) 
            return;
        
        $rootScope.changeLoading();

        $scope.customer.insertBy = {};

        $scope.customer.insertBy.id = $window.localStorage.getItem('user');

        $http.post('api/client', data=$scope.customer).then(

            function (response){

                console.log(response);

                $scope.saveAddresses(response.data);
                
            }, 
            function (response) {
                
                $rootScope.changeLoading();
                alert(response.data.message);
                console.log(response.data);
                console.log(response.status);

            }
        
        );

    }

    $scope.saveAddresses = function(client){

        angular.forEach($scope.addresses, function(value, key) {

            $scope.addresses[key].clientId = {};
            $scope.addresses[key].clientId.id = client.id;

            var full = value.address + ", Nº" + value.number + ", " + value.cep + ", bairro " + value.district + ", " + value.city + ", " + value.state + ", " + value.country;

            $scope.addresses[key].full = full;
            
            if($scope.addresses[key].code == $scope.mainAddress.code){

                $scope.addresses[key].type = true;

            }else{

                $scope.addresses[key].type = false;

            }

        });

        console.log($scope.addresses)

        $http.post('/api/address', data = $scope.addresses).then(
            function(response){

                $scope.savePhones(client);

            },
            function(response){

                $rootScope.changeLoading();
                alert(response.data.message);
                console.log(response.data);
                console.log(response.status);

            }

        );

    }

    $scope.savePhones = function (client) {
        
        angular.forEach($scope.phones, function(value, key) {

            $scope.phones[key].clientId = {};
            $scope.phones[key].clientId.id = client.id;

            if($scope.phones[key].code == $scope.mainAddress.code){

                $scope.phones[key].type = true;

            }else{

                $scope.phones[key].type = false;

            }

        });

        console.log($scope.phones);

        $http.post('/api/phone', data = $scope.phones).then(

            function(response){

                $scope.registerForm.name.$setUntouched();
                $scope.registerForm.document.$setUntouched();
                $scope.registerForm.address.$setUntouched();
                $scope.registerForm.number.$setUntouched();
                $scope.registerForm.cep.$setUntouched();
                $scope.registerForm.district.$setUntouched();
                $scope.registerForm.city.$setUntouched();
                $scope.registerForm.state.$setUntouched();
                $scope.registerForm.country.$setUntouched();
                $scope.registerForm.nickname.$setUntouched();
                $scope.registerForm.phone.$setUntouched();

                $scope.registerForm.name.$setPristine();
                $scope.registerForm.document.$setPristine();
                $scope.registerForm.address.$setPristine();
                $scope.registerForm.number.$setPristine();
                $scope.registerForm.cep.$setPristine();
                $scope.registerForm.district.$setPristine();
                $scope.registerForm.city.$setPristine();
                $scope.registerForm.state.$setPristine();
                $scope.registerForm.country.$setPristine();
                $scope.registerForm.nickname.$setPristine();
                $scope.registerForm.phone.$setPristine();
                alert("Clente registrado com sucesso!")
                $rootScope.changeLoading();
                $location.path('/home');
                $location.replace();
            },
            function(response){

                $rootScope.changeLoading();
                alert(response.data.message);
                console.log(response.data);
                console.log(response.status);

            }

        );

    }

});