package com.example.springboot.app.service;
import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Languaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.springboot.app.repository.LanguajeRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LanguajeServiceImpl implements LanguajeService {

    @Autowired
    private LanguajeRepository languajeRepository;

    @Override
    public Languaje createLanguaje(Languaje languaje) {
        return languajeRepository.save(languaje);
    }

    @Override
    public Languaje updateLanguaje(Languaje languaje) {
        Optional<Languaje> languajeDb = this.languajeRepository.findById(languaje.getId());

        if (languajeDb.isPresent()){
            Languaje languajeUpdate = languajeDb.get();
            languajeUpdate.setId(languaje.getId());
            languajeUpdate.setName(languaje.getCode());
            languajeUpdate.setCode(languaje.getCode());
            languajeRepository.save(languajeUpdate);
            return languajeUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + languaje.getId());
        }
    }

    @Override
    public List<Languaje> getAllLanguajes() {
        return this.languajeRepository.findAll();
    }

    @Override
    public Languaje getLanguajeById(long languajeId) {
        Optional<Languaje> languajeDB = this.languajeRepository.findById(languajeId);

        if (languajeDB.isPresent()) {
            return languajeDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + languajeId);
        }
    }

    @Override
    public void deleteLanguaje(long languajeId) {
        Optional<Languaje> languajeDB = this.languajeRepository.findById(languajeId);

        if (languajeDB.isPresent()) {
            this.languajeRepository.delete(languajeDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + languajeId);
        }
    }
}
