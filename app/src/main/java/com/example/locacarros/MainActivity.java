package com.example.locacarros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickAddCar(View v) {
        Intent i = new Intent(this, AddCarActivity.class);
        startActivity(i);
    }
    public void clickAddUser(View v) {
        Intent i = new Intent(this, AddUserActivity.class);
        startActivity(i);
    }
    public void clickAluga(View v) {
        Intent i = new Intent(this, AlugaActivity.class);
        startActivity(i);
    }
    public void clickCarStatus(View v) {
        Intent i = new Intent(this, CarStatusActivity.class);
        startActivity(i);
    }
    public void clickUserStatus(View v) {
        Intent i = new Intent(this, UserStatusActivity.class);
        startActivity(i);
    }
}
