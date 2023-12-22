package com.miapp.biblioteca.service;
import com.miapp.biblioteca.Libro;
import java.util.ArrayList;

public class LibroService {
    //Atributos
    private ArrayList<Libro> biblioteca; //listado de libros de la biblioteca
    //Constructores

    public LibroService(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    //metodos

    /*
    CRUD
    */

    //Crear libro (Create)
    public void create(String titulo, String autor, String isbn, String genero){
        Libro nuevolibro = new Libro(titulo, autor, isbn, genero);
        biblioteca.add(nuevolibro);
    }
    //Leer todos los libros(Read)
    public ArrayList<Libro> readAll(){
        return biblioteca;
    }
    //Leer un libro por ISBN(Read by ISBN)
    public Libro readByISBN(String isbn){
        for (Libro libro : biblioteca) {
            if (libro.getISBN().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    //Actualizar un libro por ISBN(Update by ISBN)
    public void updateByISBN(String isbn, String nuevoTitulo, String nuevoAutor, String nuevoGenero){
        Libro libro = readByISBN(isbn);
        if (libro != null) {
            libro.setTitulo(nuevoTitulo);
            libro.setAutor(nuevoAutor);
            libro.setGenero(nuevoGenero);
        }
    }
    //Eliminar un libro por ISBN(Delete by ISBN)
    public void deleteByISBN(String isbn){
        biblioteca.removeIf(libro -> libro.getISBN().equals(isbn));
    }
}
