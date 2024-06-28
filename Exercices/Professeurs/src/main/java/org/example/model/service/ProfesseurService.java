package org.example.model.service;

import org.example.model.dao.ProfesseurDAO;
import org.example.model.entity.Professeur;

import java.util.List;

public class ProfesseurService {
    private final ProfesseurDAO professeurDao = new ProfesseurDAO();

    public void createProfesseur(Professeur prof, int idSpe){
        professeurDao.createProfesseur(prof, idSpe);
    }

    public List<Professeur>getProfesseurs(){
        return professeurDao.getProfesseurs();
    }

}
