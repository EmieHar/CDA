package org.example.demospring.service;

import jakarta.transaction.Transactional;
import org.example.demospring.model.Film;
import org.example.demospring.model.Genre;
import org.example.demospring.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreService {

    @Autowired
    GenreRepo genreRepo;

    public List<Genre> findAll(){return genreRepo.findAll();}

    public Optional<Genre> getOne(int id) {
        return genreRepo.findById(id);
    }
}
