package com.example.locacarros;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = false)
    @NonNull private String cpf;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "idade")
    private int idade;

    @ColumnInfo(name = "genero")
    private String genero;

    @ColumnInfo(name = "conta")
    private float conta;

    public User(String cpf, String nome, int idade, String genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.conta = 0;
    }

    @Override
    public String toString() {
        return cpf +" / "+ nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public float getConta() {
        return conta;
    }

    public void setConta(float conta) {
        this.conta = conta;
    }
}
