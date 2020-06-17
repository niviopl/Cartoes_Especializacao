package com.br.cartoes.cartoes.models.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateLancamentoRequest {

    private String descricao;

    private Double valor;

    @JsonProperty("cartao_id")
    private int cartaoId;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(int cartaoId) {
        this.cartaoId = cartaoId;
    }
}
