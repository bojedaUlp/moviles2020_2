package com.example.moviles2020_2.request;

import android.util.Log;

import com.example.moviles2020_2.model.Inmueble;
import com.example.moviles2020_2.model.Propietario;
import com.example.moviles2020_2.model.Usuario;
import com.example.moviles2020_2.model.UsuarioLogin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApiClient {

    public static final String PATH="http://192.168.0.2:45455/api/";
    private static MyApiInterface myApiInterface;

    public static MyApiInterface getMyApiClient(){
        Gson gson= new GsonBuilder().setLenient().create();
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        myApiInterface= retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInterface;
    }

    public interface MyApiInterface {

        @POST("propietario/login")
        Call<String> login(@Body UsuarioLogin us);

        @GET("propietario")
        Call<Propietario> perfilP(@Header("Authorization")  String token);

        @PUT("propietario")
        Call<Propietario> actualizarP(@Header("Authorization") String token, @Body Propietario prop);

        @POST("inmueble")
        Call<Inmueble> agregarInmueble(@Header("Authorization")String token, @Body Inmueble inm);

        @GET("inmueble")
        Call<List<Inmueble>> listarInmuebles(@Header("Authorization") String token);

        @GET("inmueble")
        Call<Inmueble> verInmueble(@Header("Authorization") String token, int id_Inmueble);
        @PUT("inmueble")
        Call<Inmueble> actualizarInm(@Header("Authorization")String token, @Body Inmueble inm);

        @DELETE("inmueble/{id}")
        Call<String> bajaInm(@Header("Authorization")  String token, @Path("id") int id_Inmueble);






    }
}
