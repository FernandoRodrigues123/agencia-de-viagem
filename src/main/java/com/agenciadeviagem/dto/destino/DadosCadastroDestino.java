package com.agenciadeviagem.dto.destino;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDestino(
        @NotBlank
        String nome,
        @NotBlank
        String imagem,
        @NotBlank
        Double valor
) {
    public DadosCadastroDestino(String nome, String imagem, Double valor) {
        this.nome = nome;
        this.valor  = valor;
        this.imagem = imagem;
    }
}
