package com.example.moviles2020_2.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviles2020_2.model.Inmueble;
import com.example.moviles2020_2.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BajaInmuebleViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> operacion;
    private MutableLiveData<Inmueble> bajaInm;
    public BajaInmuebleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Inmueble> getBajaInm(){
        if(bajaInm==null){
            bajaInm=new MutableLiveData<>();
        }
        return bajaInm;
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

    public void bajaInmueble(int id){
        String token=leerToken();
        Call<String> baja= ApiClient.getMyApiClient().bajaInm(token, id);
        baja.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context, "Se ha dado de baja el inmueble", Toast.LENGTH_LONG).show();
                    operacion.setValue("Exitoso");
                }
                else{
                    Toast.makeText(context, "ocurrio un error " + response.errorBody(), Toast.LENGTH_LONG).show();
                    operacion.setValue("No se pudo dar de baja");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                operacion.setValue(t.getLocalizedMessage());
                Log.d("salida Error",t.getMessage());
                Log.d("salida Error",call.request().body().toString());
                t.printStackTrace();
            }
        });
    }
}
