package com.example.moviles2020_2.ui.perfil;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moviles2020_2.LoginViewModel;
import com.example.moviles2020_2.MainActivity;
import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Propietario;
import com.example.moviles2020_2.model.Usuario;

import java.util.IllegalFormatCodePointException;
import java.util.concurrent.ExecutionException;

public class PerfilFragment extends Fragment {

    private PerfilViewModel mViewModel;
    EditText etdni, etapellido, etnombre, etTelefono, etMail, etPass,etDir;
    Button btnToggleEditar;
    private int estado = 0;
    private Propietario p;

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.perfil_fragment, container, false);
        etdni = view.findViewById(R.id.etPFDNI);
        etapellido = view.findViewById(R.id.etPFApellido);
        etnombre = view.findViewById(R.id.etPFNombre);
        etTelefono = view.findViewById(R.id.etPFTelefono);
        etMail = view.findViewById(R.id.etPFMail);
        etPass = view.findViewById(R.id.etPFPass);
        etDir = view.findViewById(R.id.etIFDDireccion);
        btnToggleEditar = view.findViewById(R.id.btnToggleEditar);

        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);
        mViewModel.getPropietario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                p=new Propietario(propietario.getId_Propietario(),propietario.getNombreP(),propietario.getApellidoP(),propietario.getDniP(),propietario.getDireccionP(),propietario.getTelefonoP(),propietario.getEmail(),propietario.getPassword());
                fijarDato(p);
            }
        });
        mViewModel.getOperacion().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                p = new Propietario();
            }
        });
        mViewModel.traerDatosPropietario();

        btnToggleEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnToggleEditar.getText()=="Editar"){
                    new AlertDialog.Builder(getContext()).setTitle("").setMessage("Desea confirmar cambios").setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            estadoDos();
                            p.setNombreP(etnombre.getText().toString());
                            p.setApellidoP(etapellido.getText().toString());
                            p.setDniP(etdni.getText().toString());
                            p.setDireccionP(etDir.getText().toString());
                            p.setTelefonoP(etTelefono.getText().toString());
                            p.setId_Propietario(p.getId_Propietario());
                            p.setEmail(etMail.getText().toString());
                            p.setPassword(etPass.getText().toString());
                            mViewModel.actualizarDatosPropietario(p);
                            Intent i = new Intent(getContext(), MainActivity.class);
                            getContext().startActivity(i);
                        }
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            fijarDato(p);
                        }
                    }).show();
                }
                else{estadoUno();}
            }
        });

        return view;
    }

    public void fijarDato(Propietario prop)
    {
        etnombre.setText(prop.getNombreP());
        etapellido.setText(prop.getApellidoP());
        etdni.setText(prop.getDniP());
        etDir.setText(prop.getDireccionP());
        etTelefono.setText(prop.getTelefonoP());
        etMail.setText(prop.getEmail());
        etPass.setText(prop.getPassword());
        estadoUno();
    }

    public void estadoUno() {
        etdni.setEnabled(false);
        etapellido.setEnabled(false);
        etnombre.setEnabled(false);
        etTelefono.setEnabled(false);
        etMail.setEnabled(false);
        etPass.setEnabled(false);
        etapellido.setEnabled(false);
        etDir.setEnabled(false);
        btnToggleEditar.setText("Editar");
        estado = 1;
    }

    public void estadoDos(){
        etdni.setEnabled(true);
        etapellido.setEnabled(true);
        etnombre.setEnabled(true);
        etTelefono.setEnabled(true);
        etMail.setEnabled(true);
        etPass.setEnabled(true);
        etapellido.setEnabled(true);
        etDir.setEnabled(true);
        btnToggleEditar.setText("Actualizar");
        estado = 2;
    }

}
