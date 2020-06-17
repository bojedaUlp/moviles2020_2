package com.example.moviles2020_2.ui.inquilinos;

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
import android.widget.EditText;
import android.widget.TextView;

import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Contrato;
import com.example.moviles2020_2.model.Inquilino;
import com.example.moviles2020_2.ui.contrato.ContratoViewModel;

public class InquilinoDetailFragment extends Fragment {

    private InquilinoViewModel mViewModel;
    private TextView etIFDDni, etIFDApellido, etIFDNombre, etIFDDireccion, etIFDTelefono;

    public static InquilinoDetailFragment newInstance() {
        return new InquilinoDetailFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inquilino_detail_fragment, container, false);

        try {
            mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoViewModel.class);
            int id = (int) getArguments().getInt("id");

            // aca voy a hardcodear para evitar que me devuelva inexistente
            mViewModel.obtenerInquilino(1);


            etIFDDni = view.findViewById(R.id.etIFDDni);
            etIFDApellido = view.findViewById(R.id.etIFDApellido);
            etIFDNombre = view.findViewById(R.id.etIFDNombre);
            etIFDDireccion = view.findViewById(R.id.etIFDDireccion);
            etIFDTelefono = view.findViewById(R.id.etIFDTelefono);
            final Observer<Inquilino> inquilinoObserver = new Observer<Inquilino>() {
                @Override
                public void onChanged(Inquilino i) {

                    etIFDDni.setText(i.getDni()+"");
                    etIFDApellido.setText(i.getApellido()+"");
                    etIFDNombre.setText(i.getNombre()+"");
                    etIFDDireccion.setText(i.getDireccion()+"");
                    etIFDTelefono.setText(i.getTelefono()+"");
                }
            };

            mViewModel.getInquilino().observe(getViewLifecycleOwner(), inquilinoObserver);
        } catch (Exception e) {
            Log.d("verContratoFDetail", e.getMessage());
        }


        return view;
    }


}
