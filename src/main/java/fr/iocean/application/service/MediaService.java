package fr.iocean.application.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.model.Media;
import fr.iocean.application.repository.MediaRepository;

@Service
@Transactional
public class MediaService {

	@Autowired
	MediaRepository mediaRepo;
	
	public Media findById(Long id){
		return this.mediaRepo.findOne(id);
	}
	
	public void create(Media media){
		this.mediaRepo.save(media);
	}


	public List<Media> getAll(){
		return this.mediaRepo.findAll();
	}

	public void update(Long id, Media resource) {
		// TODO Auto-generated method stub
		
	}

}
