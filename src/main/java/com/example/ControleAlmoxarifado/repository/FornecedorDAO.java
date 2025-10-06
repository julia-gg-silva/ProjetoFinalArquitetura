package com.example.ControleAlmoxarifado.repository;

import com.example.ControleAlmoxarifado.conection.Conexao;
import com.example.ControleAlmoxarifado.model.Fornecedor;
import com.example.ControleAlmoxarifado.model.Material;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FornecedorDAO {

    public Fornecedor criar(Fornecedor fornecedor) throws SQLException {

        String query = "INSERT INTO Fornecedor(nome, cnpj) VALUES (?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                fornecedor.setId(rs.getInt(1));
            }
        }
        return fornecedor;
    }

    public List<Fornecedor> buscarTodos() throws SQLException{
        String query = "SELECT id, nome, cnpj FROM Fornecedor";
        List<Fornecedor> fornecedores = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome  = rs.getString("nome");
                String cnpj  = rs.getString("cnpj");

                Fornecedor fornecedor = new Fornecedor(id, nome, cnpj);
                fornecedores.add(fornecedor);
            }
        }
        return fornecedores;
    }

    public Fornecedor buscarPorId(int id) throws SQLException{
        String query = "SELECT id, nome, cnpj FROM Fornecedor WHERE id = ?";
        Fornecedor fornecedor = null;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int newId = rs.getInt("id");
                String nome  = rs.getString("nome");
                String cnpj  = rs.getString("cnpj");

                fornecedor = new Fornecedor(newId, nome, cnpj);
            }

        }
        return fornecedor;
    }

    public void atualizar(int id,Fornecedor fornecedor) throws SQLException{
        String query = "UPDATE Fornecedor SET nome =?, cnpj=? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setInt(3, id);
            stmt.executeUpdate();

        }
    }

    public void deletar(int id) throws SQLException{
        String query = "DELETE FROM Fornecedor WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public boolean nomeExiste(String nome) throws SQLException{
        String query = "SELECT id FROM Fornecedor WHERE nome = ?";

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
