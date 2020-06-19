package com.example.moviles2020_2.ui.contrato;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviles2020_2.model.Contrato;
import com.example.moviles2020_2.model.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class ContratoViewModel extends ViewModel {
    private MutableLiveData<List<Inmueble>> propiedades;
    private MutableLiveData<Contrato> contrato;


    public ContratoViewModel() {
        this.propiedades = new MutableLiveData<List<Inmueble>>();
        this.contrato = new MutableLiveData<>();
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

    public LiveData<Contrato> getContrato(){
        if (contrato==null){
            contrato= new MutableLiveData<>();
        }
        return contrato;
    }

    public void setContrato(Contrato c){
        this.contrato.setValue(c);
    }


    // desde aca lleno el fragment main
    public void obtenerPropiedades(){

    }


    //desde aca lleno el fragment detail
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void obtenerContrato(int id){
        List<Contrato> lista = new ArrayList<Contrato>();
        lista.add(new Contrato(1, 14000, "01/01/2000", "01/10/2002"));


        Contrato prop = lista.stream()
                .filter(x -> id == (x.getId()))
                .findAny()
                .orElse(null);

        if (prop != null){
            setContrato(prop);
        }

    }


    //cambiar disponible

}
