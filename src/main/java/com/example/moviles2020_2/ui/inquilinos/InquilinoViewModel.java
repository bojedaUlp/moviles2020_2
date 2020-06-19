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

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void obtenerInquilino(int id){


    }



}
