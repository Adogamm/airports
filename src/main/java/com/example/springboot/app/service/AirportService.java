package com.example.springboot.app.service;

import com.example.springboot.app.model.Airport;

import java.util.List;

public interface AirportService {

    Airport createAirport(Airport airport);

    Airport updateAirport(Airport airport);

    List<Airport> getAllAirports();

    Airport getAirportById(long airportId);

    void deleteAirport(long id);

}
