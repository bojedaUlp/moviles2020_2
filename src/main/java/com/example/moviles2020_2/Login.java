package com.example.moviles2020_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviles2020_2.model.GeneralData;
import com.example.moviles2020_2.model.Usuario;

public class Login extends AppCompatActivity {
   private EditText etMail, etPass;
   private Button btnIngresar;
   private TextView tvError;
   private LoginViewModel loginVM;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciarVista();
        loginVM.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
        });
        loginVM.getExitoso().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void iniciarVista(){

        loginVM= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);
        etMail = findViewById(R.id.etMail);
        etPass = findViewById(R.id.etPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        tvError =findViewById(R.id.tvError);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginVM.ingresar(etMail.getText().toString(),etPass.getText().toString());
            }
        });




    }

}


