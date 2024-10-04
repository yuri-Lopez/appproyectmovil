package com.befj.appproyectmovil.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.befj.appproyectmovil.Models.Clsadministrardatos;
import com.befj.appproyectmovil.R;

import java.util.List;

public class administrardatosAdapter extends RecyclerView.Adapter<administrardatosAdapter.ViewHolder> {

    private final List<Clsadministrardatos> listaadministrardatos;

    public administrardatosAdapter(List<Clsadministrardatos> listaadministrardatos, Context ignoredContext) {
        this.listaadministrardatos = listaadministrardatos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.administrardatoscard, parent, false);
        return new ViewHolder(root);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Clsadministrardatos objadministrardatos = listaadministrardatos.get(position); // Obteniendo el objeto

        // Asignando datos a las vistas
        holder.tv_nombreadministrardatos.setText("Nombre: " + objadministrardatos.getNombre());
        holder.tv_apellidoAdministrardatos.setText("Apellido: " + objadministrardatos.getApellido());
        holder.tv_documentoadministrardatos.setText("Documento: " + objadministrardatos.getDocumento());
        holder.tv_telefonoadministrardatos.setText("Teléfono: " + objadministrardatos.getTelefono());
        holder.tv_correoelectronicoadministrardatos.setText("Correo Electrónico: " + objadministrardatos.getCorreoElectronico());
        holder.tv_planillaseguridadsocialadministrardatos.setText("Planilla Seguridad Social: " + objadministrardatos.getPlanillaSeguridadSocial());
    }

    @Override
    public int getItemCount() {
        return listaadministrardatos.size(); // Retornando el tamaño de la lista
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nombreadministrardatos, tv_apellidoAdministrardatos, tv_documentoadministrardatos,
                tv_telefonoadministrardatos, tv_correoelectronicoadministrardatos,
                tv_planillaseguridadsocialadministrardatos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nombreadministrardatos = itemView.findViewById(R.id.tv_nombreadministrardatos);
            tv_apellidoAdministrardatos = itemView.findViewById(R.id.tv_apellidoadministrardatos);
            tv_documentoadministrardatos = itemView.findViewById(R.id.tv_documentoadministrardatos);
            tv_telefonoadministrardatos = itemView.findViewById(R.id.tv_telefonoadministrardatos);
            tv_correoelectronicoadministrardatos = itemView.findViewById(R.id.tv_correoelectronicoadministrardatos);
            tv_planillaseguridadsocialadministrardatos = itemView.findViewById(R.id.tv_planillaseguridadsocialadministrardatos);
        }
    }
}
