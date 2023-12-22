package com.miapp.biblioteca;
public class Prestamo {
    //atributos
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;
    private boolean devuelto;

    //constructores
    public Prestamo(Usuario usuario, Libro libro, String fechaPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = false;
    }
    public Prestamo(){

    }
    //getters y setters
    public Usuario getUsuario() {
        return usuario;
    }
    public Libro getLibro() {
        return libro;
    }
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
    public boolean isDevuelto() {
        return devuelto;
    }

    //método toString

    @Override
    public String toString() {
        return "Prestamo{" +
                "usuario='" + usuario.getNombre() + '\'' +
                ", libro='" + libro.getTitulo() + '\'' +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", devuelto=" + devuelto +
                '}';
    }
}
