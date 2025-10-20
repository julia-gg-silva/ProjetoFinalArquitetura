package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.conection.Conexao;
import com.example.ControleAlmoxarifado.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface MaterialDAO extends JpaRepository<Material, Long> {

}
