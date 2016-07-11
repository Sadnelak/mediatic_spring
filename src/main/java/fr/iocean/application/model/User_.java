package fr.iocean.application.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_")
@Getter
@Setter
public class User_ {
	
	private String username;
	private String password;
	@Id
	private Long id;
	
	@Embedded
	private List<Authority> authorities;

	
	
	

}
