package fr.iocean.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.application.model.User;
import fr.iocean.application.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "authorities", method = RequestMethod.GET)
	public List<GrantedAuthority> findAuthorities() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return (List<GrantedAuthority>) auth.getAuthorities();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		User user = userService.findById(id);
		System.out.println("findByID user controler : " + user );
		return user;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid User resource) {
		System.out.println("create user controler : " + resource );
		userService.create(resource);
		
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, @RequestBody @Valid User resource) {
		System.out.println("update user controler : " + resource );
		return userService.update(id, resource);
	}
}