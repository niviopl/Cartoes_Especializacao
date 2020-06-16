package com.br.cartoes.cartoes.models;

import javax.persistence.*;
import java.util.Date;
import org.hibernate.ObjectNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {

    @Id
    //@Column(name = "numeroCartao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;


    public Cliente() {
    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

 }
