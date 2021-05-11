package com.andriosi.fabio.metadesafio.entity;

import com.andriosi.fabio.metadesafio.controller.Cpf;
import com.andriosi.fabio.metadesafio.controller.Email;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Cliente {
    private static final long serialVersionUID = 894561237L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "O nome do Cliente não pode ser nulo!")
    private String nome;
    @Email
    private String email;
    @Cpf
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    private String naturalidade;
    private String nacionalidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
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
