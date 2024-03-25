package com.example.demo.controller;

import com.example.demo.model.Gato;
import com.example.demo.service.GatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatos")
public class GatoController {

    @Autowired
    GatoService gatoService;

    @GetMapping
    public List<Gato> listarGatos () {
        return gatoService.listarGato();
    }

    @PostMapping
    public Gato criar (@Valid @RequestBody Gato gato) {
        return gatoService.criar(gato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Gato gato) {

        if(gatoService.atualizar(id, gato) == null) {
            String mensagem = "O coelho informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(gato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(gatoService.deletar(id)) {
            String mensagem = "A venda do gato de id " + id + " foi cadastrada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O gato informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/qtd-gato")
    public int qtdGato() {
        return gatoService.qtdGato();
    }
}
