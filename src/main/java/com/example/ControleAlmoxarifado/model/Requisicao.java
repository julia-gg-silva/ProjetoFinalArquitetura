package com.example.ControleAlmoxarifado.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "requisicao")
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String setor;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "data_solicitacao")
    private LocalDate dataSolicitacao;

    @Column(nullable = false)
    private String status;

    public Requisicao(String setor, LocalDate dataSolicitacao, String status) {
        this.setor = setor;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

}
