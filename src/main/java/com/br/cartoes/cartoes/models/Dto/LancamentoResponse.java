package com.br.cartoes.cartoes.models.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LancamentoResponse {

    private int id;

    private String descricao;

    private Double valor;

    @JsonProperty("cartao_id")
    private int cartaoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
