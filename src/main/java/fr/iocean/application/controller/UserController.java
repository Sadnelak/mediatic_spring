package fr.iocean.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.application.model.User_;
import fr.iocean.application.service.UserService;

@RestController
@RequestMapping("/login")

public class UserController {
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public User_ findById(@PathVariable Long id) {
		User_ user = userService.findById(id);
		System.out.println("findByID user controler : " + user );
		return user;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable Long id) {
		System.out.println("deleteById user controler : " + id );
		userService.delete(id);
		
		
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid User_ resource) {
		System.out.println("create user controler : " + resource );
		userService.create(resource);
		
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@PathVariable Long id, @RequestBody @Valid User_ resource) {
		System.out.println("update user controler : " + resource );
		userService.update(id, resource);
	}
}