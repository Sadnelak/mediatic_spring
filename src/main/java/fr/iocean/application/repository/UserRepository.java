package fr.iocean.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.iocean.application.model.User_;

@Service
public interface UserRepository extends JpaRepository<User_, Long>{


	public Optional<User_> getUserByUserName(String userName);


}
