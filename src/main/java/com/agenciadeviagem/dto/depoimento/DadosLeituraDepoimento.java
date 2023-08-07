package com.agenciadeviagem.dto.depoimento;

import com.agenciadeviagem.model.Depoimento;
import jakarta.validation.constraints.NotBlank;

public record DadosLeituraDepoimento(

        String nome,

        String imagem,

        String depoimento
) {
    public DadosLeituraDepoimento(Depoimento depoimento) {
        this( depoimento.getNome(), depoimento.getImagem(), depoimento.getDepoimento());
    }
}
