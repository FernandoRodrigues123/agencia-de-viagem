package com.agenciadeviagem.dto.destino;

import com.agenciadeviagem.model.Depoimento;
import com.agenciadeviagem.model.Destino;

public record DadosDetalhamentoDestino(

        Long id,
        String nome,
        String imagem,
        Double valor


) {
    public DadosDetalhamentoDestino(Destino destino) {
        this(destino.getId(), destino.getNome(), destino.getImagem(), destino.getValor());
    }
}