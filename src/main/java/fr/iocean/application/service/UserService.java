package fr.iocean.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import fr.iocean.application.model.User;
import fr.iocean.application.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public User findById(Long id) {
		return repository.findOne(id);
	}

	public void create(User resource) {
		resource.setPassword(passwordEncoder.encode(resource.getPassword()));
		repository.save(resource);
	}

	public User update(Long id, User resource) {
		if (!StringUtils.isEmpty(resource.getPassword())) {
			resource.setPassword(passwordEncoder.encode(resource.getPassword()));
		}
		// controle existance entite avec son id
		return repository.save(resource);
	}

}
