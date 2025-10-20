package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.model.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RequisicaoDAO extends JpaRepository<Requisicao, Long> {


}
