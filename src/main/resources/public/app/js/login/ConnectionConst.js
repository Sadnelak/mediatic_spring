(function(){
"use strict";

var basique = "http://localhost:8080";

angular
	.module('login')
	.value('UrlConnection', {basic : basique,
							
							mRecherche : basique + "/api/medias",//get
							mRechercheT : basique + "/api/medias/taille",//get
							mAccession : basique + "/api/media.accession",//get
							mCreation : basique + "/api/media.creation",//post
							mModification : basique + "/api/media.modification",//post
							aRecherche : basique + "/api/adherent.recherche",//get
							aRechercheT : basique + "/api/adherent.recherche.taille",//get
							aAccession : basique + "/api/adherent.accession",//get
							aCreation : basique + "/api/adherent.creation",//post
							aModification : basique + "/api/adherent.modification",//post
							eAjout : basique + "/api/emprunt.ajout",//post
							cLogin : basique + "/api/users/authorities",//post
							cRight : basique + "/api/users/authorities",});//get
							
})()