package com.br.cartoes.cartoes.models;

import javax.persistence.*;
import java.util.Date;
import org.hibernate.ObjectNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {

    @Id
    @Column(name = "numeroCartao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String cpf;

    //@DateTimeFormat (pattern = "dd/MM/yyyyy")
    private Date dataNascimento;


    private String email;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, Date dataNascimento, String email) throws ObjectNotFoundException {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
