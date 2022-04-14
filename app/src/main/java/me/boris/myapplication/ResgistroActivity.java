package me.boris.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import me.boris.myapplication.modelo.ModeloPersona;

public class ResgistroActivity extends AppCompatActivity {

    EditText txtCedula, txtApellido, txtNombre, txtCiudad, txtECivil, txtSexo;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);

        txtCedula = findViewById(R.id.txtCedula);
        txtApellido = findViewById(R.id.txtApellido);
        txtNombre = findViewById(R.id.txtNombre);
        txtCiudad = findViewById(R.id.txtCiudad);
        txtECivil = findViewById(R.id.txtECivil);
        txtSexo = findViewById(R.id.txtSexo);

        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtCedula.getText().toString().equals("") && !txtApellido.getText().toString().equals("") && !txtNombre.getText().toString().equals("") &&
                        !txtCiudad.getText().toString().equals("") && !txtECivil.getText().toString().equals("") && !txtSexo.getText().toString().equals("")) {
                    ModeloPersona modeloPersona = new ModeloPersona(
                            txtCedula.getText().toString(),txtApellido.getText().toString(),txtNombre.getText().toString(),
                            txtCiudad.getText().toString(),txtECivil.getText().toString(),txtSexo.getText().toString());


                    modeloPersona.crearPersona(ResgistroActivity.this);
                    Toast.makeText(ResgistroActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(ResgistroActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar() {
        txtCedula.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        txtCiudad.setText("");
        txtECivil.setText("");
        txtSexo.setText("");
    }

    public void RegresarLista(View view){
        Intent regresarLista = new Intent(this, MainActivity.class);
        startActivity(regresarLista);
        finish();
    }
}