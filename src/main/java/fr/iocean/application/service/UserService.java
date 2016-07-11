package fr.iocean.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.model.User_;
import fr.iocean.application.repository.UserRepository;

@Service
@Transactional 
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public UserRepository getRepo() {
		return repo;
	}

	public void setRepo(UserRepository repo) {
		this.repo = repo;
	}

	public Optional<User_> findByUserName(String userName) {
		// TODO Auto-generated method stub
		
		Optional<User_> user = repo.getUserByUserName(userName);
		
		
		System.out.println("findByID user service"+ user);
		return user;
	}

//	public void create(User_ resource) {
//		// TODO Auto-generated method stub
//		
//		System.out.println("create user service : " + resource );
//		repo.create(resource);
//		
//		
//	}
//	public void delete(User_ resource) {
//		// TODO Auto-generated method stub
//		
//		System.out.println("delete user service : " + resource );
//		repo.delete(resource);	
//	}
//	public void delete(Long id) {
//		// TODO Auto-generated method stub
//		System.out.println("delete user service : " + id );
//		User_ user = findById(id);
//		delete(user);	
//	}
//
//	public void update(Long id, User_ resource) {
//		// TODO Auto-generated method stub
//		System.out.println("update user service");
//	}

}
