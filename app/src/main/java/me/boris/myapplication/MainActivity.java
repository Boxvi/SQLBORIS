package me.boris.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import me.boris.myapplication.adaptador.ListaPersonaAdapter;
import me.boris.myapplication.modelo.DBHelper;
import me.boris.myapplication.modelo.ModeloPersona;
import me.boris.myapplication.modelo.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Persona> personaArrayList;
    FloatingActionButton fabNuevo;
    RecyclerView listaTarjetas;
    ListaPersonaAdapter listaPersonaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaTarjetas = findViewById(R.id.listaTarjetas);
        fabNuevo = findViewById(R.id.favNuevo);
        listaTarjetas.setLayoutManager(new LinearLayoutManager(this));

        ModeloPersona modeloPersona = new ModeloPersona();
        personaArrayList = new ArrayList<>();

        listaPersonaAdapter = new ListaPersonaAdapter(modeloPersona.listarPersonas(MainActivity.this));
        listaTarjetas.setAdapter(listaPersonaAdapter);


        fabNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevoRegistro();
            }
        });


    }

    private void nuevoRegistro() {
        Intent intent = new Intent(this, ResgistroActivity.class);
        startActivity(intent);
    }
/*

        buttonEnviar = findViewById(R.id.btnEnviar);
        txtNombres = findViewById(R.id.txtNombre);
        txtCorreos = findViewById(R.id.txtCorreo);
        txtEdads = findViewById(R.id.txtEdad);
        txtTelefonos = findViewById(R.id.txtTelefono);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona persona = new Persona();
                persona.setNombres(txtNombres.getText().toString());
                persona.setCorreo(txtCorreos.getText().toString());
                persona.setEdad(Integer.parseInt(txtEdads.getText().toString()));
                persona.setTelefono(txtTelefonos.getText().toString());
                persona.guardar(MainActivity.this);

                Toast.makeText(getApplicationContext(), "Dato CReado", Toast.LENGTH_SHORT).show();
            }
        });*/


    //listaPersona = findViewById(R.id.list_item);
    // listaPersona.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    //personaArrayList = new ArrayList<>();

    //ListaPersonaAdapter listaPersonaAdapter = new ListaPersonaAdapter(personita.datos(MainActivity.this));
    //listaPersona.setAdapter(listaPersonaAdapter);


}


//buttonCrear = findViewById(R.id.btnCrear);
/*        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(getApplicationContext(), "BASE CREADA", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "BASE  NO CREADA", Toast.LENGTH_SHORT).show();
                }

            }
        });*/

/*
    Button buttonCrear;
    Button buttonEnviar;
    EditText txtIDs;
    EditText txtNombres;
    EditText txtCorreos;
    EditText txtEdads;
    EditText txtTelefonos;

    RecyclerView listaPersona;


    Persona personita = new Persona();*/