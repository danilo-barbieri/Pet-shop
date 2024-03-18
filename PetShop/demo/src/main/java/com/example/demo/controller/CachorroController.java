package com.example.demo.controller;

import com.example.demo.model.Cachorro;
import com.example.demo.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cachorros")
public class CachorroController {

    @Autowired
    CachorroRepository cachorroRepository;

    @GetMapping
    public List<Cachorro> listarCachorros () {
        return cachorroRepository.findAll();
    }

    @PostMapping
    public Cachorro criar (@RequestBody Cachorro cachorro) {
        return cachorroRepository.save(cachorro);
    }
}
