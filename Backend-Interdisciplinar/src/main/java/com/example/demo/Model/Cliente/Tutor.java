package com.example.demo.Model.Cliente;

import java.util.List;

public class Tutor {
    private int id;
    private String nomeTutor;
    private Number telefoneTutor;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    
    // Lista de Pets, representando o relacionamento Um-para-Muitos (One-to-Many)
    private List<Pet> pets;

    // Construtor
    public Tutor(String nomeTutor, Number telefoneTutor, String cep, String logradouro, String bairro, String cidade, String estado, String complemento) {
        this.nomeTutor = nomeTutor;
        this.telefoneTutor = telefoneTutor;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public Number getTelefoneTutor() {
        return telefoneTutor;
    }

    public void setTelefoneTutor(Number telefoneTutor) {
        this.telefoneTutor = telefoneTutor;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
