package com.miapp.biblioteca;
import java.util.ArrayList;

public class Usuario {

    //atributos
    private String nombre;
    private String id;
    private ArrayList<Libro> libroPrestados;

    //constructores
    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.libroPrestados = new ArrayList<Libro>();
    }
    public Usuario(){

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

    public ArrayList<Libro> getLibrosPrestados() {
        return libroPrestados;
    }

   //métodos

    //método toString

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", librosPrestados=" + libroPrestados +
                '}';
    }
}
