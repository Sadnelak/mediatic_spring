(function(){
"use strict";

var basique = "http://localhost:8080";

angular
	.module('login')
	.value('UrlConnection', {basic : basique,
							
							mRecherche : basique + "/api/medias",//get
							mRechercheT : basique + "/api/medias/taille",//get
							mAccession : basique + "/api/medias.accession",//get
							mCreation : basique + "/api/medias",//post
							mModification : basique + "/api/medias/modification",//post
							aRecherche : basique + "/api/adherents",//get
							aRechercheT : basique + "/api/adherents/taille",//get
							aAccession : basique + "/api/adherents",//get
							aCreation : basique + "/api/adherents",//post
							aModification : basique + "/api/adherents/modification",//post
							eAjout : basique + "/api/emprunt.ajout",//post
							cLogin : basique + "/api/users/authorities",//post
							cRight : basique + "/api/users/authorities",});//get
							
})()