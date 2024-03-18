package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Gato extends Animal {
    private String comportamento;
    private String habitos;

    public Gato() {
    }

    public Gato(String nome, String especie, String raca, String genero, String comportameto, String habitos) {
        super(nome, especie, raca, genero);
        this.comportamento = comportameto;
        this.habitos = habitos;
    }

    public String getComportamento() {
        return comportamento;
    }

    public void setComportamento(String comportamento) {
                this.comportamento = comportamento;
    }

    public String getHabitos() {
        return habitos;
    }

    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }
}
