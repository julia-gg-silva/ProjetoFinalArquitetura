package com.example.ControleAlmoxarifado.model;

import java.time.LocalDate;

public class NotaEntrada {

    private int id;
    private int idFornecedor;
    private LocalDate dataEntrega;

    public NotaEntrada(int id, int idFornecedor, LocalDate dataEntrega) {
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.dataEntrega = dataEntrega;
    }

    public NotaEntrada(int idFornecedor, LocalDate dataEntrega) {
        this.idFornecedor = idFornecedor;
        this.dataEntrega = dataEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
