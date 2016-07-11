package fr.iocean.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iocean.application.model.Media;


public interface MediaRepository extends JpaRepository<Media, Long>{

}
