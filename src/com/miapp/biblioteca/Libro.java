package com.miapp.biblioteca;

public class Libro {
    //atributos
    private String titulo;
    private String autor;
    private String ISBN;
    private String genero;
    private boolean disponible;

   //constructores
    public Libro(String titulo, String autor, String isbn, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = isbn;
        this.genero = genero;
        this.disponible = true;
    }
    public Libro(){

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
    public boolean getDisponible() {
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

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
       return disponible;
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
