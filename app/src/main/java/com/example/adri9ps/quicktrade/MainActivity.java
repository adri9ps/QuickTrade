package com.example.adri9ps.quicktrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button miPerfil, misProductos, todosUsuarios, todosProductos, cerrarSesion, fav;
    FirebaseUser user;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miPerfil = (Button) findViewById(R.id.btnMiPerfil);
        misProductos = (Button) findViewById(R.id.btnMisProductos);
        todosUsuarios = (Button) findViewById(R.id.btnUsuarios);
        todosProductos = (Button) findViewById(R.id.btnProductos);
        cerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);
        fav = (Button) findViewById(R.id.btnFav);

        user = FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
        if (user != null) {

            //txt.setText(getString(R.string.hola) + " " + user.getDisplayName());
        } else {
            //si no esta Logueado, llevale a que inicie sesión
            startActivity(new Intent(this, InicioSesion.class));
            finish();
        }


        miPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aMiPerfil = new Intent(getApplicationContext(), EditarPerfil.class);
                startActivity(aMiPerfil);
            }
        });

        misProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aMisProductos = new Intent(getApplicationContext(), NuevoProducto.class);
                startActivity(aMisProductos);

            }
        });

        todosUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity = new Intent(getApplicationContext(), TodosUsuarios.class);
                startActivity(activity);

            }
        });

        todosProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aTodosProductos = new Intent(getApplicationContext(), TodosProductos.class);
                startActivity(aTodosProductos);

            }
        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aFav = new Intent(getApplicationContext(), ProductosFavoritos.class);
                startActivity(aFav);

            }
        });

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent main = new Intent(MainActivity.this, InicioSesion.class);
                startActivity(main);
                finish();

            }
        });
    }
}


