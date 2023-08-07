package com.agenciadeviagem.dto.depoimento;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDepoimento(
        @NotBlank
        String nome,
        @NotBlank
        String imagem,
        @NotBlank
        String depoimento
) {
}
