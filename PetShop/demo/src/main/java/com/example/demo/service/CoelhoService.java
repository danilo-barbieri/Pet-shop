package com.example.demo.service;

import com.example.demo.model.Coelho;
import com.example.demo.repository.CoelhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoelhoService {

    @Autowired
    CoelhoRepository coelhoRepository;

    public List<Coelho> listarCoelho() {
        return coelhoRepository.findAll();
    }

    public Coelho criar(Coelho coelho) {
        if (coelho.getEspecie().equals("coelho")) {
            return coelhoRepository.save(coelho);
        } return null;
    }

    public Coelho atualizar(Long id, Coelho coelho) {
        //verificar se o id é valido
        if(coelhoRepository.existsById(id)) {
            //atualizar o objeto na base
            coelho.setId(id);
            return coelhoRepository.save(coelho);
        }
        return null;
        // não realiza nenhuma alteração
    }

    public boolean deletar(Long id) {
        if(coelhoRepository.existsById(id)) {
            coelhoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdCoelho() {return coelhoRepository.findAll().size();}
}