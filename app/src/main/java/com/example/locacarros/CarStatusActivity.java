package com.example.locacarros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class CarStatusActivity extends AppCompatActivity {

    TextView txt;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_status);

        txt = findViewById(R.id.txt);
        title = findViewById(R.id.title);

        title.setText("Placa \t|\t Marca \t|\t Modelo \t|\t Ano \t|\t Cor \t|\t Diaria");

        String s = "";

        AppDatabase db = AppDatabase.getConnection(CarStatusActivity.this);
        List<Car> cars = db.Dao().getAllCar();

        for(Car c : cars) {
            s += c.getPlaca() + " \t|\t " + c.getMarca() + " \t|\t " + c.getModelo() + " \t|\t " + c.getAno() + " \t|\t " +
                    c.getCor() + " \t|\t " + c.getDiaria() + " \t|\t " + c.getCpfUser() + " \t|\t " + c.getDataInicial() + " \t|\t " + c.getDataFinal() +"\n \n";
        }
        /*
        for (int i = 0; i < cars.size(); i++ ) {
            s += cars.get(i).getPlaca();
        }*/

        txt.setText(s);

    }
}
