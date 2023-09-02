package com.agenciadeviagem.dto.destino;

import com.agenciadeviagem.model.Destino;

public record DadosLeituraDestino(

        String nome,

        String imagem,

        Double valor
) {
    public DadosLeituraDestino(Destino destino) {
        this( destino.getNome(), destino.getImagem(), destino.getValor());

    }
}
