package com.example.ControleAlmoxarifado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "requisicao_item")
public class RequisicaoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_requisicao", nullable = false)
    private Requisicao requisicao;

    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidade;


    public RequisicaoItem(Requisicao requisicao, Material material, BigDecimal quantidade) {
        this.requisicao = requisicao;
        this.material = material;
        this.quantidade = quantidade;
    }
}
