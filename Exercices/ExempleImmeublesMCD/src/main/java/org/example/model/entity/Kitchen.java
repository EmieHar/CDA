package org.example.model.entity;

import java.util.List;

public class Kitchen extends Room{
    private List<String> equipments;

    public Kitchen(double superficie, List<String> equipments) {
        super(superficie);
        this.equipments = equipments;
    }

    public List<String> getEquipments() {
        return equipments;
    }
}
