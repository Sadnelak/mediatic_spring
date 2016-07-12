angular.module('mediatic', ['ngRoute', 'login', 'adherent', 'media', 'emprunt']);

angular
	.module('mediatic')
	.config(function($routeProvider,$httpProvider){

		
		$httpProvider.defaults.headers.post['Content-Type']='application/x-www-form-urlencoded; charset=UTF-8';
		$routeProvider.otherwise('/login');
		
		
	});

//.run(['$rootScope', '$location', '$cookieStore', '$http',
//      function ($rootScope, $location, $cookieStore, $http) {
//          // keep user logged in after page refresh
//          $rootScope.globals = $cookieStore.get('globals') || {};
//          if ($rootScope.globals.currentUser) {
//              $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
//          }
//    
//          $rootScope.$on('$locationChangeStart', function (event, next, current) {
//              // redirect to login page if not logged in
//              if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
//                  $location.path('/login');
//              }
//          });
//      }]);