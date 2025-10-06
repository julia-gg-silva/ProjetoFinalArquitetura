package com.example.ControleAlmoxarifado.mapper;

import com.example.ControleAlmoxarifado.dto.fornecedor.CriacaoFornecedorRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.fornecedor.CriacaoFornecedorRespostaDTO;
import com.example.ControleAlmoxarifado.model.Fornecedor;
import org.springframework.stereotype.Component;

@Component
public class FornecedorMapper {

    public Fornecedor paraEntidade(CriacaoFornecedorRequisicaoDTO requisicaoDTO){
        return new Fornecedor(requisicaoDTO.nome(), requisicaoDTO.cnpj());
    }

    public CriacaoFornecedorRespostaDTO paraRespostaDTO(Fornecedor fornecedor){
        return new CriacaoFornecedorRespostaDTO(fornecedor.getId(), fornecedor.getNome(), fornecedor.getCnpj());
    }

    public Fornecedor paraUpdate(CriacaoFornecedorRequisicaoDTO requisicaoDTO, Fornecedor fornecedor) {
        if (fornecedor.getNome() != requisicaoDTO.nome() && requisicaoDTO.nome() != null) {
            fornecedor.setNome(requisicaoDTO.nome());
        }
        if (fornecedor.getCnpj() != requisicaoDTO.cnpj() && requisicaoDTO.cnpj() != null) {
            fornecedor.setCnpj(requisicaoDTO.cnpj());
        }
        return fornecedor;
    }
}
