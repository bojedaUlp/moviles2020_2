package com.example.moviles2020_2.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviles2020_2.model.Inmueble;
import com.example.moviles2020_2.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddInmuebleViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Inmueble> inmuebleAlta;

    public AddInmuebleViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Inmueble> getInmuebleAlta(){
        if(inmuebleAlta==null){
            inmuebleAlta=new MutableLiveData<>();
        }
        return inmuebleAlta;
    }

    public String leerToken(){

        SharedPreferences sp= context.getSharedPreferences("token",0);
        String accesToken= sp.getString("token","-1");
        return accesToken;
    }

    public void altaInmueble(Inmueble inm){
        String token=leerToken();
        Call<Inmueble> alta= ApiClient.getMyApiClient().agregarInmueble(token,inm);
        alta.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful()){
                    Log.d("Salida" ,response.body()+"");
                }
                else{
                    Log.d("Salida", response.errorBody()+"");
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Log.d("salida Error",t.getMessage());
                Log.d("salida Error",call.request().body().toString());
                t.printStackTrace();
            }
        });
    }

}
