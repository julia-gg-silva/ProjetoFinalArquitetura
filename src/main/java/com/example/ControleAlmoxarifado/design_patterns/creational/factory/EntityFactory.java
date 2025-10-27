package com.example.ControleAlmoxarifado.design_patterns.creational.factory;

public interface EntityFactory <T, R>{
    T criar(R dto);
}
