package com.br.cartoes.cartoes.models;

import com.br.cartoes.cartoes.enums.TipoDeStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double numero;
    private TipoDeStatus tipoDeStatus;

    @ManyToOne
    private Cliente cliente;

    public Cartao() {}

    public Cartao(int id, double numero, String ativo, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.tipoDeStatus = tipoDeStatus;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public TipoDeStatus getTipoDeStatus() {
        return tipoDeStatus;
    }

    public void setTipoDeStatus(TipoDeStatus tipoDeStatus) {
        this.tipoDeStatus = tipoDeStatus;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
