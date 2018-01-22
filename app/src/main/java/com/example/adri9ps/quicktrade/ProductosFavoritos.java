package com.example.adri9ps.quicktrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adri9ps.quicktrade.model.Producto;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProductosFavoritos extends AppCompatActivity {

    ListView lvFav,lvTotal;
    EditText nombreProductoFavorito;
    Button favorito;
    DatabaseReference bbddP;
    ArrayAdapter<String> adapterFavoritos;
    ArrayAdapter<String> adapterFavoritosTotal;
    ArrayList<String> listadoProductosFavoritos = new ArrayList<String>();
    ArrayList<String> listadoProductosFavoritosTotal = new ArrayList<String>();
    private FirebaseAuth fba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_favoritos);

        lvFav = (ListView) findViewById(R.id.listViewFavoritos);
        lvTotal = (ListView) findViewById(R.id.listViewTotal);
        nombreProductoFavorito = (EditText) findViewById(R.id.editTextProdFav);
        favorito = (Button) findViewById(R.id.btnEnviarAFavorito);
        bbddP = FirebaseDatabase.getInstance().getReference("Productos");



        favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarProductosFavoritos();

            }
        });



    }

    public void cargarProductosFavoritos() {
        if (!nombreProductoFavorito.getText().toString().isEmpty()) {

            Query q = bbddP.orderByChild("nombre").equalTo(nombreProductoFavorito.getText().toString());

            q.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    //Obtenemos nombres de productos
                    for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                        Producto prod = datasnapshot.getValue(Producto.class);
                        String nombreProductoFavorito = prod.getNombre();

                        listadoProductosFavoritos.add(nombreProductoFavorito);
                        adapterFavoritos = new ArrayAdapter<String>(ProductosFavoritos.this, android.R.layout.simple_list_item_1, listadoProductosFavoritos);
                        lvFav.setAdapter(adapterFavoritos);
                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        } else {
            Toast.makeText(ProductosFavoritos.this, "Introduce un nombre", Toast.LENGTH_LONG).show();


        }
    }

    public void cargarListView(){
        if(!listadoProductosFavoritos.isEmpty()){
            lvFav.setAdapter(adapterFavoritos);
        }
    }
}
