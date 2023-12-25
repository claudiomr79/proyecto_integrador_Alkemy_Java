package com.miapp.biblioteca.service;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.Libro;
import java.util.ArrayList;

public class UsuarioService {
    //Atributos
    private ArrayList<Usuario> usuarios; //listado de usuarios de la biblioteca
    //Constructores
    public UsuarioService(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /*CRUD*/
    //Crear usuario (Create)
    public void create(String nombre, String id){
        if(readByID(id) != null){
            System.out.println("Ya existe un usuario con el id: " + id);
            return;
        }else{
            Usuario nuevoUsuario = new Usuario(nombre, id);
            usuarios.add(nuevoUsuario);
            System.out.println("Usuario creado");
        }
    }
    //Leer todos los usuarios(Read)
    public ArrayList<Usuario> readAll(){
        return usuarios;
    }
    //Leer un usuario por ID(Read by ID)
    public Usuario readByID(String id){
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
    //Actualizar un usuario por ID(Update by ID)
    public void updateByID(String id, String nombre){
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuario.setNombre(nombre);
                System.out.println("Usuario actualizado");
                return; //para que no siga buscando
            }
        }
        System.out.println("No se ha encontrado el usuario con el id: " + id);
    }
    //Eliminar un usuario por ID(Delete by ID)
    public void deleteByID(String id){
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                //chequear que no tenga libros en su poder
                if(usuario.getLibrosPrestados().size() > 0){
                    System.out.println("El usuario tiene libros en su poder, no se puede eliminar");
                    return;
                }
                usuarios.remove(usuario);
                System.out.println("Usuario eliminado");
                return; //para que no siga buscando
            }
        }
        System.out.println("No se ha encontrado el usuario con el id: " + id);
    }
    //--------------------------------------------------------
    //agregar libro prestado a la lista de libros prestados del usuario
    public void agregarLibroPrestadoAlista(Usuario usuario, Libro libro){
        usuario.getLibrosPrestados().add(libro);
    }
    //devolver libro prestado en la lista de libros prestados del usuario
    public void devolverLibroPrestadoEnlista(Usuario usuario, Libro libro){
        usuario.getLibrosPrestados().remove(libro);
    }
}
