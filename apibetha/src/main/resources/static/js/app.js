var customerManager = angular.module("customerManager", ['ngRoute', 'ngMask', 'ngStorage']);

customerManager.config(function($routeProvider, $locationProvider) {
    
  $locationProvider.hashPrefix('');
  
    $routeProvider.when("/home", {
      templateUrl : "pages/homePage.html",
      controller : "homeController"
    }).when("/login", {
      templateUrl : "pages/loginPage.html",
      controller : "loginController",
    }).when("/register", {
      templateUrl : "pages/registerPage.html",
      controller : "registerController"
    }).when("/view-customer", {
      templateUrl : "pages/viewCustomerPage.html",
    }).when("/register-customer", {
      templateUrl : "pages/registerCustomerPage.html",
      controller: "registerCustomerController"
    }).otherwise({redirectTo : '/login'});

    //$locationProvider.html5Mode(true);

  });

  customerManager.run(['$rootScope', function($rootScope, $location) {

    $rootScope.isLoading = false;

    $rootScope.changeLoading = function(){

      $rootScope.isLoading = !$rootScope.isLoading;

    }

  }]);