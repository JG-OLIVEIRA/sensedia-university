package com.sensedia.university.models;

public class Aluno {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String matricula;
    private Integer ano;

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "[Id: " + this.id + ", Nome: " + this.nome + ", Sobrenome: " + this.sobrenome + ", Matricula: " + this.matricula + ", Ano: " + this.ano + "]";
    }
}
