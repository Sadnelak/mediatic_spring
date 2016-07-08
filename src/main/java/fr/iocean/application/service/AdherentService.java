package fr.iocean.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iocean.application.model.Adherent;
import fr.iocean.application.repository.AdherentRepository;

@Service
public class AdherentService {

	@Autowired
	AdherentRepository adherentRepo;
	
	public Adherent findById(Long id){
		return this.adherentRepo.findOne(id);
	}
	
	public void create(Adherent adherent){
		this.adherentRepo.save(adherent);
	}


	public List<Adherent> getAll(){
		return this.adherentRepo.findAll();
	}

	public void update(Long id, Adherent resource) {
		// TODO Auto-generated method stub
		
	}
	
}
