package org.example.spring_jax_rs;

// Class
public class DomainBean {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DomainBean() {
    }

    String id;
    String name;
    String data;

    public DomainBean(String id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

}
