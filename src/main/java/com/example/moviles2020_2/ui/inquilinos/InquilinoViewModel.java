package com.example.moviles2020_2.ui.inquilinos;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviles2020_2.model.Inquilino;
import com.example.moviles2020_2.model.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class InquilinoViewModel extends ViewModel {
    private MutableLiveData<List<Inmueble>> propiedades;
    private MutableLiveData<Inquilino> inquilino;

    public InquilinoViewModel() {
        this.propiedades = new MutableLiveData<>();
        this.inquilino = new MutableLiveData<>();
    }

    public LiveData<List<Inmueble>> getPropiedades(){
        if(propiedades==null){
            propiedades=new MutableLiveData<>();
        }
        return propiedades;
    }

    public void setPropiedades(List<Inmueble> propiedades) {
        this.propiedades.setValue(propiedades);
    }

    public LiveData<Inquilino> getInquilino(){
        if (inquilino==null){
            inquilino= new MutableLiveData<>();
        }
        return inquilino;
    }

    public void setInquilino(Inquilino c){
        this.inquilino.setValue(c);
    }

    public void obtenerPropiedades(){
        List<Inmueble> lista = new ArrayList<Inmueble>();
        lista.add(new Inmueble(1, "Sucre 2250", 4, "Depto", "Residencial", 10000, true));
        lista.add(new Inmueble(2, "Poblet 548", 10, "Depto", "Comercial", 50000, true));
        lista.add(new Inmueble(3, "Bolivar 815", 1, "Depto", "Comercial", 5000, true));
        lista.add(new Inmueble(4, "Colon 3213", 3, "Depto", "Residencial", 15000, true));
        lista.add(new Inmueble(5, "Lince 22 19", 6, "Depto", "Comercial", 30000, true));
        lista.add(new Inmueble(6, "Italia 11 Sur", 2, "Depto", "Comercial", 10000, true));
        lista.add(new Inmueble(7, "Ruta 3 Km 11", 8, "Depto", "Residencial", 80000, true));
        lista.add(new Inmueble(8, "Ruta 20 km 4", 3, "Depto", "Residencial", 15000, true));
        lista.add(new Inmueble(9, "Av Illia 185", 4, "Depto", "Comercial", 20000, true));
        setPropiedades(lista);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void obtenerInquilino(int id){
        List<Inquilino> lista = new ArrayList<Inquilino>();
        lista.add(new Inquilino(1,
                "31518239",
                "Ramos",
                "Anahi",
                "Lince 22 19",
                "2665115896"));


        Inquilino prop = lista.stream()
                .filter(x -> id == (x.getId()))
                .findAny()
                .orElse(null);

        if (prop != null){
            setInquilino(prop);
        }

    }



}
