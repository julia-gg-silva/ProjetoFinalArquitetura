package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.model.NotaEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaEntradaRepository extends JpaRepository<NotaEntrada, Long> {


}
