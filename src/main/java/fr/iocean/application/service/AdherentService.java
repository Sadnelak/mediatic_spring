package fr.iocean.application.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.iocean.application.model.Adherent;
import fr.iocean.application.repository.AdherentRepository;

public class AdherentService {

	@Autowired
	AdherentRepository adherentRepo;
	
	public Adherent findById(Long id){
		return this.adherentRepo.findOne(id);
	}
	
	public Long create(Adherent adherent){
		
		
		return this.adherentRepo.findOne(adherent.g);
	}

	
}
