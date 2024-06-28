package org.example.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSpecilite;
    private String code;
    private String libelle;

    @OneToMany(mappedBy = "specialite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Professeur> professeurs;

    //Constructeurs
    public Specialite(){}

    public Specialite(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    //Accesseurs

    public int getId() {
        return idSpecilite;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public String toString() {
        return "Specialite{" +
                "id=" + idSpecilite +
                ", libelle='" + libelle + '\'' +
                ", professeurs=" + professeurs.size() +  // Optionally show the number of professors
                '}';
    }
}
