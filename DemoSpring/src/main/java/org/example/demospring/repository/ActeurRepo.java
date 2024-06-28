package org.example.demospring.repository;

import org.example.demospring.model.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeurRepo extends JpaRepository<Acteur, Integer> {

}
