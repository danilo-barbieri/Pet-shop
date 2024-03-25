package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Coelho extends Animal {
    private String tipoOrelha;
    private String tipoRabo;

    public Coelho() {
    }

    public Coelho(String nome, String especie, String raca, String sexo, String tipoOrelha, String tipoRabo) {
        super(nome, especie, raca, sexo);
        this.tipoOrelha = tipoOrelha;
        this.tipoRabo = tipoRabo;
    }

    public String getTipoOrelha() {
        return tipoOrelha;
    }

    public void setTipoOrelha(String tipoOrelha) {
                this.tipoOrelha = tipoOrelha;
    }

    public String getTipoRabo() {
        return tipoRabo;
    }

    public void setTipoRabo(String tipoRabo) {
        this.tipoRabo = tipoRabo;
    }
}
