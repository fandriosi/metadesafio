package com.andriosi.fabio.metadesafio.testes;

import com.andriosi.fabio.metadesafio.entity.Cliente;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Calendar;

public class ClienteTest {
    private Cliente cliente;

    public ClienteTest() {
        this.cliente = new Cliente();
    }

    @Test
    public void getNome() {
        cliente.setNome("Pedro da Silva");
        assertEquals("Pedro da Silva",cliente.getNome());

    }

    @Test
    public void getEmail() {
        cliente.setEmail("test.test@test.com.br");
        assertEquals("test.test@test.com.br", cliente.getEmail());
    }

    @Test
    public void getCpf() {
        cliente.setCpf("12345678900");
        assertEquals("12345678900", cliente.getCpf());
    }

    @Test
    public void getDataNacimento() {
        Calendar cal = Calendar.getInstance();
        cal.set(1978,2,13);
        cliente.setDataNascimento(cal);
        assertEquals("13/03/1978",cliente.getStrDataNascimento());
    }

    @Test
    public void getNaturalidade() {
        cliente.setNaturalidade("São Paulo");
        assertEquals("São Paulo", cliente.getNaturalidade());
    }
    @Test
    public void getNacionalidade() {
        cliente.setNacionalidade("Brasileira");
        assertEquals("Brasileira", cliente.getNacionalidade());
    }
}