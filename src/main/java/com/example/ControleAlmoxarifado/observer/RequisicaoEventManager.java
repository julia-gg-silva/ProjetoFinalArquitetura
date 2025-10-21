package com.example.ControleAlmoxarifado.observer;

import com.example.ControleAlmoxarifado.model.Requisicao;

import java.util.ArrayList;
import java.util.List;

public class RequisicaoEventManager {

    private List<RequisicaoObserver> observers = new ArrayList<>();

    public void registrarObserver(RequisicaoObserver observer) {
        observers.add(observer);
    }

    public void notificar(Requisicao requisicao) {
        for (RequisicaoObserver observer : observers) {
            observer.atualizarEstoque(requisicao);
        }
    }
}
