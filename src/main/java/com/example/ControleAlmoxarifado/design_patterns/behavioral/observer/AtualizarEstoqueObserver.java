package com.example.ControleAlmoxarifado.design_patterns.behavioral.observer;

import com.example.ControleAlmoxarifado.model.Requisicao;
import com.example.ControleAlmoxarifado.model.RequisicaoItem;
import com.example.ControleAlmoxarifado.repository.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
// classe que irá atualizar o estoque
public class AtualizarEstoqueObserver implements RequisicaoObserver{

    private MaterialRepository repository;

    @Override
    public void atualizarEstoque(Requisicao requisicao) {
        // Iterando a lista de itens de requisicao
        for(RequisicaoItem item : requisicao.getItens()){
            // verificando se a quantidade de estoque é suficiente comparado com a quantidade
            if(item.getMaterial().getEstoque().compareTo(item.getQuantidade()) < 0){
                throw new RuntimeException("Quantidade de estoque insuficiente!");
            }

            // atualizando o estoque, diminuindo o estoque pela quantidade pedida
            item.getMaterial().setEstoque(item.getMaterial().getEstoque().subtract(item.getQuantidade()));
            repository.save(item.getMaterial());
        }
    }
}
