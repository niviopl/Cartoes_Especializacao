package com.br.cartoes.cartoes.models.Dto;

import com.br.cartoes.cartoes.enums.TipoDeStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCartaoResponse {

    private int id;

    private String numero;

    private int clienteId;

    @JsonProperty("ativo")
    private TipoDeStatus tipoDeStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public TipoDeStatus gettipoDeStatus() {
        return tipoDeStatus;
    }

    public void setTipoDeStatus(TipoDeStatus tipoDeStatus) {
        this.tipoDeStatus = tipoDeStatus;
    }
}
