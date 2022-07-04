package com.example.springboot.app.repository;

import com.example.springboot.app.model.Languaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguajeRepository extends JpaRepository <Languaje, Long> {

}
