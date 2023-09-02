package com.agenciadeviagem.dto.depoimento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroDepoimento(
        @NotBlank
        String nome,
        @NotBlank
        String imagem,
        @NotBlank
        String depoimento
) {
    public DadosCadastroDepoimento(String nome, String imagem, String depoimento) {
        this.nome = nome;
        this.depoimento = depoimento;
        this.imagem = imagem;
    }
}
