package com.example.ControleAlmoxarifado.observer;

import com.example.ControleAlmoxarifado.model.Requisicao;
import com.example.ControleAlmoxarifado.model.RequisicaoItem;
import com.example.ControleAlmoxarifado.repository.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class AtualizarEstoqueObserver implements RequisicaoObserver{

    private MaterialRepository repository;

    @Override
    public void atualizarEstoque(Requisicao requisicao) {
        for(RequisicaoItem item : requisicao.getItens()){
            if(item.getMaterial().getEstoque().compareTo(item.getQuantidade()) < 0){
                throw new RuntimeException("Quantidade de estoque insuficiente!");
            }

            item.getMaterial().setEstoque(item.getMaterial().getEstoque().subtract(item.getQuantidade()));
            repository.save(item.getMaterial());
        }
    }
}
