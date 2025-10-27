package com.example.ControleAlmoxarifado.design_patterns.creational.factory;

import com.example.ControleAlmoxarifado.model.dto.fornecedor.CriacaoFornecedorRequisicaoDTO;
import com.example.ControleAlmoxarifado.model.mapper.FornecedorMapper;
import com.example.ControleAlmoxarifado.model.Fornecedor;
import org.springframework.stereotype.Component;

@Component
public class FornecedorFactory implements EntityFactory<Fornecedor, CriacaoFornecedorRequisicaoDTO>{
    private final FornecedorMapper mapper;

    // recebe o mapper para converter o fornecedor para entidade
    public FornecedorFactory(FornecedorMapper mapper) {
        this.mapper = mapper;
    }

    // irá criar a entidade
    @Override
    public Fornecedor criar(CriacaoFornecedorRequisicaoDTO dto) {
        return mapper.paraEntidade(dto);
    }
}
