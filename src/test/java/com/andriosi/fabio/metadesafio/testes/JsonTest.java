package com.andriosi.fabio.metadesafio.testes;

import com.andriosi.fabio.metadesafio.entity.Cliente;
import com.andriosi.fabio.metadesafio.util.Json;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    @Test
    void getJson() {
        Cliente cliente = new Cliente();
        cliente.setNome("Pedro dos Santos");
        cliente.setNaturalidade("Pernambuco");
        Calendar cal = Calendar.getInstance();
        cal.set(1879, 2, 23);
        String json = new Json().getJson(cliente);
        System.out.println(json);
       // assertEquals("{nome: Pedro dos Santos,naturalidade: Pernambuco}", json);
    }
}