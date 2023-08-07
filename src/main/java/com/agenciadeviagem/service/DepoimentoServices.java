package com.agenciadeviagem.service;


import com.agenciadeviagem.dto.depoimento.DadosAtualizarDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosDetalhamentoDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosLeituraDepoimento;
import com.agenciadeviagem.model.Depoimento;
import com.agenciadeviagem.repository.DepoimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DepoimentoServices {

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @Transactional
    public Depoimento salvar(Depoimento depoimento){
        depoimentoRepository.save(depoimento);
        return depoimento;
    }

    public DadosDetalhamentoDepoimento buscaPorId(Long id){
        Depoimento depoimento = depoimentoRepository.getReferenceById(id);
        return new DadosDetalhamentoDepoimento(depoimento);
    }

    public List<DadosLeituraDepoimento> buscaTodos(){
        List<Depoimento> depoimentos = depoimentoRepository.findAll();
        return depoimentos.stream().map(DadosLeituraDepoimento::new).toList();
    }

    @Transactional
    public DadosDetalhamentoDepoimento atualizar(DadosAtualizarDepoimento dados){
        Depoimento depoimento = depoimentoRepository.getReferenceById(dados.id());
        depoimento.atualizar(dados);
        depoimentoRepository.save(depoimento);

        return new DadosDetalhamentoDepoimento(depoimento);
    }

    public void deletar(Long id){
      depoimentoRepository.deleteById(id);
    }


    public List<DadosLeituraDepoimento> buscatrezDepoimentoAleatoriamente(int quantidade) {
        List<Depoimento> todasEntidades = depoimentoRepository.findAll();
        int totalEntidades = todasEntidades.size();

        List<Depoimento> depoimentosAleatorios = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < quantidade; i++) {
            int randomIndex = random.nextInt(totalEntidades);
            depoimentosAleatorios.add(todasEntidades.get(randomIndex));
        }

        return depoimentosAleatorios.stream().map(DadosLeituraDepoimento::new).toList();

    }
}










