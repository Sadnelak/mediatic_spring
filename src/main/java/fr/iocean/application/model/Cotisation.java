package fr.iocean.application.model;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cotisation {

	private Date debut;
	private Date fin;
	private int cotisation;
}
