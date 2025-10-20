package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.model.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {



}
