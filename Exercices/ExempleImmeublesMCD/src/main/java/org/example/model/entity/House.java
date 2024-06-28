package org.example.model.entity;

import java.util.List;

public class House {
    private Kitchen kitchen;
    private List<Bedroom> bedroom;
    private Bathroom bathroom;
    private MailBox mailBox;

    public House(Kitchen kitchen, List<Bedroom> bedroom, Bathroom bathroom, MailBox mailBox){
        this.kitchen = kitchen;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.mailBox = mailBox;
    }

    public Kitchen getKitchen(){
        return kitchen;
    }

    public List<Bedroom> getBedrooms(){
        return bedroom;
    }

    public Bathroom getBathroom(){
        return bathroom;
    }

    public MailBox getMailBox(){
        return  mailBox;
    }
}
