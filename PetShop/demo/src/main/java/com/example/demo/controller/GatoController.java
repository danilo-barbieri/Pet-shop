package com.example.demo.controller;

import com.example.demo.model.Gato;
import com.example.demo.repository.GatoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatos")
public class GatoController {

    @Autowired
    GatoRepository gatoRepository;

    @GetMapping
    public List<Gato> listarGatos () {
        return gatoRepository.findAll();
    }

    @PostMapping
    public Gato criar (@Valid @RequestBody Gato gato) {
        return gatoRepository.save(gato);
    }
}
