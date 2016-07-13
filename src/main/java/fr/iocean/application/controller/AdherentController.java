package fr.iocean.application.controller;

import java.util.List;

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
import fr.iocean.application.service.AdherentService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/adherents")
public class AdherentController {

	@Autowired
	AdherentService adherentService;
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	@ResponseBody
	public Adherent findById(@PathVariable Long id){
		return adherentService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Adherent> findById(){
		return adherentService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid Adherent resource){
		adherentService.create(resource);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@PathVariable Long id, @RequestBody @Valid Adherent resource) throws NotFoundException{
		adherentService.update(id,resource);
	}
	
}
