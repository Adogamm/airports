package com.example.springboot.app.model;

import javax.persistence.*;

@Entity
@Table(name= "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCountry;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
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
