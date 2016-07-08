package fr.iocean.application.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adresse {

	private String ligne1;
	private String ligne2;
	private String codepostal;
	private String ville;
	
}
