package com.example.demo.controller;

import com.example.demo.model.Coelho;
import com.example.demo.service.CoelhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coelhos")
public class CoelhoController {

    @Autowired
    CoelhoService coelhoService;

    @GetMapping
    public List<Coelho> listarCoelhos () {
        return coelhoService.listarCoelho();
    }

    @PostMapping
    public Coelho criar (@Valid @RequestBody Coelho coelho) {
        return coelhoService.criar(coelho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Coelho coelho) {

        if(coelhoService.atualizar(id, coelho) == null) {
            String mensagem = "O coelho informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(coelho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(coelhoService.deletar(id)) {
            String mensagem = "A venda do coelho de id " + id + " foi cadastrada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O coelho informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/qtd-coelho")
    public int qtdCoelho() {
        return coelhoService.qtdCoelho();
    }

}


