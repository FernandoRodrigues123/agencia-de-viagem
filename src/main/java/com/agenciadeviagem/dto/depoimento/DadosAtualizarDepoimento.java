package com.agenciadeviagem.dto.depoimento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDepoimento(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String imagem,
        @NotBlank
        String depoimento
) {
}
