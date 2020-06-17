package com.example.moviles2020_2.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviles2020_2.model.Propietario;
import com.example.moviles2020_2.model.Usuario;
import com.example.moviles2020_2.request.ApiClient;

import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Propietario> prop;
    private MutableLiveData<String> operacion;


    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<String> getOperacion(){
        if(operacion==null){
            operacion=new MutableLiveData<>();
        }
        return operacion;
    }

    public LiveData<Propietario> getPropietario(){
        if (prop==null){
            prop = new MutableLiveData<>();
        }
        return prop;
    }


    public String leerToken(){

        SharedPreferences sp= context.getSharedPreferences("token",0);
        String accesToken= sp.getString("token","-1");
        return accesToken;
        }

     public void traerDatosPropietario(){
         String token= leerToken();
         Call<Propietario> dato= ApiClient.getMyApiClient().perfilP(token);
         dato.enqueue(new Callback<Propietario>() {
             @Override
             public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                 if (response.isSuccessful()){
                     prop.setValue(response.body());
                     Log.d("Salida" ,response.body() + "");
                     operacion.setValue(response.message());
                 }
             }

             @Override
             public void onFailure(Call<Propietario> call, Throwable t) {
                 operacion.setValue("Ocurrio el siguiente error" + t.getMessage());
                 Log.d("salida Error",t.getMessage());
                 Log.d("salida Error",call.request().body().toString());
                 t.printStackTrace();
             }
         });

     }

     public void actualizarDatosPropietario(Propietario p){
        String token= leerToken();
        if(p.getNombreP().length()>0 && p.getApellidoP().length()>0 && p.getDireccionP().length()>0 && p.getDniP().length()>0 && p.getEmail().length()>0 && p.getPassword().length()>0 && p.getTelefonoP().length()>0){
            Call<Propietario> dato= ApiClient.getMyApiClient().actualizarP(token,p);
            dato.enqueue(new Callback<Propietario>() {
                @Override
                public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(context, "Se actualizaron los datos de su perfil", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Propietario> call, Throwable t) {
                    Toast.makeText(context, "Ocurrio un error al actualizar sus datos :" +t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
        else{ Toast.makeText(context, "Debe completar todos sus datos", Toast.LENGTH_LONG).show();}
     }

    }

