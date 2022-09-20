package com.example.jpssql1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jpssql1.Entidades.SqliteUtil;

import Utilidades.UtilJPS;

public class ConsultarUsuario extends AppCompatActivity {
    EditText edtIdUsuario;
    TextView txtNombre, txtTelefono;
    Button btnBuscar;
    SqliteUtil conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);

        edtIdUsuario= findViewById(R.id.edtIdUsuario);
        txtNombre= findViewById(R.id.txtNombre);
        txtTelefono= findViewById(R.id.txtTelefono);
        btnBuscar= findViewById(R.id.btnBuscar);
        conexion= new SqliteUtil(this, UtilJPS.BASE_DATOS, null,1);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarUsuario();
            }
        });


    }

    private void consultarUsuario() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        //no mesclar SQL con logica de negocio
        String[] parametros={edtIdUsuario.getText().toString()};
        String[] lista_de_campos={UtilJPS.CAMPO_ID,UtilJPS.CAMPO_NOMBRE,UtilJPS.CAMPO_TELEFONO};
        //captura en caso de error
        try {
            Cursor cursor=db.query(UtilJPS.TABLA_USUARIO,lista_de_campos,UtilJPS.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            txtNombre.setText(cursor.getString(1));
            txtTelefono.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(this, "Error al buscar Id USUARIO"+edtIdUsuario.getText().toString(), Toast.LENGTH_SHORT).show();
        }

    }
}