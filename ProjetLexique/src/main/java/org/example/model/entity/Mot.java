package org.example.model.entity;

import javax.persistence.*;

@Entity
@Table(name="mots")
public class Mot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id_Mots")
    private int id;
    private String mot;
    private String definition;
    private String exemple;

    @Column(name="image_exemple")
    private String image;

    //Contructeurs
    public Mot(){   }

    public Mot(String mot, String definition, String exemple) {
        this.mot = mot;
        this.definition = definition;
        this.exemple = exemple;
    }

    public Mot(String mot, String definition, String exemple, String image) {
        this.mot = mot;
        this.definition = definition;
        this.exemple = exemple;
        this.image = image;
    }

    //Guetters
    public int getId() {
        return id;
    }

    public String getMot() {
        return mot;
    }

    public String getDefinition() {
        return definition;
    }

    public String getExemple() {
        return exemple;
    }

    public String getImage() {
        return image;
    }

    //Setters

    public void setMot(String mot) {
        this.mot = mot;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setExemple(String exemple) {
        this.exemple = exemple;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
