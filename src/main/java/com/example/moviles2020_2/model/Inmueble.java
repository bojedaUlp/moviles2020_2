package com.example.moviles2020_2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inmueble {
    private int id_Inmueble;
    private int id_Propietario;
    private String direccion;
    private  String uso;
    private String tipo;
    private int cantAmbientes;
    private double precioInm;
    private int estadoInm;

    public Inmueble(int id_Inmueble, int id_Propietario, String direccion, String uso, String tipo, int cantAmbientes, double precioInm, int estadoInm) {
        this.id_Inmueble = id_Inmueble;
        this.id_Propietario = id_Propietario;
        this.direccion = direccion;
        this.uso = uso;
        this.tipo = tipo;
        this.cantAmbientes = cantAmbientes;
        this.precioInm = precioInm;
        this.estadoInm = estadoInm;
    }
    public Inmueble (){}

    public int getId_Inmueble() {
        return id_Inmueble;
    }

    public void setId_Inmueble(int id_Inmueble) {
        this.id_Inmueble = id_Inmueble;
    }

    public int getId_Propietario() {
        return id_Propietario;
    }

    public void setId_Propietario(int id_Propietario) {
        this.id_Propietario = id_Propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public double getPrecioInm() {
        return precioInm;
    }

    public void setPrecioInm(double precioInm) {
        this.precioInm = precioInm;
    }

    public int getEstadoInm() {
        return estadoInm;
    }

    public void setEstadoInm(int estadoInm) {
        this.estadoInm = estadoInm;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "id_Inmueble=" + id_Inmueble +
                ", id_Propietario=" + id_Propietario +
                ", direccion='" + direccion + '\'' +
                ", uso='" + uso + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cantAmbientes=" + cantAmbientes +
                ", precioInm=" + precioInm +
                ", estadoInm=" + estadoInm +
                '}';
    }
}
