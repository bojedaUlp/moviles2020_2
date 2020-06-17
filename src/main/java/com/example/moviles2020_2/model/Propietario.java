package com.example.moviles2020_2.model;

import androidx.annotation.NonNull;

public class Propietario {
    int id_Propietario;
    String nombreP;
    String apellidoP;
    String dniP;
    String direccionP;
    String telefonoP;
    String email;
    String password;

    public Propietario(int id_Propietario, String nombreP, String apellidoP, String dniP, String direccionP, String telefonoP, String email, String password) {
        this.id_Propietario = id_Propietario;
        this.nombreP = nombreP;
        this.apellidoP = apellidoP;
        this.dniP = dniP;
        this.direccionP = direccionP;
        this.telefonoP = telefonoP;
        this.email = email;
        this.password = password;
    }

    public Propietario(){}

    public int getId_Propietario() {
        return id_Propietario;
    }

    public void setId_Propietario(int id_Propietario) {
        this.id_Propietario = id_Propietario;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getDniP() {
        return dniP;
    }

    public void setDniP(String dniP) {
        this.dniP = dniP;
    }

    public String getDireccionP() {
        return direccionP;
    }

    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

    public String getTelefonoP() {
        return telefonoP;
    }

    public void setTelefonoP(String telefonoP) {
        this.telefonoP = telefonoP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "id_Propietario=" + id_Propietario +
                ", nombreP='" + nombreP + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", dniP='" + dniP + '\'' +
                ", direccionP='" + direccionP + '\'' +
                ", telefonoP='" + telefonoP + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
