package org.example.model.service;

import org.example.model.dao.MotDAO;
import org.example.model.entity.Mot;

public class MotService {

    private MotDAO motDAO = new MotDAO();

    public void ajouterMot(Mot mot){
       motDAO.ajouterMot(mot);
    }
}
