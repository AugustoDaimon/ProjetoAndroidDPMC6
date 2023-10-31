package com.example.nutzen.Cadastro;

import java.time.LocalDate;

// Classe para instanciação de Usuario

public class Usuario {
    private String nome;
    private String senha;
    private String email;
    private char genero;

    private LocalDate dataNasc;
    private double altura;
    private double peso;

    // TODO: Transformar em bool? ou usar como char msm?
    private char objetivo;

    private boolean restricoesAlimentares;

    // TODO: Criar objeto do tipo restrição alimentar
    // private ArrayList<restricaoAlimentar> itensRestricoesAlimentares


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public char getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(char objetivo) {
        this.objetivo = objetivo;
    }

    public boolean isRestricoesAlimentares() {
        return restricoesAlimentares;
    }

    public void setRestricoesAlimentares(boolean restricoesAlimentares) {
        this.restricoesAlimentares = restricoesAlimentares;
    }
}
