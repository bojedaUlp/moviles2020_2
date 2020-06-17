package com.example.moviles2020_2.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class GeneralData {


    private static List<Usuario> lista;
    private List<Inmueble> propiedads;

    public GeneralData() {

        lista = new ArrayList<Usuario>();
        Usuario uno = new Usuario(1, "29887502", "Lucero", "Pedro", "2664565685", "a@mail.com", "123");
        lista.add(uno);
        Usuario dos = new Usuario(2, "31518239", "Ramos", "Anahi", "2664001278", "b@mail.com", "123");
        lista.add(dos);
        Usuario tres = new Usuario(3, "33245623", "Caballero", "Gustavo", "2664582990", "c@mail.com", "123");
        lista.add(tres);
        Usuario cuatro = new Usuario(4, "41256323", "Ramos", "Pamela", "2665451236", "d@mail.com", "123");
        lista.add(cuatro);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Usuario obtenerPorMail(String mail){
        return lista.stream()
                .filter(x -> mail.equals(x.getMail()))
                .findAny()
                .orElse(null);
    }





}
