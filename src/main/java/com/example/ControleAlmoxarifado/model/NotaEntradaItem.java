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

    @Column(nullable = false)
    private double quantidade;

    public NotaEntradaItem(NotaEntrada notaEntrada, Material material, double quantidade) {
        this.notaEntrada = notaEntrada;
        this.material = material;
        this.quantidade = quantidade;
    }
}
