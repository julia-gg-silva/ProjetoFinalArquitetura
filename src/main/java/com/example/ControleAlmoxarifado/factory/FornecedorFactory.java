package com.example.ControleAlmoxarifado.factory;

import com.example.ControleAlmoxarifado.dto.fornecedor.CriacaoFornecedorRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRequisicaoDTO;
import com.example.ControleAlmoxarifado.mapper.FornecedorMapper;
import com.example.ControleAlmoxarifado.model.Fornecedor;

public class FornecedorFactory implements EntityFactory<Fornecedor, CriacaoFornecedorRequisicaoDTO>{
    private final FornecedorMapper mapper;

    public FornecedorFactory(FornecedorMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Fornecedor criar(CriacaoFornecedorRequisicaoDTO dto) {
        return mapper.paraEntidade(dto);
    }
}
