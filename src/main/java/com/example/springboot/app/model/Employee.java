package com.example.springboot.app.model;

import javax.persistence.*;

@Entity
@Table(name= "employee")
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id_employee;

        @Column(name = "surname")
        private String surname;

        @Column(name = "firstname")
        private String firstname;

        @Column(name = "country")
        private String country;

        @Column(name = "languaje")
        private String languaje;

        @Column(name = "airport")
        private String airport;

        public long getId_employee() {
            return id_employee;
        }

        public void setId_employee(long id_employee) {
            this.id_employee = id_employee;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLanguaje() {
            return languaje;
        }

        public void setLanguaje(String languaje) {
            this.languaje = languaje;
        }

        public String getAirport() {
            return airport;
        }

        public void setAirport(String airport) {
            this.airport = airport;
        }  

        
    }


