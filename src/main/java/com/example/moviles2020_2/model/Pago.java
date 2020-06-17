package com.example.moviles2020_2.model;

import java.util.Date;

public class Pago {
    private int id;
    private  int numero;
    private Contrato contrato;
    private String fecha;
    private double importe;

    public Pago(int id, int numero, Contrato contrato, String fecha, double importe) {
        this.id = id;
        this.numero = numero;
        this.contrato = contrato;
        this.fecha = fecha;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
