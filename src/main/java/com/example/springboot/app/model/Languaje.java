package com.example.springboot.app.model;

import javax.persistence.*;

@Entity
@Table(name= "languaje")
public class Languaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLanguaje;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public long getIdLanguaje() {
        return idLanguaje;
    }

    public void setIdLanguaje(long idLanguaje) {
        this.idLanguaje = idLanguaje;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
