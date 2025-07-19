package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Dati {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Size(max = 50)
    @NotNull
    @Column(name = "Cognome", nullable = false, length = 50)
    private String cognome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

}
