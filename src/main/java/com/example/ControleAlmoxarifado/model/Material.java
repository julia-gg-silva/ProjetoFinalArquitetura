package com.example.ControleAlmoxarifado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String unidade;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal estoque;

    @OneToMany(mappedBy = "material")
    private List<NotaEntradaItem> itensNotaEntrada;


    public Material(String nome, String unidade, BigDecimal estoque) {
        this.nome = nome;
        this.unidade = unidade;
        this.estoque = estoque;
    }
}
