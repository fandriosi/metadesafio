package com.andriosi.fabio.metadesafio.testes;

import com.andriosi.fabio.metadesafio.entity.Cliente;
import com.andriosi.fabio.metadesafio.repository.ClienteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private ClienteRepository clienteRepository;
    @Test
    public void ClinteTestA(){
        Cliente clinte = new Cliente();
        clinte.setNome("Pedro da Silva");
        Calendar cal = Calendar.getInstance();
        cal.set(1978,3,21);
        clinte.setDataNacimento(cal);
        clinte.setNacionalidade("Brasileira");
        clinte.setNaturalidade("São Paulo");
        clinte.setEmail("test.test@teste.com");
        clinte.setCpf("7839393939");
        testEntityManager.persist(clinte);
    }

}