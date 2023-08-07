package com.agenciadeviagem.controler;

import com.agenciadeviagem.dto.depoimento.DadosAtualizarDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosCadastroDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosDetalhamentoDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosLeituraDepoimento;
import com.agenciadeviagem.model.Depoimento;
import com.agenciadeviagem.service.DepoimentoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentoController {

    @Autowired
    private DepoimentoServices depoimentoServices;


    @GetMapping("/depoimentos-home")
    public ResponseEntity<List<DadosLeituraDepoimento>> home(){
        return ResponseEntity.ok(depoimentoServices.buscatrezDepoimentoAleatoriamente(3));
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody @Valid DadosCadastroDepoimento dados, UriComponentsBuilder uriBuilder){
        Depoimento depoimento = depoimentoServices.salvar(new Depoimento(dados));
        URI uri = uriBuilder.path("/depoimento/{id}").buildAndExpand(depoimento.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoDepoimento(depoimento));
    }
    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable Long id){

        return ResponseEntity.ok(depoimentoServices.buscaPorId(id));
    }
    @GetMapping
    public ResponseEntity<List<DadosLeituraDepoimento>> buscarTodos(){
        return ResponseEntity.ok(depoimentoServices.buscaTodos());
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarDepoimento dados){
        return ResponseEntity.ok(depoimentoServices.atualizar(dados));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        depoimentoServices.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
