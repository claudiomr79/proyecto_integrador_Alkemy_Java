package com.miapp.biblioteca;

public class Libros {
    //atributos
    private String titulo;
    private String autor;
    private String ISBN;
    private String genero;
    private String disponible;

   //constructores
    public Libros(String titulo, String autor, String isbn, String genero, String disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = isbn;
        this.genero = genero;
        this.disponible = disponible;
    }
    public Libros(){

    }

    //getters y setters
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getISBN() {
        return ISBN;
    }
    public String getGenero() {
        return genero;
    }
    public String getDisponible() {
        return disponible;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }
    //método toString

    @Override
    public String toString() {
        return "Libros{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", genero='" + genero + '\'' +
                ", disponible='" + disponible + '\'' +
                '}';
    }
}
