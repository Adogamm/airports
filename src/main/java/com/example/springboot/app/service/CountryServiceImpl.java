package com.example.springboot.app.service;
import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.springboot.app.repository.CountryRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> countryDb = this.countryRepository.findById(country.getIdCountry());

        if (countryDb.isPresent()){
            Country countryUpdate = countryDb.get();
            countryUpdate.setIdCountry(country.getIdCountry());
            countryUpdate.setName(country.getName());
            countryUpdate.setCode(country.getCode());
            countryRepository.save(countryUpdate);
            return countryUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + country.getIdCountry());
        }
    }

    @Override
    public List<Country> getAllCountrys() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country getCountryById(long countryId) {
        Optional<Country> countryDB = this.countryRepository.findById(countryId);

        if (countryDB.isPresent()) {
            return countryDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + countryId);
        }
    }

    @Override
    public void deleteCountry(long countryId) {
        Optional<Country> countryDB = this.countryRepository.findById(countryId);

        if (countryDB.isPresent()) {
            this.countryRepository.delete(countryDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + countryId);
        }
    }
}
