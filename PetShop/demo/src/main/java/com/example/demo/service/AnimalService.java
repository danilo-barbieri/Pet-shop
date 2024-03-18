package com.example.demo.service;

import com.example.demo.model.Animal;
import com.example.demo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public List<Animal> listarAnimal() {
        return animalRepository.findAll();
    }

    public Animal criar(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal atualizar(Long id, Animal animal) {
        //verificar se o id é valido
        if(animalRepository.existsById(id)) {
            //atualizar o objeto na base
            animal.setId(id);
            return animalRepository.save(animal);
        }
        return null;
        // não realiza nenhuma alteração
    }

    public boolean deletar(Long id) {
        if(animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdAnimal () {
        return animalRepository.findAll().size();
    }
}
