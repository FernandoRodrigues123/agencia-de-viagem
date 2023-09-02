package com.agenciadeviagem.model;

import com.agenciadeviagem.dto.depoimento.DadosAtualizarDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosCadastroDepoimento;
import com.agenciadeviagem.dto.destino.DadosAtualizarDestino;
import com.agenciadeviagem.dto.destino.DadosCadastroDestino;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "destino")
@Entity(name = "Destino")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagem;
    private String nome;
    private Double valor;

    public Destino(DadosCadastroDestino dados) {
        this.nome = dados.nome();
        this.imagem = dados.imagem();
        this.valor = dados.valor();
    }

    public void atualizar(DadosAtualizarDestino dados) {
        this.nome = dados.nome();
        this.imagem = dados.imagem();
        this.valor = dados.valor();
    }
}
