package com.example.ControleAlmoxarifado.design_patterns.behavioral.observer;

import com.example.ControleAlmoxarifado.model.Requisicao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequisicaoEventManager {

    // possue a lista de observers
    private List<RequisicaoObserver> observers = new ArrayList<>();

    // adiciona o observador na lista
    public void registrarObserver(RequisicaoObserver observer) {
        observers.add(observer);
    }

    // quando receber uma requisicao ele irá atualizar o estoque de todos os observadores
    public void notificar(Requisicao requisicao) {
        for (RequisicaoObserver observer : observers) {
            observer.atualizarEstoque(requisicao);
        }
    }
}
