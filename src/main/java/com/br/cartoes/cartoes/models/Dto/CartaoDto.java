package com.br.cartoes.cartoes.models.Dto;

public class CartaoDto {

    private double numero;
    private int idCliente;

    public CartaoDto(double numero, int idCliente) {
        this.numero = numero;
        this.idCliente = idCliente;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
