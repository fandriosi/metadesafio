package com.andriosi.fabio.metadesafio.testes;

import com.andriosi.fabio.metadesafio.entity.Cliente;
import com.andriosi.fabio.metadesafio.repository.ClienteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteRepositoryTest {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    private ClienteRepository clienteRepository;
    @Test
    public void ClinteTestA(){
        Cliente clinte = new Cliente();
        clinte.setNome("Pedro da Silva");
        Calendar cal = Calendar.getInstance();
        cal.set(1978,3,21);
        clinte.setDataNascimento(cal);
        clinte.setNacionalidade("Brasileira");
        clinte.setNaturalidade("São Paulo");
        clinte.setEmail("test.test@teste.com");
        clinte.setCpf("54647142949");
        clienteRepository.save(clinte);
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        assertEquals("Pedro da Silva", clientes.get(0).getNome());
        assertEquals("21/04/1978", format.format(clientes.get(0).getDataNascimento().getTime()));
        assertEquals("Brasileira", clientes.get(0).getNacionalidade());
        assertEquals("São Paulo", clientes.get(0).getNaturalidade());
        assertEquals("test.test@teste.com", clientes.get(0).getEmail());
        assertEquals("54647142949", clientes.get(0).getCpf());
        Cliente cliente = clientes.get(0);
        cliente.setNome("João de Paula");
        cliente.setNaturalidade("Pernambuco");
        clienteRepository.save(cliente);
        Optional<Cliente> clienteUpdate = clienteRepository.findById(cliente.getId());
        assertEquals("João de Paula", clienteUpdate.get().getNome());
        assertEquals("Pernambuco", clienteUpdate.get().getNaturalidade());
    }

}