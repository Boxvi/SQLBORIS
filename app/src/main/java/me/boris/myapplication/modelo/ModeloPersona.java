package me.boris.myapplication.modelo;

import android.content.Context;
import android.database.Cursor;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ModeloPersona extends Persona {


    public ModeloPersona() {
    }

    public ModeloPersona(String cedula, String apellido, String nombre, String ciudad, String estadocivil, String sexo) {
        super(cedula, apellido, nombre, ciudad, estadocivil, sexo);
    }

    public void crearPersona(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        String nsql = "insert into personas(cedula,ciudadania,apellido,nombre,ciudad,estado,estadocivil,sexo) values ('" + getCedula() + "','" + getCiudadania()
                + "','" + getApellido() + "','" + getNombre() + "','" + getCiudad() + "','" + getEstado() + "','" + getEstadocivil() + "','" + getSexo() + "')";
        dbHelper.noQuery(nsql);
        dbHelper.close();
    }

    public ArrayList<Persona> listarPersonas(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        String sql = "select * from personas";

        System.out.println(" "+sql);

        Cursor cursor = dbHelper.query(sql);

        ArrayList<Persona> personaArrayList = new ArrayList<>();
        while (cursor.moveToNext()) {
            Persona persona = new Persona();
            persona.setId(cursor.getInt(0));
            persona.setCedula(cursor.getString(1));
            persona.setCiudadania(cursor.getString(2));
            persona.setApellido(cursor.getString(3));
            persona.setNombre(cursor.getString(4));
            persona.setCiudad(cursor.getString(5));
            persona.setEstado(cursor.getString(6));
            persona.setEstadocivil(cursor.getString(7));
            persona.setSexo(cursor.getString(8));
            personaArrayList.add(persona);
        }
        dbHelper.close();
        return personaArrayList;
    }

    public Persona verPersona(Context context, int id) {
        DBHelper dbHelper = new DBHelper(context);
        String sql = "select * from personas where id = '" + id + "'";

        Persona persona = null;

        Cursor cursor = dbHelper.query(sql);

        if (cursor.moveToFirst()) {
            persona = new Persona();
            persona.setId(cursor.getInt(0));
            persona.setCedula(cursor.getString(1));
            persona.setCiudadania(cursor.getString(2));
            persona.setApellido(cursor.getString(3));
            persona.setNombre(cursor.getString(4));
            persona.setCiudad(cursor.getString(5));
            persona.setEstado(cursor.getString(6));
            persona.setEstadocivil(cursor.getString(7));
            persona.setSexo(cursor.getString(8));
        }
        dbHelper.close();
        return persona;
    }

    public boolean modificarPersona(Context context, int id, String apellido, String nombre, String ciudad, String estadocivil, String sexo) {
        boolean correcto = false;
        DBHelper dbHelper = new DBHelper(context);
        String nsql = "UPDATE personas set apellido = '" + apellido + "',nombre = '" + nombre + "',ciudad = '" + ciudad + "',estadocivil = '" + estadocivil + "',sexo = '" + sexo + "' where id='" + id + "' ";
        try {
            dbHelper.noQuery(nsql);
            correcto = true;
        } catch (Exception exception) {
            exception.toString();
            correcto = false;
        }
        dbHelper.close();
        return correcto;
    }

    public boolean modificarPersona(Context context, int id) {
        boolean correcto = false;
        DBHelper dbHelper = new DBHelper(context);
        String nsql = "UPDATE personas set ciudadania = '" + getCiudadania() + "',apellido = '" + getApellido() +
                "',nombre = '" + getNombre() + "',ciudad = '" + getCiudad() + "',estadocivil = '" + getEstadocivil() + "',sexo = '" + getSexo() + "' where id='" + id + "' ";
        try {
            dbHelper.noQuery(nsql);
            correcto = true;
        } catch (Exception exception) {
            exception.toString();
            correcto = false;
        }
        dbHelper.close();
        return correcto;
    }

    public boolean eliminarPersona(Context context, int id) {
        boolean correcto = false;
        DBHelper dbHelper = new DBHelper(context);
        String nsql = "delete from personas where id='" + id + "'";

        try {
            dbHelper.noQuery(nsql);
            correcto = true;
        } catch (Exception exception) {
            exception.toString();
            correcto = false;
        }
        dbHelper.close();
        return correcto;
    }

}
/*
if (cursor.moveToFirst()){do{}while (cursor.moveToNext());}
 */