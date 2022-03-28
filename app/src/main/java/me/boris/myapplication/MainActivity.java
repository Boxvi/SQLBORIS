package me.boris.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import me.boris.myapplication.modelo.DBHelper;
import me.boris.myapplication.modelo.Persona;

public class MainActivity extends AppCompatActivity {

    Button buttonCrear;
    Button buttonEnviar;
    EditText txtIDs;
    EditText txtNombres;
    EditText txtCorreos;
    EditText txtEdads;
    EditText txtTelefonos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCrear = findViewById(R.id.btnCrear);
        buttonCrear.setOnClickListener(new View.OnClickListener() {
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
        });

        buttonEnviar = findViewById(R.id.btnEnviar);
        txtIDs = findViewById(R.id.txtID);
        txtNombres = findViewById(R.id.txtNombre);
        txtCorreos = findViewById(R.id.txtCorreo);
        txtEdads = findViewById(R.id.txtEdad);
        txtTelefonos = findViewById(R.id.txtTelefono);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona persona  = new Persona();
                persona.setId(Integer.parseInt(txtIDs.getText().toString()));
                persona.setNombres(txtNombres.getText().toString());
                persona.setCorreo(txtCorreos.getText().toString());
                persona.setEdad(Integer.parseInt(txtEdads.getText().toString()));
                persona.setTelefono(txtTelefonos.getText().toString());
                persona.guardad(MainActivity.this);

                Toast.makeText(getApplicationContext(), "Dato CReado", Toast.LENGTH_SHORT).show();
            }
        });



    }
}