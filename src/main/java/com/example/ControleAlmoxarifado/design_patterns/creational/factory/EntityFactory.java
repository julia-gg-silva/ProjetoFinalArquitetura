package com.example.ControleAlmoxarifado.design_patterns.creational.factory;

// interface da factory que recebe um tipo genérico
public interface EntityFactory <T, R>{
    T criar(R dto);
}
