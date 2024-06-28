package org.example.model.entity;

public class Bathroom extends Room {
    private boolean bath;

    public Bathroom (double superficie, boolean bath){
        super(superficie);
        this.bath = bath;
    }

    public boolean hasBath(){
        return bath;
    }
}
