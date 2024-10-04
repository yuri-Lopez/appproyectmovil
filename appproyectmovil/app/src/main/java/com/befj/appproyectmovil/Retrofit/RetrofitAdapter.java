package com.befj.appproyectmovil.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {

    private static RetrofitService _serv;


    //127.0.0.1 = localhost
    private static final String Base_url = "http://10.0.2.2:8080/";


    public static RetrofitService getservices(){
        if(_serv == null){
            //crea una nueva instancia de retrofit con el servicio
            Retrofit retro = new Retrofit.Builder()
                    .baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            _serv = retro.create(RetrofitService.class);
            return _serv;
        }
        //devuelve el servicio que ya esta instanciado
        return _serv;
    }
}
