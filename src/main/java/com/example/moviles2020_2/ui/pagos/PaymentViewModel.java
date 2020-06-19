package com.example.moviles2020_2.ui.pagos;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviles2020_2.model.Contrato;
import com.example.moviles2020_2.model.Inquilino;
import com.example.moviles2020_2.model.Pago;
import com.example.moviles2020_2.model.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class PaymentViewModel extends ViewModel {
    private MutableLiveData<List<Inmueble>> propiedades;
    private MutableLiveData<List<Pago>> pagos;
    private MutableLiveData<Inquilino> inquilino;

    public PaymentViewModel() {
        this.propiedades = new MutableLiveData<>();
        this.inquilino = new MutableLiveData<>();
        this.pagos = new MutableLiveData<>();
    }
public LiveData<List<Pago>> getPagos(){
        if (pagos== null){
            pagos = new MutableLiveData<>();
        }
        return pagos;
}

    public LiveData<List<Inmueble>> getPropiedades(){
        if(propiedades==null){
            propiedades=new MutableLiveData<>();
        }
        return propiedades;
    }
    public void setPagos(List<Pago> pagos) {
        this.pagos.setValue(pagos);
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



    public void obtenerPagos(){

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void obtenerInquilino(int id){


    }


}
