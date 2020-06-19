package com.example.moviles2020_2.ui.propiedades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Inmueble;

public class addInmuebleFragment extends Fragment {

    private Button btnAgregar;
    private EditText etDir,etAmb,etUso,etTipo,etPrecio,etEstado;
    private AddInmuebleViewModel avm;
    public static PropiedadFragment newInstance() {
        return new PropiedadFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.propiedad_fragment, container, false);
        avm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(AddInmuebleViewModel.class);

        etDir=view.findViewById(R.id.etDireccionInm);
        etAmb=view.findViewById(R.id.etCantAm);
        etUso=view.findViewById(R.id.etUsoInm);
        etTipo=view.findViewById(R.id.etTipoInm);
        etEstado=view.findViewById(R.id.etTipoInm);
        etPrecio=view.findViewById(R.id.etPrecioInm);
        btnAgregar=view.findViewById(R.id.btnGuardarin);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inmueble i= new Inmueble();
                i.setDireccion(etDir.getText().toString());
                i.setUso(etUso.getText().toString());
                i.setTipo(etTipo.getText().toString());
                i.setCantAmbientes((Integer.parseInt(etAmb.getText().toString())));
                i.setEstadoInm(Integer.parseInt(etEstado.getText().toString()));
                i.setPrecioInm(Double.parseDouble(etPrecio.getText().toString()));
                avm.altaInmueble(i);
                Navigation.findNavController(v).navigate(R.id.nav_home);
            }
        });


        return view;
    }
}
