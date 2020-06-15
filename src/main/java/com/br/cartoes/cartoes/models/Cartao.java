package com.br.cartoes.cartoes.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double limiteTotal;
    private Date validade;
    private int CVV;
    private double limiteAtual;
    //private int idCliente;
    @ManyToOne
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cartao() {
    }

    public Cartao(long id, double limiteTotal, Date validade, int CVV, double limiteAtual, Cliente cliente) {
        this.id = id;
        this.limiteTotal = limiteTotal;
        this.validade = validade;
        this.CVV = CVV;
        this.limiteAtual = limiteAtual;
        //this.idCliente = idCliente;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setid(long numeroCartao) {
        this.id = id;
    }

    public double getLimiteTotal() {
        return limiteTotal;
    }

    public void setLimiteTotal(double limiteTotal) {
        this.limiteTotal = limiteTotal;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public double getLimiteAtual() {
        return limiteAtual;
    }

    public void setLimiteAtual(double limiteAtual) {
        this.limiteAtual = limiteAtual;
    }

    //public int getIdCliente() {
        //return idCliente;
    //}

    //public void setIdCliente(int idCliente) {
        //this.idCliente = idCliente;
    //}
}
