package com.agenciadeviagem.model;

import com.agenciadeviagem.dto.depoimento.DadosAtualizarDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosCadastroDepoimento;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "depoimento")
@Entity(name = "Depoimento")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Depoimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String imagem;
    private String depoimento;

    public Depoimento(DadosCadastroDepoimento dados) {
        this.nome = dados.nome();
        this.imagem = dados.imagem();
        this.depoimento = dados.depoimento();
    }

    public void atualizar(DadosAtualizarDepoimento dados) {
        this.nome = dados.nome();
        this.imagem = dados.imagem();
        this.depoimento = dados.depoimento();
    }
}
