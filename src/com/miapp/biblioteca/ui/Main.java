package com.miapp.biblioteca.ui;
import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.service.LibroService;

import java.util.ArrayList;

public class Main {
    //clase Main
    public static void main(String[] args) {
        ArrayList<Libro> biblio = new ArrayList<>();
        LibroService libroService = new LibroService(biblio);
        libroService.create("El señor de los anillos", "J.R.R. Tolkien", "123", "Fantasía");
        libroService.create("El hobbit", "J.R.R. Tolkien", "1234", "Fantasía");
        libroService.create("El nombre del viento", "Patrick Rothfuss", "125", "Fantasía");
        libroService.create("El temor de un hombre sabio", "Patrick Rothfuss", "222", "Fantasía");
        System.out.println(libroService.readAll());
//        if(libroService.readByISBN("123") == null){
//            System.out.println("El libro con ISBN 123 no existe");
//        }else{
//            System.out.println(libroService.readByISBN("123"));
//        }
        libroService.updateByISBN("123", "El señor de los anillos: La comunidad del anillo", "J.R.R. Tolkien", "Fantasía");
        System.out.println(libroService.readAll());
        libroService.deleteByISBN("1234");
        System.out.println(libroService.readAll());
    }
}
