package com.example.demo.service;
import com.example.demo.model.Cachorro;
import com.example.demo.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CachorroService {

    @Autowired
    CachorroRepository cachorroRepository;

    public List<Cachorro> listarCachorro() {
        return cachorroRepository.findAll();
    }

    public Cachorro criar(Cachorro cachorro) {
        if (cachorro.getEspecie().equals("cachorro")) {
            return cachorroRepository.save(cachorro);
        } return null;
    }

    public Cachorro atualizar(Long id, Cachorro cachorro) {
        //verificar se o id é valido
        if (cachorroRepository.existsById(id)) {
            //atualizar o objeto na base
            cachorro.setId(id);
            return cachorroRepository.save(cachorro);
        }
        return null;
        // não realiza nenhuma alteração
    }

    public boolean deletar(Long id) {
        if (cachorroRepository.existsById(id)) {
            cachorroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdCachorro() {
        return cachorroRepository.findAll().size();
    }
}