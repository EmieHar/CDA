package org.example.model.service;

import org.example.model.dao.SpecialiteDAO;
import org.example.model.entity.Specialite;

import java.util.List;

public class SpecialiteService {

    private final SpecialiteDAO specialiteDAO = new SpecialiteDAO();

    public void createSpecilite(String code, String libelle) {
        specialiteDAO.createSpecialite(code,libelle);
    }

    public List<Specialite> getSpecialites(){
        return  specialiteDAO.getSpecialites();
    }

    public int getIdSpeByName(String nomSpe){
        return specialiteDAO.getIdSpeByName(nomSpe) ;
    }

    public List<Specialite> getProfesseurBySpecialite(){
        return  specialiteDAO.getProfesseurBySpecialite();
    }
}
