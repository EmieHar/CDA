package org.example.demospring.service;

import jakarta.transaction.Transactional;
import org.example.demospring.model.Film;
import org.example.demospring.repository.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FilmService {


    @Autowired
    FilmRepo filmRepo;

    public List<Film> findAll(){return filmRepo.findAll();}

    public Optional<Film> getOne(int id) {
        return filmRepo.findById(id);
    }

    public void save(Film film) {
        filmRepo.save(film);
    }

    public boolean deleteFilm(int id) {
        Optional<Film> film = filmRepo.findById(id);
        if (film.isPresent()) {
            filmRepo.delete(film.get());
            return true;
        }
        return false;
    }

}


