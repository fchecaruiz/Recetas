package com.ejemplo.recetas.entidades;

public class Dificultad {
    private int id;
    private String dificultad;

    public Dificultad() {}

    public Dificultad(int id, String dificultad) {
        this.id = id;
        this.dificultad = dificultad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
}