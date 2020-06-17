package com.example.moviles2020_2.model;

public class Contrato {
    private int id;
    private double precio;
    private String inicio;
    private String fin;
    private Inquilino inquilino;
    private Inmueble propiedad;

    public Contrato() {
    }

    public Contrato(int id, double precio, String inicio, String fin) {
        this.id = id;
        this.precio = precio;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Inmueble propiedad) {
        this.propiedad = propiedad;
    }
}
