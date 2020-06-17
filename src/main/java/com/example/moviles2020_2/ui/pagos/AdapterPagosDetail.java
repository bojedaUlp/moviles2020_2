package com.example.moviles2020_2.ui.pagos;

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
import com.example.moviles2020_2.model.Pago;
import com.example.moviles2020_2.model.Pago;

import java.util.List;

public class AdapterPagosDetail extends RecyclerView.Adapter<AdapterPagosDetail.ViewHolder> {

    List<Pago> listaPago;

    public AdapterPagosDetail(List<Pago> listaPago) {
        this.listaPago = listaPago;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pagos, parent, false);
        return new ViewHolder(vista, listaPago);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cargaPago(listaPago.get(position));
    }

    @Override
    public int getItemCount() {
        return listaPago.size();
    }



    //clase Interna


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView etCIPropNumero, etCIPropFecha, etCIPropImporte;

        List<Pago> lista;


        public ViewHolder(@NonNull View v, List<Pago> lista) {
            super(v);
            etCIPropNumero = v.findViewById(R.id.etCIPropNumero);
            etCIPropFecha = v.findViewById(R.id.etCIPropFecha);
            etCIPropImporte = v.findViewById(R.id.etCIPropImporte);

            this.lista = lista;
        }

        public void cargaPago(Pago p){
            etCIPropNumero.setText(p.getNumero()+"");
            etCIPropFecha.setText(p.getFecha()+"");
            etCIPropImporte.setText(p.getImporte()+"");


        }

        @Override
        public void onClick(View v) {

        }
    }

}
