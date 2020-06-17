package com.example.moviles2020_2.ui.contrato;

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

public class ContratoDetailFragment extends Fragment {

    private ContratoViewModel mViewModel;
    TextView etCFDPrecio, etCFDInicio, etCFDFin;

    public static ContratoDetailFragment newInstance() {
        return new ContratoDetailFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contrato_detail_fragment, container, false);
        try {
        mViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoViewModel.class);
        int id = (int) getArguments().getInt("id");

        // aca voy a hardcodear para evitar que me devuelva inexistente
        mViewModel.obtenerContrato(1);


            etCFDPrecio = view.findViewById(R.id.etCFDPrecio);
            etCFDInicio = view.findViewById(R.id.etCFDInicio);
            etCFDFin = view.findViewById(R.id.etCFDFin);

            final Observer<Contrato> contratoObserver = new Observer<Contrato>() {
                @Override
                public void onChanged(Contrato contrato) {
                    try{
                        etCFDPrecio.setText(contrato.getPrecio()+"");
                        etCFDInicio.setText(contrato.getInicio()+"");
                        etCFDFin.setText(contrato.getFin()+"");
                    }catch (Exception e){
                        Log.d("verContratoFDetail", e.getMessage());
                    }
                }
            };

            mViewModel.getContrato().observe(getViewLifecycleOwner(), contratoObserver);
        }catch (Exception e){
            Log.d("verContratoFDetail", e.getMessage());
        }

        return view;
    }



}
