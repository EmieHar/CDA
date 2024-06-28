package org.example.model.entity;

public class Bedroom extends Room{
    private boolean litDouble;

    public Bedroom (double superficie, boolean litDouble){
        super(superficie);
        this.litDouble = litDouble;
    }

    public boolean hasLitDouble() {
        return litDouble;
    }
}
