package com.agenciadeviagem.controler;

import com.agenciadeviagem.dto.depoimento.DadosAtualizarDepoimento;
import com.agenciadeviagem.dto.depoimento.DadosCadastroDepoimento;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DepoimentoControllerTest  {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void homeDeveRetornaCodigo200() throws Exception {
        var response = mvc.perform(get("/depoimentos/depoimentos-home")).andReturn().getResponse();
       assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void salvarDeveRetornaCodigo201() throws Exception {// tenho que entende de como funciona para instacia um UriComponetBuilder
        var requestData = new DadosCadastroDepoimento("nome", "ft.png", "muito bom");

        String requestJson = objectMapper.writeValueAsString(requestData);


        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/depoimentos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson));

        resultActions.andExpect(status().isCreated());
    }

    @Test
    void buscaPorIdDeveRetorna200() throws Exception {
        var response = mvc.perform(get("/depoimentos/1")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void buscarTodoDeveRetorna200() throws Exception {
        var response = mvc.perform(get("/depoimentos")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void atualizarDeveRetorna200() throws Exception {
        var requestData = new DadosAtualizarDepoimento(10L,"nome", "ft.png", "muito bom");
        String requestJson = objectMapper.writeValueAsString(requestData);

        var response = mvc.perform(put("/depoimentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void deletarDeveRetorna204() throws Exception {
        var response = mvc.perform(delete("/depoimentos/10")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }
}