package me.boris.myapplication.modelo;

import android.content.Context;

import java.util.ArrayList;

public class Persona {
    private int id;
    private String cedula;
    private String ciudadania= "ECUATORIANA" ;
    private String apellido;
    private String nombre;
    private String ciudad;
    private String estado = "ECUADOR";
    private String estadocivil;
    private String sexo;

    public Persona() {
    }

    public Persona(String cedula, String apellido, String nombre, String ciudad, String estadocivil, String sexo) {
        this.cedula = cedula;
        this.apellido = apellido;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadocivil = estadocivil;
        this.sexo = sexo;
    }

    public String getCiudadania() {
        return ciudadania;
    }

    public String getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCiudadania(String ciudadania) {
        this.ciudadania = ciudadania;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*

id INTEGER PRIMARY KEY AUTOINCREMENT,cedula TEXT,ciudadania TEXT,apellido TEXT,nombre TEXT, ciudad TEXT,estado TEXT, estadocivil TEXT, sexo TEXT
    private int id;
    private String nombres;
    private String telefono;
    private String correo;
    private int edad;

    public Persona() {

    }

    public void guardar(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        String nsql = "INSERT INTO personas ( nombres, telefono, correo, edad) values ('" + getNombres() + "','" + getTelefono() + "','" + getCorreo() + "','" + getEdad() + "')";
        dbHelper.noQuery(nsql);
        dbHelper.close();
    }


    public ArrayList<Persona> datos(Context context) {
        DBHelper dbHelper = new DBHelper(context);

        dbHelper.close();
        ArrayList<Persona> listaPersona = new ArrayList<>();
        Persona persona = null;

        String sql = "select * from personas";


        if (dbHelper.query(sql).moveToFirst()) {
            do {
                persona = new Persona();
                persona.setId(dbHelper.query(sql).getInt(0));
                persona.setNombres(dbHelper.query(sql).getString(2));
                persona.setCorreo(dbHelper.query(sql).getString(7));
                listaPersona.add(persona);
            } while (dbHelper.query(sql).moveToNext());
        }

        dbHelper.close();
        return listaPersona;
    }

*/
}