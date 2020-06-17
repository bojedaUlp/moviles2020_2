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



    public void obtenerPagos(){
        List<Pago> lista = new ArrayList<Pago>();
        lista.add(new Pago(1,1, new Contrato(),"01/01/2000",4000));
        lista.add(new Pago(2,2, new Contrato(),"01/02/2000",4000));
        lista.add(new Pago(3,3, new Contrato(),"01/03/2000",4000));
        lista.add(new Pago(4,4, new Contrato(),"01/04/2000",4000));
        lista.add(new Pago(5,5, new Contrato(),"01/05/2000",4000));
        lista.add(new Pago(6,6, new Contrato(),"01/06/2000",4000));
        lista.add(new Pago(7,7, new Contrato(),"01/07/2000",4000));

        setPagos(lista);
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
