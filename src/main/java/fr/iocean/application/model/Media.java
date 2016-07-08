package fr.iocean.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "media")
@Getter
@Setter
@SequenceGenerator(name = "seq_media", initialValue = 1, allocationSize = 1000)
public class Media implements IOEntity {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_media")
	@Id
	private Long id;
	@NotBlank
	private String auteur;
	@NotBlank
	private String titre;
	@NotBlank
	private String type;
}
