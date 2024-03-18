package com.example.demo.controller;

import com.example.demo.model.Coelho;
import com.example.demo.repository.CoelhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coelhos")
public class CoelhoController {

    @Autowired
    CoelhoRepository coelhoRepository;

    @GetMapping
    public List<Coelho> listarCoelhos () {
        return coelhoRepository.findAll();
    }

    @PostMapping
    public Coelho criar (@RequestBody Coelho coelho) {
        return coelhoRepository.save(coelho);
    }
}
