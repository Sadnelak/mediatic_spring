package fr.iocean.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "adherent")
@Getter
@Setter
@SequenceGenerator(name = "seq_adherent", initialValue = 1, allocationSize = 1000)
public class Adherent implements IOEntity {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_adherent")
	@Id
	private Long id;
	@NotBlank
	private String nom;
	@NotBlank
	private String prenom;
	@NotBlank
	private Date date_naissance;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private Adresse adresse = new Adresse();
	@NotBlank
	private Cotisation cotisation = new Cotisation();

	private List<Emprunt> emprunt = new ArrayList<Emprunt>();
	private int nombre_media;

}
