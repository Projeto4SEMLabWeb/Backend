package com.example.demo.Model.Cliente;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Pet {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomePet;
    private String racaPet;
    private int idadePet;
    private String portePet;

    // Construtor
    public Pet(String nomePet, String racaPet, int idadePet, String portePet) {
        this.nomePet = nomePet;
        this.racaPet = racaPet;
        this.idadePet = idadePet;
        this.portePet = portePet;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getRacaPet() {
        return racaPet;
    }

    public void setRacaPet(String racaPet) {
        this.racaPet = racaPet;
    }

    public int getIdadePet() {
        return idadePet;
    }

    public void setIdadePet(int idadePet) {
        this.idadePet = idadePet;
    }

    public String getPortePet() {
        return portePet;
    }

    public void setPortePet(String portePet) {
        this.portePet = portePet;
    }
}
