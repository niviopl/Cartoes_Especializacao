package com.br.cartoes.cartoes.models;

import com.br.cartoes.cartoes.enums.TipoDeCategoria;
import com.br.cartoes.cartoes.enums.TipoDeLancamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private TipoDeLancamento tipoDeLancamento;

    private double valor;
    private Date data;

    private TipoDeCategoria tipoDeCategoria;

    private int idCartao;

    public Lancamento() {
    }

    public Lancamento(int id, TipoDeLancamento tipoDeLancamento, double valor, Date data, TipoDeCategoria tipoDeCategoria, int idCartao) {
        this.id = id;
        this.tipoDeLancamento = tipoDeLancamento;
        this.valor = valor;
        this.data = data;
        this.tipoDeCategoria = tipoDeCategoria;
        this.idCartao = idCartao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoDeLancamento getTipoDeLancamento() {
        return tipoDeLancamento;
    }

    public void setTipoDeLancamento(TipoDeLancamento tipoDeLancamento) {
        this.tipoDeLancamento = tipoDeLancamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoDeCategoria getTipoDeCategoria() {
        return tipoDeCategoria;
    }

    public void setTipoDeCategoria(TipoDeCategoria tipoDeCategoria) {
        this.tipoDeCategoria = tipoDeCategoria;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }
}
