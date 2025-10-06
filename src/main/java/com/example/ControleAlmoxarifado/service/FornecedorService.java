package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.dto.fornecedor.CriacaoFornecedorRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.fornecedor.CriacaoFornecedorRespostaDTO;
import com.example.ControleAlmoxarifado.factory.FornecedorFactory;
import com.example.ControleAlmoxarifado.mapper.FornecedorMapper;
import com.example.ControleAlmoxarifado.model.Fornecedor;
import com.example.ControleAlmoxarifado.repository.FornecedorDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FornecedorService {

    private FornecedorDAO repository;
    private FornecedorMapper mapper;
    private FornecedorFactory factory;

    public FornecedorService(FornecedorDAO repository, FornecedorMapper mapper, FornecedorFactory factory) {
        this.repository = repository;
        this.mapper = mapper;
        this.factory = factory;
    }

    public CriacaoFornecedorRespostaDTO criar (
            CriacaoFornecedorRequisicaoDTO requisicaoDTO) throws SQLException {

        if(repository.nomeExiste(requisicaoDTO.nome())){
            throw new RuntimeException("Nome do fornecedor já existe!");
        }

        if(requisicaoDTO.nome() == null){
            throw new RuntimeException("Nome do fornecedor é obrigatório!");
        }

        if(requisicaoDTO.cnpj() == null){
            throw new RuntimeException("Cnpj do fornecedor é obrigatório!");
        }

        Fornecedor fornecedor = factory.criar(requisicaoDTO);

        return mapper.paraRespostaDTO(repository.criar(fornecedor));
    }

    public List<CriacaoFornecedorRespostaDTO> buscarTodos() throws SQLException{
        return repository.buscarTodos().stream()
                .map(mapper::paraRespostaDTO)
                .toList();
    }

    public CriacaoFornecedorRespostaDTO buscarPorId(int id) throws SQLException{
        Fornecedor fornecedor = repository.buscarPorId(id);

        if(fornecedor == null){
            throw new RuntimeException("Fornecedor não existe!");
        }

        return mapper.paraRespostaDTO(fornecedor);
    }

    public CriacaoFornecedorRespostaDTO atualizar(int id, CriacaoFornecedorRequisicaoDTO requisicaoDTO) throws SQLException{
        Fornecedor fornecedor = repository.buscarPorId(id);

        if(fornecedor == null){
            throw new RuntimeException("Fornecedor não existe!");
        }

        Fornecedor newFornecedor = mapper.paraUpdate(requisicaoDTO, fornecedor);
        repository.atualizar(id,newFornecedor);
        return mapper.paraRespostaDTO(newFornecedor);
    }

    public void deletar(int id) throws SQLException{
        Fornecedor fornecedor = repository.buscarPorId(id);

        if(fornecedor == null){
            throw new RuntimeException("Fornecedor não existe!");
        }

        repository.deletar(id);
    }
}
