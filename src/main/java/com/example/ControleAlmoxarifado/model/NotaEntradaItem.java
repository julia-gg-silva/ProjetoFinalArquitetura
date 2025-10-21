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
@Table(name = "nota_entrada_item")
public class NotaEntradaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_nota_entrada", nullable = false)
    private NotaEntrada notaEntrada;

    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidade;

    public NotaEntradaItem(NotaEntrada notaEntrada, Material material, BigDecimal quantidade) {
        this.notaEntrada = notaEntrada;
        this.material = material;
        this.quantidade = quantidade;
    }
}
