package com.example.ControleAlmoxarifado.observer;

import com.example.ControleAlmoxarifado.model.Requisicao;

public interface RequisicaoObserver {
    void atualizarEstoque(Requisicao requisicao);
}
