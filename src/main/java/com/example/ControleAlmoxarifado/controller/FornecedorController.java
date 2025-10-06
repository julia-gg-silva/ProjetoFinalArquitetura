package com.example.ControleAlmoxarifado.controller;

import com.example.ControleAlmoxarifado.dto.fornecedor.CriacaoFornecedorRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.fornecedor.CriacaoFornecedorRespostaDTO;
import com.example.ControleAlmoxarifado.service.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CriacaoFornecedorRespostaDTO> criar(
            @RequestBody CriacaoFornecedorRequisicaoDTO requisicaoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.criar(requisicaoDTO));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CriacaoFornecedorRespostaDTO>> buscarTodos() {

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoFornecedorRespostaDTO> buscarPorId(@PathVariable int id) {

        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoFornecedorRespostaDTO> atualizar(
            @PathVariable int id, @RequestBody CriacaoFornecedorRequisicaoDTO requisicaoDTO
    ){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.atualizar(id, requisicaoDTO));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){
        try{
            service.deletar(id);
            return  ResponseEntity.status(HttpStatus.OK)
                    .build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
