package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.model.RequisicaoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoItemDAO extends JpaRepository<RequisicaoItem, Long> {


}
