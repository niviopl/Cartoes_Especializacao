package com.br.cartoes.cartoes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double limiteTotal;
    private Date validade;
    private int CVV;
    private double limiteAtual;
    private int idCliente;

    public Cartao() {
    }

    public Cartao(int id, double limiteTotal, Date validade, int CVV, double limiteAtual, int idCliente) {
        this.id = id;
        this.limiteTotal = limiteTotal;
        this.validade = validade;
        this.CVV = CVV;
        this.limiteAtual = limiteAtual;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setid(int numeroCartao) {
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
