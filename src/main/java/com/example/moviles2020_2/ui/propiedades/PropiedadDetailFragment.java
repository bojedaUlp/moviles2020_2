package com.example.moviles2020_2.ui.propiedades;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Inmueble;

public class PropiedadDetailFragment extends Fragment {

    private ActualizarInmuebleViewModel mViewModel;
   private TextView tvPropiedadId, tvDireccion, tvAmbientes, tvTipo, tvUso, tvPrecio, tvDisponible;
   private Inmueble i;
   private View view;
   private Button btnToggleDisponible;
   private Inmueble actualizar;


    public static PropiedadDetailFragment newInstance() {
        return new PropiedadDetailFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        try {
            mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ActualizarInmuebleViewModel.class);
            view = inflater.inflate(R.layout.propiedad_detail_fragment, container, false);
            int propiedad = (int) getArguments().getInt("propiedadId");

            mViewModel.getInm().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
                @Override
                public void onChanged(Inmueble inmueble) {
                      Inmueble  inm= new Inmueble();
                        inm.setId_Inmueble(inmueble.getId_Inmueble());
                        inm.setDireccion(inmueble.getDireccion());
                        inm.setCantAmbientes(inmueble.getCantAmbientes());
                        inm.setTipo(inmueble.getTipo());
                        inm.setPrecioInm(inmueble.getPrecioInm());
                        inm.setUso(inmueble.getUso());
                        inm.setEstadoInm(inmueble.getEstadoInm());
                        inm.setId_Propietario(propiedad);
                        i = inm;
                        fijarDatos(i);
                }
            });


            tvDireccion = view.findViewById(R.id.tvDireccion);
            tvAmbientes = view.findViewById(R.id.tvAmbientes);
            tvTipo = view.findViewById(R.id.tvTipo);
            tvUso = view.findViewById(R.id.tvUso);
            tvPrecio = view.findViewById(R.id.tvPrecio);
            tvDisponible = view.findViewById(R.id.tvDisponible);
            btnToggleDisponible = view.findViewById(R.id.btnToggleDisponible);

            mViewModel.getBajaInm().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
                @Override
                public void onChanged(Inmueble inmueble) {
                    mViewModel.bajaInmueble(inmueble.getId_Inmueble());
                }
            });

            btnToggleDisponible.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnToggleDisponible.getText()=="Guardar"){
                        actualizar();
                    }
                    else{
                        btnToggleDisponible.setText("Guardar");
                    }
                }
            });

            return view;

        } catch (Exception e) {
            Log.d("verPropiedadDetail", e.getMessage());
            Log.d("verPropiedadDetail", e.getCause().toString());
        }


        return view;


    }

    public void actualizar(){
         actualizar= new Inmueble();
        actualizar.setId_Propietario(Integer.parseInt(tvPropiedadId.getText().toString()));
        actualizar.setDireccion(tvDireccion.getText().toString());
        actualizar.setEstadoInm(Integer.parseInt(tvDisponible.getText().toString()));
        actualizar.setUso(tvUso.getText().toString());
        actualizar.setCantAmbientes(Integer.parseInt(tvAmbientes.getText().toString()));
        actualizar.setTipo(tvTipo.getText().toString());
        actualizar.setPrecioInm(Double.parseDouble(tvPrecio.getText().toString()));
        mViewModel.ActualizarInmueble(actualizar);
        btnToggleDisponible.setText("Actualizar");
    }

    public void fijarDatos(Inmueble inm){
        tvDireccion.setText(inm.getDireccion());
        tvAmbientes.setText(inm.getCantAmbientes());
        tvDisponible.setText(inm.getEstadoInm());
        tvPrecio.setText(inm.getPrecioInm()+"");
        tvTipo.setText(inm.getTipo());
        tvUso.setText(inm.getUso());
        tvPropiedadId.setText(inm.getId_Inmueble());
        btnToggleDisponible.setText("Actualizar");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel


    }

}
