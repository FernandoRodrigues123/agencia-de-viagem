package com.agenciadeviagem.dto.depoimento;

import com.agenciadeviagem.model.Depoimento;

public record DadosDetalhamentoDepoimento(

        Long id,
        String nome,
        String imagem,
        String depoimento


) {
    public DadosDetalhamentoDepoimento(Depoimento depoimento) {
        this(depoimento.getId(), depoimento.getNome(), depoimento.getImagem(), depoimento.getDepoimento());
    }
}
