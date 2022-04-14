package me.boris.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import me.boris.myapplication.modelo.ModeloPersona;
import me.boris.myapplication.modelo.Persona;

public class VerActivity extends AppCompatActivity {

    EditText txtCedula, txtApellido, txtNombre, txtCiudad, txtECivil, txtSexo;
    Button btnGuarda, btnRegresar;
    FloatingActionButton fabEditar, fabEliminar;

    Persona persona;
    int id = 0;

    ModeloPersona modeloPersona;

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

        fabEditar = findViewById(R.id.fabEditar);
        fabEliminar = findViewById(R.id.fabEliminar);
        btnGuarda = findViewById(R.id.btnGuarda);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setVisibility(View.INVISIBLE);
        btnGuarda.setVisibility(View.INVISIBLE);

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

        modeloPersona = new ModeloPersona();

        persona = modeloPersona.verPersona(VerActivity.this, id);

        if (persona != null) {
            txtCedula.setText(persona.getCedula());
            txtApellido.setText(persona.getApellido());
            txtNombre.setText(persona.getNombre());
            txtCiudad.setText(persona.getCiudad());
            txtECivil.setText(persona.getEstadocivil());
            txtSexo.setText(persona.getSexo());

            txtCedula.setInputType(InputType.TYPE_NULL);
            txtApellido.setInputType(InputType.TYPE_NULL);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtCiudad.setInputType(InputType.TYPE_NULL);
            txtECivil.setInputType(InputType.TYPE_NULL);
            txtSexo.setInputType(InputType.TYPE_NULL);
        }

        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerActivity.this, EditarActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VerActivity.this);
                builder.setMessage("¿Desea eliminar este contacto?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (modeloPersona.eliminarPersona(VerActivity.this, id)) {
                            lista();
                        }
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
            }
        });
    }

    private void lista() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void RegresarLista(View view) {
        Intent regresarLista = new Intent(this, MainActivity.class);
        startActivity(regresarLista);
        finish();
    }
}