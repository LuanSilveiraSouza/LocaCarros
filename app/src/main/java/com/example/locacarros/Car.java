package com.example.locacarros;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Car {

    @PrimaryKey(autoGenerate = false)
    @NonNull private String placa;

    @ColumnInfo(name = "marca")
    private String marca;

    @ColumnInfo(name = "modelo")
    private String modelo;

    @ColumnInfo(name = "ano")
    private int ano;

    @ColumnInfo(name = "cor")
    private String cor;

    @ColumnInfo(name = "diaria")
    private float diaria;

    @ColumnInfo(name = "cpfUser")
    private String cpfUser;

    @ColumnInfo(name = "dataInicial")
    private String dataInicial;

    @ColumnInfo(name = "dataFinal")
    private String dataFinal;


    public void setUser(String cpfUser, String dataInicial, String dataFinal) {
        this.cpfUser = cpfUser;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public void deleteUser() {
        this.cpfUser = "";
        this.dataInicial = "";
        this.dataFinal = "";
    }

    public Car(String placa, String marca, String modelo, int ano, String cor, float diaria) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.diaria = diaria;

        deleteUser();
    }

    @Override
    public String toString() {
        return placa +" / "+ modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getDiaria() {
        return diaria;
    }

    public void setDiaria(float diaria) {
        this.diaria = diaria;
    }

    public void setCpfUser(String cpfUser) {
        this.cpfUser = cpfUser;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCpfUser() {
        return cpfUser;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }
}
