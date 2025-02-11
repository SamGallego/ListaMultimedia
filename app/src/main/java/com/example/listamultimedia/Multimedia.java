package com.example.listamultimedia;

public class Multimedia {
    private String titulo;
    private String ruta;
    private String tipo;

    public Multimedia(String titulo, String ruta, String tipo) {
        this.titulo = titulo;
        this.ruta = ruta;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titulo='" + titulo + '\'' +
                ", ruta='" + ruta + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
