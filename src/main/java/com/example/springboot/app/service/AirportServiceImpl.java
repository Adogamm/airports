package com.example.springboot.app.service;
import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.springboot.app.repository.AirportRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        Optional<Airport> airportDb = this.airportRepository.findById(airport.getIdAirport());

        if (airportDb.isPresent()){
            Airport airportUpdate = airportDb.get();
            airportUpdate.setIdAirport(airport.getIdAirport());
            airportUpdate.setName(airport.getName());
            airportRepository.save(airportUpdate);
            return airportUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + airport.getIdAirport());
        }
    }

    @Override
    public List<Airport> getAllAirports() {
        return this.airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(long airportId) {
        Optional<Airport> airportDB = this.airportRepository.findById(airportId);

        if (airportDB.isPresent()) {
            return airportDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + airportId);
        }
    }

    @Override
    public void deleteAirport(long airportId) {
        Optional<Airport> airportDB = this.airportRepository.findById(airportId);

        if (airportDB.isPresent()) {
            this.airportRepository.delete(airportDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + airportId);
        }
    }
}
