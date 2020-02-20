package com.example.locacarros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlugaActivity extends AppCompatActivity {

    Spinner spCar;
    Spinner spUser;

    EditText inicialDate;
    EditText finalDate;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluga);

        db = AppDatabase.getConnection(AlugaActivity.this);

        spCar = findViewById(R.id.spinnerCar);
        List<Car> cars = db.Dao().getAllCar();
        ArrayAdapter<Car> adCar = new ArrayAdapter<Car>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, cars);
        adCar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCar.setAdapter(adCar);

        spUser = findViewById(R.id.spinnerUser);
        List<User> users = db.Dao().getAllUser();
        ArrayAdapter<User> adUser = new ArrayAdapter<User>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, users);
        adUser.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUser.setAdapter(adUser);

        inicialDate = findViewById(R.id.inicialDate);
        finalDate = findViewById(R.id.finalDate);

    }

    public void aluga(View v) throws ParseException {
        db = AppDatabase.getConnection(AlugaActivity.this);

        String cpf[] = spUser.getSelectedItem().toString().split(" ");
        String placa[] = spCar.getSelectedItem().toString().split(" ");

        String msg;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");

        Date datainicial = sdf.parse(inicialDate.getText().toString());
        Date datafinal = sdf.parse(finalDate.getText().toString());

        long dias = datafinal.getTime() - datainicial.getTime();
        dias /= (24 * 60 * 60 * 1000);

        try{
            Car selected = db.Dao().getCar(placa[0]);
            User user = db.Dao().getUser(cpf[0]);
            float conta = 0;

            if(selected.getCpfUser().isEmpty()) {
                selected.setUser(cpf[0], inicialDate.getText().toString(), finalDate.getText().toString());
                db.Dao().update(selected);

                conta += selected.getDiaria() * dias;

                if(!user.getGenero().equals("masculino")) {
                    conta *= 0.8;
                }
                if(user.getIdade() >= 60) {
                    conta *= 0.8;
                }
                conta += user.getConta();
                user.setConta(conta);
                db.Dao().update(user);

                msg = "Carro alugado com sucesso";
            } else {
                msg = "Carro ja esta sendo alugado";
            }

        } catch(Exception e){
            msg = "Ocorreu um erro na hora de alugar o carro";
        }

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
