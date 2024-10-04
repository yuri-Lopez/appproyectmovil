package com.befj.appproyectmovil.Code;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;


import com.befj.appproyectmovil.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class UserActivity extends AppCompatActivity {

    private String Token;

    FragmentContainerView fcv_activityuser;
    BottomNavigationView bnv_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Token = getIntent().getStringExtra("Token");

        fcv_activityuser = findViewById(R.id.fcv_activityuser);

        bnv_menu = findViewById(R.id.bnv_menuapp);
        reemplazarfragment(new listaadministrardatosfragment(),Token);
        Log.i("Respuesta", "onCreate: "+ Token);

        bnv_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.mnit_administrardatos){
                    reemplazarfragment(new listaadministrardatosfragment(),Token);
                } else if (item.getItemId() == R.id.mnit_color1) {
                    reemplazarfragment(new Color1Fragment(),Token);
                }
                else if (item.getItemId() == R.id.mnit_color2) {
                    reemplazarfragment(new Color2Fragment(),Token);
                }
                return true;
            }
        });
    }
    public void reemplazarfragment(Fragment fragment, String Token){
        Log.i("UserActivity", "Cambiando a fragment: " + fragment.getClass().getSimpleName());
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        Bundle objinfo = new Bundle();
        objinfo.putString("Token", Token);
        fragment.setArguments(objinfo);
        tran.replace(R.id.fcv_activityuser, fragment);
        tran.commit();
    }


}