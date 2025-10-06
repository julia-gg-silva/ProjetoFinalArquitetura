package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.conection.Conexao;
import com.example.ControleAlmoxarifado.model.Material;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MaterialDAO {
    public Material criar(Material material) throws SQLException {
        String query = "INSERT INTO Material (nome, unidade, estoque) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, material.getNome());
            stmt.setString(2, material.getUnidade());
            stmt.setDouble(3, material.getEstoque());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                material.setId(rs.getInt(1));
            }
        }

        return material;
    }

    public List<Material> buscarTodos() throws SQLException{
        List<Material> materiais = new ArrayList<>();
        String query = "SELECT id, nome, unidade, estoque FROM Material";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String unidade = rs.getString("unidade");
                double estoque = rs.getDouble("estoque");

                materiais.add(new Material(id, nome, unidade, estoque));
            }
        }

        return materiais;
    }

    public Material buscarPorId(int id) throws SQLException{
        String query = "SELECT id, nome, unidade, estoque FROM Material WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int newId = rs.getInt("id");
                String nome = rs.getString("nome");
                String unidade = rs.getString("unidade");
                double estoque = rs.getDouble("estoque");

                return new Material(id, nome, unidade, estoque);
            }
        }

        return null;
    }

    public void atualizar(int id, Material material) throws SQLException{
        String query = "UPDATE Material SET nome = ?, unidade = ?, estoque = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, material.getNome());
            stmt.setString(2, material.getUnidade());
            stmt.setDouble(3, material.getEstoque());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException{
        String query = "DELETE FROM Material WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    public boolean nomeExiste(String nome) throws SQLException{
        String query = "SELECT id FROM Material WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return true;
            }
        }

        return false;
    }
}
