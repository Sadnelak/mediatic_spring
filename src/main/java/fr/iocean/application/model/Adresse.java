package fr.iocean.application.model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Adresse {
	private String ligne1;
	private String ligne2;
	private String codepostal;
	private String ville;
	
}
