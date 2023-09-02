package com.agenciadeviagem.controler;

import com.agenciadeviagem.dto.depoimento.DadosAtualizarDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosDetalhamentoDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosLeituraDepoimento;
import com.agenciadeviagem.dto.destino.DadosAtualizarDestino;
import com.agenciadeviagem.dto.destino.DadosCadastroDestino;
import com.agenciadeviagem.dto.destino.DadosDetalhamentoDestino;
import com.agenciadeviagem.dto.destino.DadosLeituraDestino;
import com.agenciadeviagem.model.Depoimento;
import com.agenciadeviagem.model.Destino;
import com.agenciadeviagem.service.DestinoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoServices destinoServices;

    @PostMapping
    public ResponseEntity salvar(@RequestBody @Valid DadosCadastroDestino dados, UriComponentsBuilder uriBuilder){
        Destino destino = destinoServices.salvar(new Destino(dados));
        URI uri = uriBuilder.path("/destino/{id}").buildAndExpand(destino.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoDestino(destino));
    }
    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable Long id){

        return ResponseEntity.ok(destinoServices.buscaPorId(id));
    }
    @GetMapping
    public ResponseEntity<List<DadosLeituraDestino>> buscarTodos(){
        return ResponseEntity.ok(destinoServices.buscaTodos());
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarDestino dados){
        return ResponseEntity.ok(destinoServices.atualizar(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        destinoServices.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
