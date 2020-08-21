package com.andriosi.fabio.metadesafio.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Cliente {
    private static final long serialVersionUID = 894561237L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
    private String email;
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Calendar dataNacimento;
    private String naturalidade;
    private String nacionalidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(Calendar dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
