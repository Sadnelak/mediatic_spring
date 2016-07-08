package fr.iocean.application.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adherent implements IOEntity {

	
			@Id
			private Long id;
			private Adresse adresse= new Adresse();
	
			private Cotisation cotisation = new Cotisation();
				
			private List<Emprunt> emprunt= new ArrayList(); 
			private int nombre_media;
		
}
