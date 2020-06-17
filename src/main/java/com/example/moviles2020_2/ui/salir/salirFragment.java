package com.example.moviles2020_2.ui.salir;

import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviles2020_2.R;

public class salirFragment extends Fragment {

View view;

    public static salirFragment newInstance() {
        return new salirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.salir_fragment, container, false);

        notificacion();
        return view;

    }



    private void notificacion() {
        new AlertDialog.Builder(getContext() , R.style.AlertDialog)
                .setTitle("Salir")
                .setMessage("¿Desea salir de la aplicación?")

                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Navigation.findNavController(view).navigate(R.id.nav_home, null);
            }
        }).show();
    }


}
