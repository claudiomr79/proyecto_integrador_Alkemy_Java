package com.miapp.biblioteca;

import java.util.ArrayList;

public class Usuarios {

    //atributos
    private String nombre;
    private String id;
    private ArrayList<Libros> librosPrestados ;

    //constructores
    public Usuarios(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = new ArrayList<Libros>();
    }
    public Usuarios(){

    }
    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Libros> getLibrosPrestados() {
        return librosPrestados;
    }

    //método toString

    @Override
    public String toString() {
        return "Usuarios{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", librosPrestados=" + librosPrestados +
                '}';
    }
}
