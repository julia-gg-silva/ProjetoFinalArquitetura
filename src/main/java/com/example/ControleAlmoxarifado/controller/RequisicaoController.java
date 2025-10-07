package com.example.ControleAlmoxarifado.controller;

import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.requisicao.CriacaoRequisicaoRespostaDTO;
import com.example.ControleAlmoxarifado.service.RequisicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requisicoes")
public class RequisicaoController {

    private RequisicaoService service;

    public RequisicaoController(RequisicaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CriacaoRequisicaoRespostaDTO> criar(
            @RequestBody CriacaoRequisicaoRequisicaoDTO requisicaoDTO) {

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
    public ResponseEntity<List<CriacaoRequisicaoRespostaDTO>> buscarTodos() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarTodos());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoRequisicaoRespostaDTO> buscarId(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.buscarPorId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoRequisicaoRespostaDTO> atualizar(
            @PathVariable int id, @RequestBody CriacaoRequisicaoRequisicaoDTO requisicaoDTO
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.atualizar(id, requisicaoDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {

        try {
            service.deletar(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
