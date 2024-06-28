package org.example.javaweb_jee2.model;

import jakarta.persistence.Column;
import util.PasswordUtil;

public class Admin {
    private long id;
    @Column(unique=true)
    private String email;
    private String password;

    //constructors
    public Admin() {}

    public Admin(String email, String password) {
        this.email = email;
        this.password = PasswordUtil.hashPassword(password);
    }


    //getters and setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
