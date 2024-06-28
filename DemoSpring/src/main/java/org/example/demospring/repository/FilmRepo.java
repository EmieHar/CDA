package org.example.demospring.repository;


import org.example.demospring.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo extends JpaRepository<Film, Integer> {



}
