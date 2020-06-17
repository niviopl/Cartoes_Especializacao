package com.br.cartoes.cartoes.models.Dto;

public class CartaoDto {

    private String numero;
    private int idCliente;

    public CartaoDto(String numero, int idCliente) {
        this.numero = numero;
        this.idCliente = idCliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
