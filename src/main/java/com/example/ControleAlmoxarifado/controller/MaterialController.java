package com.example.ControleAlmoxarifado.controller;

import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRequisicaoDTO;
import com.example.ControleAlmoxarifado.dto.material.CriacaoMaterialRespostaDTO;
import com.example.ControleAlmoxarifado.service.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

    private MaterialService service;

    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CriacaoMaterialRespostaDTO> criar(@RequestBody CriacaoMaterialRequisicaoDTO requisicaoDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(requisicaoDTO));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CriacaoMaterialRespostaDTO>> buscarTodos(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoMaterialRespostaDTO> buscarPorId(@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoMaterialRespostaDTO> atualizar(@PathVariable int id,
                                                                @RequestBody CriacaoMaterialRequisicaoDTO requisicaoDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, requisicaoDTO));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping ("/{id}")
    ResponseEntity<Void> excluir(@PathVariable int id){
        try{
            service.excluir(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
