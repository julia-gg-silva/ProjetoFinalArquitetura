package com.example.ControleAlmoxarifado.controller;

import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.notaEntrada.CriacaoNotaEntradaRespostaDTO;
import com.example.ControleAlmoxarifado.service.NotaEntradaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notasEntrada")
public class NotaEntradaController {

    private NotaEntradaService service;

    public NotaEntradaController(NotaEntradaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CriacaoNotaEntradaRespostaDTO> criar(@RequestBody CriacaoNotaEntradaRequisicaoDTO requisicaoDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(requisicaoDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CriacaoNotaEntradaRespostaDTO>> buscarTodos(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoNotaEntradaRespostaDTO> buscarPorId(@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoNotaEntradaRespostaDTO> atualizar(@PathVariable int id,
                                                                   @RequestBody CriacaoNotaEntradaRequisicaoDTO requisicaoDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, requisicaoDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id){
        try{
            service.excluir();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
