package fr.iocean.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "adherent")
@Getter
@Setter
public class Adherent implements IOEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@NotBlank
	private String nom;
	@NotBlank
	private String prenom;
	@NotNull
	private Date date_naissance;
	@NotBlank
	@Email
	private String email;
	
	
	@Embedded
	private Adresse adresse;
	@Embedded
	private Cotisation cotisation;

//	@OneToMany
//	private List<Emprunt> emprunt = new ArrayList<Emprunt>();
	private int nombre_media;

}
