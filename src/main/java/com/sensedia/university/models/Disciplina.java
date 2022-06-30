package com.sensedia.university.models;

public class Disciplina {

    private Integer id;
    private String nome;
    private String turno;
    private Integer sala;

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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "[Nome: " + this.nome + ", Turno: " + this.turno + ", Sala: " + this.sala + "]";
    }
}
