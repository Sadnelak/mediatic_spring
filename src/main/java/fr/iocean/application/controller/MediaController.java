package fr.iocean.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.application.model.Adherent;
import fr.iocean.application.model.Media;
import fr.iocean.application.service.MediaService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/media")
public class MediaController {

	@Autowired
	MediaService mediaService;
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	@ResponseBody
	public Media findById(@PathVariable Long id){
		return mediaService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid Media resource){
		mediaService.create(resource);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@PathVariable Long id, @RequestBody @Valid Adherent resource) throws NotFoundException{
		mediaService.update(id,resource);
	}
}
