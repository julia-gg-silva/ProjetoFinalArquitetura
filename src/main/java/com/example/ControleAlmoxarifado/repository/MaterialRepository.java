package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    boolean getByNome(String nome);

}
