package com.agenciadeviagem.service;


import com.agenciadeviagem.dto.depoimento.DadosAtualizarDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosDetalhamentoDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosLeituraDepoimento;
import com.agenciadeviagem.dto.destino.DadosAtualizarDestino;
import com.agenciadeviagem.dto.destino.DadosLeituraDestino;
import com.agenciadeviagem.dto.destino.DadosDetalhamentoDestino;
import com.agenciadeviagem.model.Depoimento;
import com.agenciadeviagem.model.Destino;
import com.agenciadeviagem.repository.DestinoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DestinoServices {

    @Autowired
    private DestinoRepository destinoRepository;


    @Transactional
    public Destino salvar(Destino destino){
        destinoRepository.save(destino);
        return destino;
    }

    public DadosDetalhamentoDestino buscaPorId(Long id){
        Destino destino = destinoRepository.getReferenceById(id);
        return new DadosDetalhamentoDestino(destino);
    }

    public List<DadosLeituraDestino> buscaTodos(){
        List<Destino> destino = destinoRepository.findAll();
        return destino.stream().map(DadosLeituraDestino::new).toList();
    }

    @Transactional
    public DadosDetalhamentoDestino atualizar(DadosAtualizarDestino dados){
        Destino destino = destinoRepository.getReferenceById(dados.id());
        destino.atualizar(dados);
        destinoRepository.save(destino);

        return new DadosDetalhamentoDestino(destino);
    }

    public void deletar(Long id){
      destinoRepository.deleteById(id);
    }



}










