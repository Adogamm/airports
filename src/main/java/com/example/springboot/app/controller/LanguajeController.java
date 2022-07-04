package com.example.springboot.app.controller;

import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Languaje;
import com.example.springboot.app.service.LanguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Languajes")
public class LanguajeController {
    @Autowired
    private LanguajeService LanguajeService;

    @GetMapping("/list_Languajes")
    public ResponseEntity<?> getAllLanguaje(){
        List<Languaje> lista = LanguajeService.getAllLanguajes();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin aeropuertos en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(LanguajeService.getAllLanguajes());
    }

    @GetMapping("/details_Languaje/{id}")
    public ResponseEntity<Languaje> getLanguajeById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.LanguajeService.getLanguajeById(id));
    }

    @PostMapping("/create_Languaje")
    public ResponseEntity<Languaje> createLanguaje(@RequestBody Languaje Languaje) {
        return ResponseEntity.ok().body(this.LanguajeService.createLanguaje(Languaje));
    }


    @PutMapping("/update_Languaje/{id}")
    public ResponseEntity<Languaje> updateLanguaje(@PathVariable long id, @RequestBody Languaje Languaje){
        Languaje.setId(id);
        return ResponseEntity.ok().body(this.LanguajeService.updateLanguaje(Languaje));
    }

    @DeleteMapping("/delete_Languaje/{id}")
    public HttpStatus deleteLanguaje(@PathVariable long id){
        this.LanguajeService.deleteLanguaje(id);
        return HttpStatus.OK;
    }
}
