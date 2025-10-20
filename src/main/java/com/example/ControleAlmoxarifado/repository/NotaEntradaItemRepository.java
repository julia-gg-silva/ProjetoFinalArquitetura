package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.model.NotaEntradaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaEntradaItemRepository extends JpaRepository<NotaEntradaItem, Long> {
}
