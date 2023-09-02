package com.agenciadeviagem.dto.destino;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDestino(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String imagem,
        @NotBlank
        Double valor
) {
}
