package org.example.controller;

import org.example.model.entity.House;
import org.example.view.HouseView;

public class HouseController {
    private House maison;
    private HouseView maisonView;

    public HouseController(House maison, HouseView maisonView) {
        this.maison = maison;
        this.maisonView = maisonView;
    }

    public void getHouse() {
        maisonView.getDetailsHouse(maison);
    }

    public void addMail(String courrier) {
        maison.getMailBox().addMail(courrier);
        maisonView.getDetailsHouse(maison);
    }
}
