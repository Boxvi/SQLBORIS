package me.boris.myapplication.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "personas.db";
    private static final int DATABASE_VERSION = 4;
    private static final String TABLA_PERSONAS = "personas";



    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLA_PERSONAS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT,cedula TEXT,ciudadania TEXT,apellido TEXT,nombre TEXT, ciudad TEXT,estado TEXT, estadocivil TEXT, sexo TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqld = "DROP TABLE " + TABLA_PERSONAS;
        sqLiteDatabase.execSQL(sqld);
        onCreate(sqLiteDatabase);
    }

    public void noQuery(String nsql) {
        this.getWritableDatabase().execSQL(nsql);
    }

    public Cursor query(String sql) {
        return this.getReadableDatabase().rawQuery(sql, null);
    }
}
