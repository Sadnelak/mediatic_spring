package fr.iocean.application.model;

import java.util.Date;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Cotisation {

	private Date debut;
	private Date fin;
	private int cotisation;
}
