package com.example.springboot.app.service;

import com.example.springboot.app.model.Languaje;

import java.util.List;

public interface LanguajeService {

    Languaje createLanguaje(Languaje languaje);

    Languaje updateLanguaje(Languaje languaje);

    List<Languaje> getAllLanguajes();

    Languaje getLanguajeById(long languajeId);

    void deleteLanguaje(long id);
}
