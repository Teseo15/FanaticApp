package com.example.calificado6.model;
public class Pelicula {
    private String titulo;
    private String año;
    private  String director;
    private  int idImagen;
    private  int detalle;
    public Pelicula(String titulo, String año, String director, int idImagen,int detalle) {
        this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.idImagen = idImagen;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAño() {
        return año;
    }
    public void setAño(String año) {
        this.año = año;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getIdImagen() {
        return idImagen;
    }
    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
    public int getDetalle() {
        return detalle;
    }
    public void setDetalle(int detalle) {
        this.detalle = detalle;
    }
    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", año='" + año + '\'' +
                ", director='" + director + '\'' +
                ", idImagen=" + idImagen +
                '}';
    }
}
