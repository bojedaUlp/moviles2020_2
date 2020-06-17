package com.example.moviles2020_2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviles2020_2.model.Usuario;
import com.example.moviles2020_2.model.GeneralData;
import com.example.moviles2020_2.model.UsuarioLogin;
import com.example.moviles2020_2.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
 private Context context;
 private MutableLiveData<String> error;
    private MutableLiveData<String> exitoso;
    private MutableLiveData<String> token;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }


    public LiveData<String> getExitoso(){
        if(exitoso==null){
            exitoso = new MutableLiveData<>();
        }
        return exitoso;
    }

    public LiveData<String> getError() {
        if (error == null){
            error = new MutableLiveData<>();
        }
        return error;
    }

    public LiveData<String> getToken(){
        if(token== null){
            token= new MutableLiveData<String>();
        }
            return token;
    }

    public void ingresar(String email, String pass){
        UsuarioLogin usuario= new UsuarioLogin(email,pass);
        Call<String> miUsuario= ApiClient.getMyApiClient().login(usuario);
        miUsuario.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    if(response.body().length()>0) {
                        String token = response.body();

                        SharedPreferences sp = context.getSharedPreferences("token",0);
                        SharedPreferences.Editor editor = sp.edit();

                        editor.putString("token",token);

                        editor.commit();

                        exitoso.postValue(token);
                    }
                }else{
                    error.postValue("No se encontro el usuario, verifique sus datos");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                error.postValue("Ha ocurrido el siguiente error: " + t.getMessage());
                Log.d("salida Error",t.getMessage());
                Log.d("salida Error",call.request().body().toString());
                t.printStackTrace();
            }
        });
    }

}
