package com.befj.appproyectmovil.Code;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.befj.appproyectmovil.Adapters.administrardatosAdapter;
import com.befj.appproyectmovil.Models.Clsadministrardatos;
import com.befj.appproyectmovil.R;
import com.befj.appproyectmovil.Retrofit.RetrofitAdapter;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listaadministrardatosfragment extends Fragment {

    private RecyclerView rv_administrardatos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("ListaAdminDatosFragment", "onCreateView llamado");
        View root = inflater.inflate(R.layout.listaadministrardatosfragment, container, false);

        rv_administrardatos = root.findViewById(R.id.rv_administrardatos);
        rv_administrardatos.setLayoutManager(new LinearLayoutManager(root.getContext()));

        cargarDatos(root);

        return root;
    }

    private void cargarDatos(View root) {
        if (getArguments() != null) {
            String token = getArguments().getString("Token", "Tokendefault");
            Log.i("Respuestafragment", "Token: " + token);

            Call<List<Clsadministrardatos>> traerdato = RetrofitAdapter.getservices().traerdato("Bearer " + token);
            traerdato.enqueue(new Callback<List<Clsadministrardatos>>() {
                @Override
                public void onResponse(@NonNull Call<List<Clsadministrardatos>> call, @NonNull Response<List<Clsadministrardatos>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        List<Clsadministrardatos> objadministrardatoslist = response.body();
                        Log.i("Datos", "Datos recibidos: " + objadministrardatoslist.size());
                        administrardatosAdapter adaptador = new administrardatosAdapter(objadministrardatoslist, root.getContext());
                        rv_administrardatos.setAdapter(adaptador);
                    } else {
                        Log.e("Respueta", "Error en la respuesta: " + response.code() + " - " + response.message());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<Clsadministrardatos>> call, @NonNull Throwable t) {
                    Log.e("Respueta", "onFailure: " + t.getMessage());
                }
            });
        } else {
            Log.e("Respuestafragment", "No arguments received.");
        }
    }
}
