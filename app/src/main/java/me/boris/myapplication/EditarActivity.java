package me.boris.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import me.boris.myapplication.modelo.ModeloPersona;
import me.boris.myapplication.modelo.Persona;

public class EditarActivity extends AppCompatActivity {

    EditText txtCedula, txtApellido, txtNombre, txtCiudad, txtECivil, txtSexo;
    Button btnGuarda;
    FloatingActionButton fabEditar, fabEliminar;

    boolean correcto = false;
    Persona persona;
    int id = 0;



    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txtCedula = findViewById(R.id.txtCedula);
        txtApellido = findViewById(R.id.txtApellido);
        txtNombre = findViewById(R.id.txtNombre);
        txtCiudad = findViewById(R.id.txtCiudad);
        txtECivil = findViewById(R.id.txtECivil);
        txtSexo = findViewById(R.id.txtSexo);

        btnGuarda = findViewById(R.id.btnGuarda);
        fabEditar = findViewById(R.id.fabEditar);
        fabEditar.setVisibility(View.INVISIBLE);
        fabEliminar = findViewById(R.id.fabEliminar);
        fabEliminar.setVisibility(View.INVISIBLE);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }



        final ModeloPersona modeloPersona1 = new ModeloPersona();

        persona = modeloPersona1.verPersona(EditarActivity.this, id);

        if (persona != null) {
            txtCedula.setText(persona.getCedula());
            txtApellido.setText(persona.getApellido());
            txtNombre.setText(persona.getNombre());
            txtCiudad.setText(persona.getCiudad());
            txtECivil.setText(persona.getEstadocivil());
            txtSexo.setText(persona.getSexo());
        }

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtCedula.getText().toString().equals("") && !txtApellido.getText().toString().equals("") && !txtNombre.getText().toString().equals("") &&
                        !txtCiudad.getText().toString().equals("") && !txtECivil.getText().toString().equals("") && !txtSexo.getText().toString().equals("")) {
                    System.out.println(txtNombre.getText().toString());

                   /*ModeloPersona modeloPersona = new ModeloPersona(
                            txtCedula.getText().toString(), txtApellido.getText().toString(), txtNombre.getText().toString(),
                            txtCiudad.getText().toString(), txtECivil.getText().toString(), txtSexo.getText().toString());*/

                    correcto = modeloPersona1.modificarPersona(EditarActivity.this, id,txtApellido.getText().toString(),txtNombre.getText().toString(), txtCiudad.getText().toString(), txtECivil.getText().toString(), txtSexo.getText().toString());



                    if (correcto) {
                        Toast.makeText(EditarActivity.this, "REGISTRO MODIFICACO", Toast.LENGTH_LONG).show();
                        verRegistro();

                    } else {
                        Toast.makeText(EditarActivity.this, "ERROR AL MODIFICAR EL REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(EditarActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
/*
    private void limpiar() {
        txtCedula.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        txtCiudad.setText("");
        txtECivil.setText("");
        txtSexo.setText("");
    }*/

    private void verRegistro() {
        Intent intent = new Intent(this, VerActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }

    public void RegresarLista(View view){
        Intent regresarLista = new Intent(this, MainActivity.class);
        startActivity(regresarLista);
        finish();
    }

}
