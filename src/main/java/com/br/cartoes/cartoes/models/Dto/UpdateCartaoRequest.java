package com.br.cartoes.cartoes.models.Dto;

import com.br.cartoes.cartoes.enums.TipoDeStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCartaoRequest {

    @JsonProperty("ativo")
    private TipoDeStatus tipoDeStatus;

    public TipoDeStatus getTipoDeStatus() {
        return TipoDeStatus.TRUE;
    }

    public void setTipoDeStatus(TipoDeStatus tipoDeStatus) {
        this.tipoDeStatus = TipoDeStatus.TRUE;
    }
}
