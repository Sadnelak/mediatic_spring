"use strict";
angular.module('login').factory(
		'RequeteLogin',
		function($http, $routeParams, UrlConnection) {

			
			
			var s = {}
			s.getCRight = function() {
				var promise = $http.get(UrlConnection.cRight).then(
						function(resultat) {
							console.log(resultat.data)
							return promise;
						}, function() {
							console.error('error requete login get');
							return promise;
						});
				return promise;

			};			
			
			return s;
		});




angular.module('login').factory(
		'ServiceAuth',
		function($http, $routeParams, UrlConnection, RequeteLogin) {

			var connect = false;
			var AuthService = {};
			AuthService.isConnected = function(){
				return connect;
			};
			
			
			AuthService.connect = function(login, password){
				
				var config = {
					 headers: {
						   'Authorization': 'Basic ' +btoa(login+':'+password)
						 }
				}
				
				return $http.get(UrlConnection.cLogin, config).then(function(response) {
					
					var headerConnected;
					
					if (response.status === 200) {
						connect = true;
						$http.defaults.headers.common['Authorization']='Basic ' +btoa(login+':'+password);
						//reponse.data => droit de l'utilisateur => a stocker
						headerConnected = response.data; 
						// add in cookies
					} else {
						connect = false;
						$scope.errormessage = 'Identifiants inccorect';
					}
					return connect;
				})
				
				
//				return RequeteLogin.postCLogin({login : login, mdp: password}).then(function(response){
//					if(response){
//						//je suis authentifié
//						console.log("SConnection : 57 ",response);
//						var crypt = 'Basic ' +btoa(login+':'+password);
//						connect = true;
//						$http.defaults.headers.common['Authorization']=crypt;
//						return true;
//					}
//					//je ne suis pas authentifié
//					return false;
//				});
			};
			AuthService.disconnect = function(){
				connect = false;
				headerConnected = null;
				$http.defaults.headers.common['Authorization']='Basic ';
				// remove des cookies
			}
			return AuthService;

});



angular.module('login').factory(
		'RequeteMedia',
		function($http, $routeParams, UrlConnection) {

			var s = {};
			
			s.getMRecherche = function() {
				var promise = $http.get(UrlConnection.mRecherche).then(
						function(resultat) {
							console.log(resultat.data);
							return resultat.data;
						}, function() {
							console.error('Erreur recherche médias');
							console.log("result :", resultat);
							console.log("result :", resultat.data);
							return [];
						});
				return promise;

			};

//			s.getMRechercheT = function() {
//				var promise = $http.get(UrlConnection.mRechercheT).then(
//						function(resultat) {
//							console.log('[getMRechercheT] ',resultat.data.items);
//							console.log(resultat.data) //objet à 2 variables
//							return resultat.data.items;
//						}, function() {
//							console.error('Erreur recherche taille médias');
//							return -1;
//						});
//				return promise;
//
//			};
			
			s.getMAccession = function(ref) {
				var  config = {
						params : {
							id : ref
						}
						
				};
				var promise = $http.get(UrlConnection.mAccession,config).then(
						function(resultat) {
							console.log(resultat.data)
							return resultat.data;
						}, function() {
							console.error('Erreur accès fiche média');
							return {};
						});
				return promise;

			};
			
			s.postMCreation = function(monMedia) {
				var promise2 = $http.post(UrlConnection.mCreation, monMedia)
						.then(function(resultat2) {
							console.log(resultat2.data);
							console.log(resultat2);
							return true;
						}, function() {

							console.error('Erreur création média');
							return false;

						});
				return promise2;
			}
			
			s.postMModification = function(monMedia) {
				var promise2 = $http.post(UrlConnection.mModification, monMedia)
						.then(function(resultat2) {
							console.log(resultat2.data);
							console.log(resultat2);
							return true;
						}, function() {
							console.error('Erreur modification média');
							return false;
						});
				return promise2;
			}
	
			
			
			
			
			return s;
		});





angular.module('login').factory(
		'RequeteAdherent',
		function($http, $routeParams, UrlConnection) {

			var s = {};
			
			s.getARecherche = function() {
				var promise = $http.get(UrlConnection.aRecherche).then(
						function(resultat) {
							console.log(resultat.data);
							return resultat.data;
						}, function() {
							console.error('Erreur recherche adhérents');
							console.log("result :", resultat);
							console.log("result :", resultat.data);
							return [];
						});
				return promise;

			};

			s.getARechercheT = function() {
				var promise = $http.get(UrlConnection.aRechercheT).then(
						function(resultat) {
							console.log('[getARechercheT]',resultat.data.items)
							return resultat.data.items;
						}, function() {
							console.error('Erreur recherche taille adhérents');
							return -1;
						});
				return promise;

			};
			
			s.getAAccession = function(ref) {
				var  config = {
						params : {
							id : ref
						}	
				};
				var promise = $http.get(UrlConnection.aAccession,config).then(
						function(resultat) {
							console.log(resultat.data)
							return resultat.data;
						}, function() {
							console.log('Erreur accès adhérents');
							return {};
						});
				return promise;
			};
			
			s.postACreation = function(monAdherent) {
				var promise2 = $http.post(UrlConnection.aCreation, monAdherent)
						.then(function(resultat2) {
							console.log(resultat2.data);
							console.log(resultat2);
							return true;
						}, function(){
							console.log('Erreur création adhérents');
							return false;
						});
				return promise2;
			}
			
			s.postAModification = function(monAdherent) {
				var promise2 = $http.post(UrlConnection.aModification, monAdherent)
						.then(function(resultat2) {
							console.log(resultat2.data);
							console.log(resultat2);
							return true;
						}, function() {
							console.error('Erreur modification adhérents');
							return false;
						});
				return promise2;
			}
	
			
			return s;
		});

angular.module('login').factory(
		'RequeteEmprunt',
		function($http, $routeParams, UrlConnection) {

			var s = {};
			
			s.getEAjout = function(monEmprunt) {
				var promise2 = $http.post(UrlConnection.eAjout, monEmprunt)
						.then(function(resultat2) {
							console.log(resultat2.data);
							console.log(resultat2);
							return true;
						}, function() {
							console.error('error');
							return false;
						});
				return promise2;
			}
			return s;
		});


