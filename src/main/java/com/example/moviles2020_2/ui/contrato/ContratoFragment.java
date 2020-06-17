package com.example.moviles2020_2.ui.contrato;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class ContratoFragment extends Fragment {

    private ContratoViewModel mViewModel;
    List<Inmueble> listaMutable;
    RecyclerView contenedor;


    public static ContratoFragment newInstance() {
        return new ContratoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.contrato_fragment, container, false);
        try {
            mViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoViewModel.class);
            contenedor = view.findViewById(R.id.rvContratoFragment);

            RecyclerView.LayoutManager layout= new LinearLayoutManager(getContext());
            contenedor.setLayoutManager(layout);

            mViewModel.obtenerPropiedades();

            listaMutable = new ArrayList<>();
            final Observer<List<Inmueble>> listaObservable = new Observer<List<Inmueble>>() {
                @Override
                public void onChanged(List<Inmueble> propiedads) {
                    contenedor.setAdapter(new AdapterContrato(propiedads));
                }
            };
            mViewModel.getPropiedades().observe(getViewLifecycleOwner(), listaObservable);
        }catch (Exception e){
            Log.d("verContratoFragment", e.getMessage());
        }




        return view;

    }


}
