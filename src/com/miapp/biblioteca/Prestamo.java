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
        if (devuelto){
            String ok = "Prestamo devuelto";
            return "\n\tPrestamo{" +
                    "usuario =" + usuario.getNombre() +
                    "Id =" + usuario.getId() +
                    ", libro =" + libro.getTitulo() +
                    ", ISBN " + libro.getISBN() +
                    ", fechaPrestamo ='" + fechaPrestamo + '\'' +
                    ", devuelto =" + ok +
                    '}';
        }else {
            String ok = "Prestamo no devuelto";
            return "\n\tPrestamo{" +
                    "usuario =" + usuario.getNombre() +
                    "Id =" + usuario.getId() +
                    ", libro =" + libro.getTitulo() +
                    ", ISBN " + libro.getISBN() +
                    ", fechaPrestamo ='" + fechaPrestamo + '\'' +
                    ", devuelto =" + ok +
                    '}';
        }
    }
}
