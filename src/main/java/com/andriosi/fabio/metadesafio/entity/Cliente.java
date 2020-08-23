package com.andriosi.fabio.metadesafio.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;

@Entity
public class Cliente {
    private static final long serialVersionUID = 894561237L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nome;
    private String email;
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Calendar dataNacimento;
    private String naturalidade;
    private String nacionalidade;
    @Transient
    private String strDataNacimento;

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

    public String getStrDataNacimento() {
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        this.strDataNacimento = format1.format(this.dataNacimento.getTime());
        return strDataNacimento;
    }

    public void setStrDataNacimento(String strDataNacimento) {
        this.strDataNacimento = strDataNacimento;
    }
}
