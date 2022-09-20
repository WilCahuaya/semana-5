package com.example.jpssql1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jpssql1.Entidades.SqliteUtil;

import Utilidades.UtilJPS;

public class InsertarUsuario extends AppCompatActivity {
EditText edtId, edtNombre, edtPhone;
Button btnRegUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_usuario);
        edtId = findViewById(R.id.edtIdUsuario);
        edtNombre = findViewById(R.id.edtNombreUsuario);
        edtPhone = findViewById(R.id.edtPhoneUser);
        btnRegUs = findViewById(R.id.btnRegistrarUsuario);
        btnRegUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regUsuario();
            }
        });

    }
    public void regUsuario(){
        SqliteUtil conexion = new SqliteUtil(this,"bd_usuario",null,1 );
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(UtilJPS.CAMPO_ID, edtId.getText().toString());
        valores.put(UtilJPS.CAMPO_NOMBRE, edtNombre.getText().toString());
        valores.put(UtilJPS.CAMPO_TELEFONO, edtPhone.getText().toString());
        Long resultado = db.insert(UtilJPS.TABLA_USUARIO,null,valores);
        Toast.makeText(this, "Registro completo", Toast.LENGTH_SHORT).show();
        db.close();
    }
}