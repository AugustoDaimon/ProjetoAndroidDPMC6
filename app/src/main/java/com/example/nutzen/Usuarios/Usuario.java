package com.example.nutzen.Usuarios;

import java.time.LocalDate;
import java.util.Date;

// Classe para instanciação de Usuario

public class Usuario {
    private String nome;
    private String senha;
    private String email;

    // Genero == F -> Feminino | Genero == M -> Masculino
    private char genero;
    private Date dataNasc;
    private int idade;
    private double altura;
    private double peso;

    // Objetivo == P -> Perder peso | Objetivo == G -> Ganhar peso
    private char objetivo;

    private boolean restricoesAlimentares;

    // TODO: Criar objeto do tipo restrição alimentar
    // private ArrayList<restricaoAlimentar> itensRestricoesAlimentares


    // METODOS
    public double getIMC() {
        return (this.peso/((this.altura/100)*(this.altura/100)));
    }


    // GETTERS AND SETTERS
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

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
