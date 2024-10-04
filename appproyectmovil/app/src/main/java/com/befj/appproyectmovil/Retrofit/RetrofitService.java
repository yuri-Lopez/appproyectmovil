package com.befj.appproyectmovil.Retrofit;

import com.befj.appproyectmovil.Models.Clsadministrardatos;

import com.befj.appproyectmovil.Models.DtoInfoLogin;
import com.befj.appproyectmovil.Models.DtoLogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitService {

    @POST("login")
    Call<DtoInfoLogin> login(@Body DtoLogin log);

    @GET("http://10.0.2.2:8080/AdministrarDatos/traerdato")
    Call<List<Clsadministrardatos>> traerdato(@Header("Authorization")String Token);


}
