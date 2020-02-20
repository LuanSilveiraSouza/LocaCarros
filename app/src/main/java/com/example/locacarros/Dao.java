package com.example.locacarros;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(Car car);

    @Insert
    void insert(User user);

    @Delete
    void delete(Car car);

    @Delete
    void delete(User user);

    @Update
    void update(User user);

    @Update
    void update(Car car);

    @Query("SELECT * FROM car")
    List<Car> getAllCar();

    @Query("SELECT * FROM user")
    List<User> getAllUser();

    @Query("SELECT * FROM car WHERE placa = :placa")
    public Car getCar(String placa);

    @Query("SELECT * FROM user WHERE cpf = :cpf")
    public User getUser(String cpf);

}
