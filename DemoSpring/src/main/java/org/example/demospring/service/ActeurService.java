package org.example.demospring.service;

import jakarta.transaction.Transactional;
import org.example.demospring.model.Acteur;
import org.example.demospring.model.Film;
import org.example.demospring.repository.ActeurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActeurService {

    @Autowired
    /*
    @Autowired est une annotation de Spring utilisée pour l'injection automatique de dépendances.
    Cela signifie que Spring fournira automatiquement les dépendances requises pour votre classe
    sans que vous ayez à les créer explicitement.
    Lorsque vous annotez un champ, un constructeur ou une méthode setter avec @Autowired,
    Spring essaiera de trouver un bean correspondant (un objet géré par Spring) et de l'injecter.
    */
    ActeurRepo acteurRepo;

    public List<Acteur> findAll(){return acteurRepo.findAll();}

    public Optional<Acteur> getOne(int id) {
        return acteurRepo.findById(id);
    }

    public void save(Acteur acteur) {
        acteurRepo.save(acteur);
    }

    public boolean deleteActeur(int id) {
        Optional<Acteur> acteur = acteurRepo.findById(id);
        if (acteur.isPresent()) {
            acteurRepo.delete(acteur.get());
            return true;
        }
        return false;
    }

    public List<Acteur> findAllById(List<Integer> ids) {
        return acteurRepo.findAllById(ids);
    }

}
