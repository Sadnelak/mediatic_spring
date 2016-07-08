package fr.iocean.application.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Media implements IOEntity {
			private String auteur; 
			private String titre; 
			private String type; 
}
