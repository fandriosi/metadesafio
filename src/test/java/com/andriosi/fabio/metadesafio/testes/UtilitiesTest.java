package com.andriosi.fabio.metadesafio.testes;

import com.andriosi.fabio.metadesafio.util.StrJson;
import com.andriosi.fabio.metadesafio.util.Utilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {

    @Test
    public void getJson() {
        StrJson strJson = new StrJson();
        strJson.setId(12L);
        strJson.setNome("Pedro dos Santos");
        String json = new Utilities().getJson(strJson);
        assertEquals("{\"id\":12,\"nome\":\"Pedro dos Santos\"}",json);
    }

    @Test
    public void iscpf() {
        String cpf ="54647142949";
        assertEquals(true, new Utilities().isCpf(cpf));
    }

    @Test
    public void imprimeCPF() {
        String cpf ="54647142949";
        assertEquals("546.471.429-49", new Utilities().imprimeCPF(cpf));
    }
    @Test
    public void isMail(){
        String email = "teste.test@test.com";
        assertEquals(true, new Utilities().isMail(email));
    }
}