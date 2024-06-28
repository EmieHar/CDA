package org.example.demospring.service;

import jakarta.transaction.Transactional;
import org.example.demospring.model.Genre;
import org.example.demospring.model.Real;
import org.example.demospring.repository.RealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RealService {

    @Autowired
    RealRepo realRepo;

    public List<Real> findAll(){return realRepo.findAll();}

    public Optional<Real> getOne(int id) {
        return realRepo.findById(id);
    }

}
