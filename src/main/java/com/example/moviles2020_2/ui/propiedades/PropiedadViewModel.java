package com.example.moviles2020_2.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.moviles2020_2.model.Inmueble;
import com.example.moviles2020_2.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropiedadViewModel extends AndroidViewModel {

    private MutableLiveData<List<Inmueble>> inmuebles;
    private MutableLiveData<String> operacion;
    private Context context;

    public PropiedadViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<List<Inmueble>> getInmuebles(){
        if(inmuebles==null){
            inmuebles=new MutableLiveData<>();
        }
        return inmuebles;
    }
    public LiveData<String> getOperacion(){
        if(operacion==null){
            operacion=new MutableLiveData<>();
        }
        return operacion;
    }
    public String leerToken(){

        SharedPreferences sp= context.getSharedPreferences("token",0);
        String accesToken= sp.getString("token","-1");
        return accesToken;
    }
    public void traerListaInmuebles(){
        String token= leerToken();
        Call<List<Inmueble>> listaInm= ApiClient.getMyApiClient().listarInmuebles(token);
        listaInm.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if(response.isSuccessful()) {
                    inmuebles.setValue(response.body());
                    operacion.setValue(response.message());
                    Log.d("res ", operacion.getValue() +"");
                }
                else{
                    Log.d("Salida error " , response.errorBody() +"");
                    operacion.setValue(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {
                Log.d("salida Error",t.getMessage());
                Log.d("salida Error",call.request().body().toString());
                t.printStackTrace();
            }
        });
    }



}
