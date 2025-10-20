package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    boolean existsAllByCnpj(String cnpj);
}
