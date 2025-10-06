package com.example.ControleAlmoxarifado.factory;

public interface EntityFactory <T, R>{
    T criar(R dto);
}
