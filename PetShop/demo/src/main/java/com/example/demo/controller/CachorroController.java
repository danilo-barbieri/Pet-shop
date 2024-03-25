package com.example.demo.controller;

import com.example.demo.model.Cachorro;
import com.example.demo.service.CachorroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cachorros")
public class CachorroController {

    @Autowired
    CachorroService cachorroService;

    @GetMapping
    public List<Cachorro> listarCachorro() {
        return cachorroService.listarCachorro();
    }

    @PostMapping
    public Cachorro criar(@Valid @RequestBody Cachorro cachorro) {
        return cachorroService.criar(cachorro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cachorro cachorro) {
        //return funcionarioService.atualizar(id, funcionario);
        if(cachorroService.atualizar(id, cachorro) == null) {

            String mensagem = "O cachorro informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
            //return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cachorro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(cachorroService.deletar(id)) {
            String mensagem = "A venda do cachorro de id " + id + " foi cadastrada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O cachorro informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/qtd-cachorro")
    public int qtdCachorro() {
        return cachorroService.qtdCachorro();
    }

}