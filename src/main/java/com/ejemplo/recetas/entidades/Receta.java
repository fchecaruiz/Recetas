package com.ejemplo.recetas.entidades;

public class Receta {
    private int id;
    private String nombre;
    private int fkDificultad;
    private String dificultad; // opcional: nombre textual de la dificultad

    // Constructor vacío
    public Receta() {}

    // Constructor usado al listar (id + nombre + dificultad textual)
    public Receta(int id, String nombre, String dificultad) {
        this.id = id;
        this.nombre = nombre;
        this.dificultad = dificultad;
    }

    // Constructor usado al insertar (nombre + FK a dificultades)
    public Receta(String nombre, int fkDificultad) {
        this.nombre = nombre;
        this.fkDificultad = fkDificultad;
    }

    // Constructor con todos los campos (si lo necesitas)
    public Receta(int id, String nombre, int fkDificultad, String dificultad) {
        this.id = id;
        this.nombre = nombre;
        this.fkDificultad = fkDificultad;
        this.dificultad = dificultad;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFkDificultad() {
        return fkDificultad;
    }

    public void setFkDificultad(int fkDificultad) {
        this.fkDificultad = fkDificultad;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return "Receta{id=" + id + ", nombre='" + nombre + '\'' +
               ", fkDificultad=" + fkDificultad +
               ", dificultad='" + dificultad + '\'' + '}';
    }
}