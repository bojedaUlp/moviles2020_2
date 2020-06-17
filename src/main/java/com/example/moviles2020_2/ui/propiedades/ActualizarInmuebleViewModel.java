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

public class ActualizarInmuebleViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Inmueble> inm;
    public ActualizarInmuebleViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Inmueble> getInm(){
        if(inm==null){
            inm=new MutableLiveData<>();
        }
        return inm;
    }
    public String leerToken(){

        SharedPreferences sp= context.getSharedPreferences("token",0);
        String accesToken= sp.getString("token","-1");
        return accesToken;
    }

    public void ActualizarInmueble(Inmueble i){
        String token=leerToken();
        Call<Inmueble> actualizarI= ApiClient.getMyApiClient().actualizarInm(token, i);
        actualizarI.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if (response.isSuccessful()){
                    Toast.makeText(context, "Se guardaron los datos", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context,"Ocurrio el siguiente error" + response.errorBody().toString(), Toast.LENGTH_LONG).show();
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
