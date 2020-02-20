package com.example.locacarros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCarActivity extends AppCompatActivity {

    EditText edtPlaca;
    EditText edtMarca;
    EditText edtModelo;
    EditText edtAno;
    EditText edtCor;
    EditText edtDiaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        edtPlaca = findViewById(R.id.edtPlaca);
        edtMarca = findViewById(R.id.edtMarca);
        edtModelo = findViewById(R.id.edtModelo);
        edtAno = findViewById(R.id.edtAno);
        edtCor = findViewById(R.id.edtCor);
        edtDiaria = findViewById(R.id.edtDiaria);
    }

    public void addCar(View v) {
        String placa = edtPlaca.getText().toString();
        String marca = edtMarca.getText().toString();
        String modelo = edtModelo.getText().toString();
        int ano = Integer.parseInt(edtAno.getText().toString());
        String cor = edtCor.getText().toString();
        float diaria = Float.parseFloat(edtDiaria.getText().toString());

        String msg;

        try {
            AppDatabase db;
            db = AppDatabase.getConnection(AddCarActivity.this);

            db.Dao().insert(new Car(placa, marca, modelo, ano, cor, diaria));

            msg = "Carro inserido com sucesso";
        } catch (Exception e) {
            msg = "Carro não foi inserido, tente novamente";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        edtPlaca.setText("");
        edtMarca.setText("");
        edtModelo.setText("");
        edtAno.setText("");
        edtCor.setText("");
        edtDiaria.setText("");

    }
}
