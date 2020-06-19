package com.example.moviles2020_2.ui.propiedades;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Inmueble;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>  {

    List<Inmueble> listaPropiedad;
    private Context context;

    public Adapter(List<Inmueble> listaPropiedad) {
        this.listaPropiedad = listaPropiedad;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.agregar_inmueble, parent, false);
        return new ViewHolder(vista, listaPropiedad);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cargaPropiedad(listaPropiedad.get(position));
    }

    @Override
    public int getItemCount() {
        return listaPropiedad.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        EditText tvDireccion, tvAmbientes, tvTipo, tvUso, tvPrecio, tvDisponible;
        Button btnGuadarPropiedad;
        List<Inmueble> lista;


        public ViewHolder(@NonNull View itemView, List<Inmueble> lista) {
            super(itemView);
            tvDireccion = itemView.findViewById(R.id.etDireccionInm);
            tvAmbientes = itemView.findViewById(R.id.etCantAm);
            tvTipo = itemView.findViewById(R.id.etTipoInm);
            tvUso = itemView.findViewById(R.id.etUsoInm);
            tvPrecio = itemView.findViewById(R.id.etPrecioInm);
            tvDisponible = itemView.findViewById(R.id.etEstadoInm);
            btnGuadarPropiedad = itemView.findViewById(R.id.btnGuardarin);
            btnGuadarPropiedad.setOnClickListener(this);
            this.lista = lista;
        }

        public void cargaPropiedad(Inmueble p){
            tvDireccion.setText(p.getDireccion());
            tvAmbientes.setText(p.getCantAmbientes()+"");
            //tvTipo.setText(p.getTipo());
            tvUso.setText(p.getUso());
            tvPrecio.setText(p.getPrecioInm()+"");
            //tvDisponible.setText(p.getDisponible()+"");
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Inmueble propiedad = listaPropiedad.get(position);
            //Toast.makeText(btnBuscaPropiedad.getContext(), propiedad.getDireccion(), Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();
            bundle.putInt("propiedadId", propiedad.getId_Inmueble());
            Navigation.findNavController(v).navigate(R.id.propiedadDetailFragment, bundle);

        }
    }

}
