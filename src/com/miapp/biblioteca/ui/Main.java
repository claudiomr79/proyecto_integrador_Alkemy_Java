package com.miapp.biblioteca.ui;
import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Prestamo;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.PrestamoService;
import com.miapp.biblioteca.service.UsuarioService;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //clase Main
    public static void main(String[] args) {
        ArrayList<Libro> biblio = new ArrayList<>();
        ArrayList<Usuario> usuariosEnBiblioteca = new ArrayList<>();
        ArrayList<Prestamo> prestamosEnBiblioteca = new ArrayList<>();
        //------------
        //servicios de la biblioteca
        LibroService libroService = new LibroService(biblio);
        UsuarioService usuarioService = new UsuarioService(usuariosEnBiblioteca);
        PrestamoService prestamoService = new PrestamoService(prestamosEnBiblioteca, usuariosEnBiblioteca, biblio);
        //Crear libros de la biblioteca
        libroService.create("El señor de los anillos", "J.R.R. Tolkien", "123", "Fantasía");
        libroService.create("El hobbit", "J.R.R. Tolkien", "1234", "Fantasía");
        libroService.create("El nombre del viento", "Patrick Rothfuss", "125", "Fantasía");
        libroService.create("El temor de un hombre sabio", "Patrick Rothfuss", "222", "Fantasía");
        libroService.create("El imperio final", "Brandon Sanderson", "333", "Fantasía");
        libroService.create("El pozo de la ascensión", "Brandon Sanderson", "444", "Fantasía");
        libroService.create("Dracula", "Desconocido", "213", "Terror");
        libroService.create("Frankenstein", "Mary Shelley", "214", "Terror");
        //crear usuarios de la biblioteca
        usuarioService.create("Juan", "1");
        usuarioService.create("Pedro", "2");
        usuarioService.create("María", "3");
        usuarioService.create("Ana", "4");
        usuarioService.create("Luis", "5");
        usuarioService.create("Lucía", "6");
        //crear prestamos
        prestamoService.create(usuarioService.readByID("2"), libroService.readByISBN("125"), "01/01/2021");
        prestamoService.create(usuarioService.readByID("1"), libroService.readByISBN("1234"), "02/01/2021");

        //menu
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la biblioteca");
        System.out.println("---------------------------");
        System.out.println("1. Crear usuario");
        System.out.println("2. Leer todos los usuarios");

        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                //Crear usuario
                System.out.println("Crear usuario");
                System.out.println("Introduce el nombre del usuario");
                String nombre = sc.nextLine();
                System.out.println("Introduce el id del usuario");
                String id = sc.nextLine();
                usuarioService.create(nombre, id);
                break;
            case 2:
                //Leer todos los usuarios
                System.out.println(usuarioService.readAll());
                break;
        }
    }
}
