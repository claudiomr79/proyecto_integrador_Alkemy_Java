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
       //limpiar pantalla
        limpiarPantalla();
        ArrayList<Libro> biblio = new ArrayList<>();
        ArrayList<Usuario> usuariosEnBiblioteca = new ArrayList<>();
        ArrayList<Prestamo> prestamosEnBiblioteca = new ArrayList<>();
        //------------
        //servicios de la biblioteca
        LibroService libroService = new LibroService(biblio);
        UsuarioService usuarioService = new UsuarioService(usuariosEnBiblioteca);
        PrestamoService prestamoService = new PrestamoService(prestamosEnBiblioteca, usuariosEnBiblioteca, biblio);
        //---Scanner
        Scanner sc = new Scanner(System.in);
        int opcion=0;
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

        do{
            //menu
            menu();//llamo al menu
            opcion = sc.nextInt();//leer opcion
            sc.nextLine();//limpiar buffer
            limpiarPantalla();
            switch (opcion){
                case 1:
                    //Crear usuario
                    System.out.println("Crear usuario");
                    System.out.println("Introduce el nombre del usuario");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce el id del usuario");
                    String id = sc.nextLine();
                    usuarioService.create(nombre, id);//despues verificar que no se repita el id
                    System.out.println(usuarioService.readAll());
                    System.out.println("pulse cualquier tecla...");
                    sc.nextLine();
                    limpiarPantalla();
                    break;
                case 2:
                    //Leer todos los usuarios
                    System.out.println("Leer todos los usuarios");
                    System.out.println(usuarioService.readAll());
                    System.out.println("pulse cualquier tecla...");
                    sc.nextLine();
                    limpiarPantalla();
                    break;
                case 3:
                    //Leer un usuario por ID
                    System.out.println("Leer un usuario por ID");
                    System.out.println("Introduce el id del usuario");
                    String idUsuario = sc.nextLine();
                    System.out.println(usuarioService.readByID(idUsuario));
                    System.out.println("pulse cualquier tecla...");
                    sc.nextLine();
                    limpiarPantalla();
                    break;
                case 4:
                    //Actualizar un usuario por ID
                    System.out.println("Actualizar un usuario por ID");
                    System.out.println("Introduce el id del usuario");
                    String idUsuario2 = sc.nextLine();
                    System.out.println("Introduce el nuevo nombre del usuario");
                    String nombreUsuario = sc.nextLine();
                    usuarioService.updateByID(idUsuario2, nombreUsuario);
                    System.out.println(usuarioService.readAll());
                    System.out.println("pulse cualquier tecla...");
                    sc.nextLine();
                    limpiarPantalla();
                    break;
                case 5:
                    //Eliminar un usuario por ID
                    System.out.println("Eliminar un usuario por ID");
                    System.out.println("Introduce el id del usuario");
                    String idUsuario3 = sc.nextLine();
                    try {
                        usuarioService.deleteByID(idUsuario3);
                    }catch (Exception e){
                        System.out.println("Error al eliminar el usuario");
                        System.out.println(e.getMessage());
                    }
                    System.out.println("pulse cualquier tecla...");
                    sc.nextLine();
                    limpiarPantalla();
                    break;
                case 6:
                    //Crear libro
                    System.out.println("Crear libro");
                    System.out.println("Introduce el título del libro");
                    String titulo = sc.nextLine();
                    System.out.println("Introduce el autor del libro");
                    String autor = sc.nextLine();
                    System.out.println("Introduce el ISBN del libro");
                    String isbn = sc.nextLine();
                    System.out.println("Introduce el género del libro");
                    String genero = sc.nextLine();
                    try {
                        libroService.create(titulo, autor, isbn, genero);
                        System.out.println("Libro creado");
                    }catch (Exception e){
                        System.out.println("Error al crear el libro");
                    }
                    System.out.println(libroService.readAll());
                    System.out.println("pulse cualquier tecla...");
                    sc.nextLine();
                    limpiarPantalla();
                    break;
                case 7:
                    //Leer todos los libros
                    System.out.println("Leer todos los libros");
                    System.out.println(libroService.readAll());
                    System.out.println("pulse cualquier tecla...");
                    sc.nextLine();
                    limpiarPantalla();
                    break;
                case 8:
                    //Leer un libro por ISBN
                    System.out.println("Leer un libro por ISBN");
                    System.out.println("Introduce el ISBN del libro");
                    String isbnLibro = sc.nextLine();
                    System.out.println(libroService.readByISBN(isbnLibro));
                    System.out.println("pulse cualquier tecla...");
                    sc.nextLine();
                    limpiarPantalla();
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while (opcion != 0);
    }

    private static void limpiarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    private static void menu() {
        System.out.println("Bienvenido a la biblioteca");
        System.out.println("---------------------------");
        System.out.println("1. Crear usuario");
        System.out.println("2. Leer todos los usuarios");
        System.out.println("3. Leer un usuario por ID");
        System.out.println("4. Actualizar un usuario por ID");
        System.out.println("5. Eliminar un usuario por ID");
        System.out.println("6. Crear libro");
        System.out.println("7. Leer todos los libros");
        System.out.println("8. Leer un libro por ISBN");
        System.out.println("9. Leer un libro por título");
        System.out.println("10. Leer un libro por autor");
        System.out.println("11. Leer un libro por género");
        System.out.println("12. Prestar libro a usuario");
        System.out.println("13. Devolver libro");
        System.out.println("0. Salir");
        System.out.println("----------------------------");
        System.out.print("Elija una opción: ");
    }
}
