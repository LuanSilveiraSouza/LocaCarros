package com.example.locacarros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {

    EditText edtCpf;
    EditText edtNome;
    EditText edtIdade;
    EditText edtGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        edtCpf = findViewById(R.id.edtCpf);
        edtNome = findViewById(R.id.edtNome);
        edtIdade = findViewById(R.id.edtIdade);
        edtGenero = findViewById(R.id.edtGenero);
    }

    public void addClient(View v) {
        String cpf = edtCpf.getText().toString();
        String nome = edtNome.getText().toString();
        int idade = Integer.parseInt(edtIdade.getText().toString());
        String genero = edtGenero.getText().toString();

        String msg;

        try {
            AppDatabase db;
            db = AppDatabase.getConnection(AddUserActivity.this);

            db.Dao().insert(new User(cpf, nome, idade, genero));

            msg = "Cliente criado com sucesso";
        } catch (Exception e) {
            msg = "Cliente não foi criado, tente novamente";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        edtCpf.setText("");
        edtNome.setText("");
        edtIdade.setText("");
        edtGenero.setText("");
    }
}
