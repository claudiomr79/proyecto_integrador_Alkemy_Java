package com.miapp.biblioteca.service;
import com.miapp.biblioteca.Prestamo;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.Libro;
import java.util.ArrayList;
public class PrestamoService {
    //Atributos
    private ArrayList<Prestamo> prestamos; //listado de prestamos de la biblioteca
    private ArrayList<Usuario> usuariosEnBiblioteca;
    private ArrayList<Libro> librosEnBiblioteca;
    //Constructores
    public PrestamoService(ArrayList<Prestamo> prestamos, ArrayList<Usuario> usuariosEnBiblioteca, ArrayList<Libro> librosEnBiblioteca) {
        this.prestamos = prestamos;
        this.usuariosEnBiblioteca = usuariosEnBiblioteca;
        this.librosEnBiblioteca = librosEnBiblioteca;
    }

    /*CRUD*/

    //Crear prestamo (Create) __Prestar libro a usuario
    public void create(Usuario usuario , Libro libro, String fechaPrestamo){
        LibroService libroService = new LibroService(librosEnBiblioteca);

        //verificar que exista el usuario
        if (usuario == null) {
            System.out.println("El usuario no existe");
            return;
        }
        //verifica que exista el libro
        if (libroService.readByISBN(libro.getISBN()) != null) {
            //chequear que el libro esté disponible
            if(libroService.readByISBN(libro.getISBN()).isDisponible() == false){
                System.out.println("El libro no está disponible");
                return;
            }
            //cambiar el estado del libro a prestado
            libroService.readByISBN(libro.getISBN()).setDisponible(false);
        }else{
            System.out.println("El libro no existe");
            return;
        }
        Prestamo nuevoPrestamo = new Prestamo(usuario, libro, fechaPrestamo);
        prestamos.add(nuevoPrestamo);
        //agregar el libro a la lista de libros prestados del usuario
        UsuarioService usuarioService = new UsuarioService(usuariosEnBiblioteca);
        usuarioService.agregarLibroPrestadoAlista(usuario, libro);
    System.out.println("Libro prestado");
    }
    //Leer todos los prestamos(Read)
    public ArrayList<Prestamo> readAll(){
        return prestamos;
    }
    //Leer un prestamo por ID de usuario (Read by ID)
    public Prestamo readByID(String id){
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuario().getId().equals(id)) {
                return prestamo;
            }
        }
        return null;
    }

    //Actualizar un prestamo no lo necesitamos, ya que una vez hecho no tiene sentido actualizarlo

    //Eliminar un prestamo por libro__Devolver libro
    public void deleteByLibro(Libro libro){
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().equals(libro)) {
                //eliminar el libro de la lista de libros prestados del usuario
                UsuarioService usuarioService = new UsuarioService(usuariosEnBiblioteca);
                prestamos.forEach(prest -> {
                    if (prest.getLibro().equals(libro)) {
                        usuarioService.devolverLibroPrestadoEnlista(prest.getUsuario(), libro);
                    }
                });
                //cambiar el estado del libro a disponible
                LibroService libroService = new LibroService(librosEnBiblioteca);
                libroService.readByISBN(libro.getISBN()).setDisponible(true);
                prestamos.remove(prestamo);
                System.out.println("Libro devuelto");
                return;
            }
        }
        System.out.println("El libro : " + libro.getTitulo() + " con el ISBN: " + libro.getISBN() + " no se ha prestado");
    }
}
