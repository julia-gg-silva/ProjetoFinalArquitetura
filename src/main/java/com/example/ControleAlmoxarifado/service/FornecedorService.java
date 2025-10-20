package com.example.ControleAlmoxarifado.service;

import com.example.ControleAlmoxarifado.dto.fornecedor.CriacaoFornecedorRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.fornecedor.CriacaoFornecedorRespostaDTO;
import com.example.ControleAlmoxarifado.factory.FornecedorFactory;
import com.example.ControleAlmoxarifado.mapper.FornecedorMapper;
import com.example.ControleAlmoxarifado.model.Fornecedor;
import com.example.ControleAlmoxarifado.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FornecedorService {

    private FornecedorRepository repository;
    private FornecedorMapper mapper;
    private FornecedorFactory factory;

    public FornecedorService(FornecedorRepository repository, FornecedorMapper mapper, FornecedorFactory factory) {
        this.repository = repository;
        this.mapper = mapper;
        this.factory = factory;
    }

    public CriacaoFornecedorRespostaDTO criar (
            CriacaoFornecedorRequisicaoDTO requisicaoDTO) {

        if(repository.existsAllByCnpj(requisicaoDTO.cnpj())){
            throw new RuntimeException("CNPJ já cadastrado!");
        }

        Fornecedor fornecedor = factory.criar(requisicaoDTO);

        return mapper.paraRespostaDTO(repository.save(fornecedor));
    }

    public List<CriacaoFornecedorRespostaDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(mapper::paraRespostaDTO)
                .toList();
    }

    public CriacaoFornecedorRespostaDTO buscarPorId(Long id) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Fornecedor não encontrado!");
        });

        return mapper.paraRespostaDTO(fornecedor);
    }

    public CriacaoFornecedorRespostaDTO atualizar(Long id, CriacaoFornecedorRequisicaoDTO requisicaoDTO) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Fornecedor não encontrado!");
        });

        Fornecedor newFornecedor = mapper.paraUpdate(requisicaoDTO, fornecedor);
        repository.save(newFornecedor);
        return mapper.paraRespostaDTO(newFornecedor);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
