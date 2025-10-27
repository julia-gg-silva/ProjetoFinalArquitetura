package com.example.ControleAlmoxarifado.design_patterns.behavioral.observer;

import com.example.ControleAlmoxarifado.model.Requisicao;

public interface RequisicaoObserver {
    void atualizarEstoque(Requisicao requisicao);
}
