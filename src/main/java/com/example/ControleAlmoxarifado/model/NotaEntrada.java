package com.example.ControleAlmoxarifado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "nota_entrada")
public class NotaEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @Column(nullable = false)
    private LocalDate dataEntrega;

    @OneToMany(mappedBy = "notaEntrada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotaEntradaItem> itens;

    public NotaEntrada(Fornecedor fornecedor, LocalDate dataEntrega) {
        this.fornecedor = fornecedor;
        this.dataEntrega = dataEntrega;
    }
}
