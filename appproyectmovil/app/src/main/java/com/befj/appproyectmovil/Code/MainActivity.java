package com.befj.appproyectmovil.Code;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.befj.appproyectmovil.Models.DtoInfoLogin;
import com.befj.appproyectmovil.Models.DtoLogin;
import com.befj.appproyectmovil.R;
import com.befj.appproyectmovil.Retrofit.RetrofitAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText et_usuario,et_contraseña ;
    Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_usuario = findViewById(R.id.et_usuario);
        et_contraseña = findViewById(R.id.et_contraseña);
        btn_ingresar = findViewById(R.id.btn_ingresar);



        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarsesion(et_usuario.getText().toString(),et_contraseña.getText().toString());
            }
        });
    }

    public void iniciarsesion(String Usuario, String Contraseña){
        DtoLogin objlog = new DtoLogin();
        objlog.setUsuario(Usuario);
        objlog.setContraseña(Contraseña);

        Call<DtoInfoLogin> login = RetrofitAdapter.getservices().login(objlog);
        login.enqueue(new Callback<DtoInfoLogin>() {
            @Override
            public void onResponse(Call<DtoInfoLogin> call, Response<DtoInfoLogin> response) {
                if(response.isSuccessful()){
                    DtoInfoLogin infolog = response.body();
                    if(Contraseña.equals(infolog.getAdmininfo().getContraseña())){
                        Toast.makeText(MainActivity.this, "Token: " + infolog.getToken(), Toast.LENGTH_SHORT).show();

                        Intent cambiaract = new Intent(MainActivity.this, UserActivity.class);
                        cambiaract.putExtra("Token",infolog.getToken());
                        startActivity(cambiaract);

                    }
                    else{
                        Toast.makeText(MainActivity.this, "La contraseña es incorrrecta", Toast.LENGTH_SHORT).show();
                    }
                }
                else {

                    Log.i("Respuesta", "No se pudo iniciar sesion" + response.raw() + response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<DtoInfoLogin> call, Throwable t) {
                Log.e("Respuesta", "onFailure: " + t.getMessage() + t.getCause());
            }
        });


    }











}