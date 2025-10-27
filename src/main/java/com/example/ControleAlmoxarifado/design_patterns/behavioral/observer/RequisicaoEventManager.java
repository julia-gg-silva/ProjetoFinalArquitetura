package com.example.ControleAlmoxarifado.design_patterns.behavioral.observer;

import com.example.ControleAlmoxarifado.model.Requisicao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
