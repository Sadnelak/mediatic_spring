package fr.iocean.application.model;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Adresse {

	private String ligne1;
	private String ligne2;
	private String codepostal;
	private String ville;
	
}
