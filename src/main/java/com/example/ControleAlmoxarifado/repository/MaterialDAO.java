package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.conection.Conexao;
import com.example.ControleAlmoxarifado.model.Material;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class MaterialDAO {
    public Material criar(Material material) throws SQLException {
        String query = "INSERT INTO Material (nome, unidade, estoque) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

        }
    }

    public List<Material> buscarTodos() throws SQLException{

    }

    public Material buscarPorId(int id) throws SQLException{

    }

    public void atualizar(int id, Material material) throws SQLException{

    }

    public void excluir(int id) throws SQLException{

    }


    public boolean nomeExiste(String nome) throws SQLException{

    }
}
