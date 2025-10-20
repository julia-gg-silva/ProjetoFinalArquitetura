package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.model.RequisicaoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisicaoItemRepository extends JpaRepository<RequisicaoItem, Long> {
    List<RequisicaoItem> findByRequisicao(Long requisicao);


}
