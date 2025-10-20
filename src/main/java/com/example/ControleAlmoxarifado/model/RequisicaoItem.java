package com.example.ControleAlmoxarifado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "requisicao-item")
public class RequisicaoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_requisicao", nullable = false)
    private Long idRequisicao;

    @Column(name = "id_material", nullable = false)
    private Long idMaterial;

    @Column(nullable = false, precision = 10, scale = 2)
    private double quantidade;


    public RequisicaoItem(Long idRequisicao, Long idMaterial, double quantidade) {
        this.idRequisicao = idRequisicao;
        this.idMaterial = idMaterial;
        this.quantidade = quantidade;
    }
}
