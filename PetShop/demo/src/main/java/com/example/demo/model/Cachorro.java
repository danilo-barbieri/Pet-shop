package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Cachorro extends Animal {
    private String pelagem;
    private String porte;

    public Cachorro() {
    }

    public Cachorro(String nome, String especie, String raca, String sexo, String pelagem, String porte) {
        super(nome, especie, raca, sexo);
        this.pelagem = pelagem;
        this.porte = porte;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }
}
