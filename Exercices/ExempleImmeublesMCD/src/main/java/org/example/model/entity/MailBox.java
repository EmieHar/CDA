package org.example.model.entity;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<String> mail;

    public MailBox(){
        this.mail = new ArrayList<>();
    }

    public List<String> getMail() {
        return mail;
    }


    public void addMail(String courrier) {
        this.mail.add(courrier);
    }
}
