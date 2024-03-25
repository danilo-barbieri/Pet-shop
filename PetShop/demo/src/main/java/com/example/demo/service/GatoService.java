package com.example.demo.service;

import com.example.demo.model.Gato;
import com.example.demo.repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatoService {

    @Autowired
    GatoRepository gatoRepository;

    public List<Gato> listarAnimal() {
        return gatoRepository.findAll();
    }

    public Gato criar(Gato gato) {
        return gatoRepository.save(gato);
    }

    public Gato atualizar(Long id, Gato gato) {
        //verificar se o id é valido
        if(gatoRepository.existsById(id)) {
            //atualizar o objeto na base
            gato.setId(id);
            return gatoRepository.save(gato);
        }
        return null;
        // não realiza nenhuma alteração
    }

    public boolean deletar(Long id) {
        if(gatoRepository.existsById(id)) {
            gatoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
