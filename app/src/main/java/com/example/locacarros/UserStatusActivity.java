package com.example.locacarros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class UserStatusActivity extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_status);

        txt = findViewById(R.id.txt);

        String s = "";
        s += "CPF \t|\t Nome \t|\t Idade \t|\t Genero \t|\t Conta";

        AppDatabase db = AppDatabase.getConnection(UserStatusActivity.this);
        List<User> users = db.Dao().getAllUser();

        for(User u : users) {
            s += "\n \n" + u.getCpf() + " \t|\t " + u.getNome() + " \t|\t " + u.getIdade() + " \t|\t " + u.getGenero() + " \t|\t " + u.getConta();
        }
        /*
        for (int i = 0; i < users.size(); i++ ) {
            s += users.get(i).getCpf();
        }*/

        txt.setText(s);
    }
}
