package com.andriosi.fabio.metadesafio.testes;

import com.andriosi.fabio.metadesafio.entity.Cliente;
import com.andriosi.fabio.metadesafio.repository.ClienteRepository;
import com.andriosi.fabio.metadesafio.util.Utilities;
import org.apache.tomcat.util.http.parser.Authorization;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.websocket.RemoteEndpoint;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import java.util.Calendar;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteControllerTest {
    private Cliente cliente;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ClienteRepository repository;

    public ClienteControllerTest() {
        this.cliente = new Cliente();
        this.cliente.setCpf("54647142949");
        this.cliente.setEmail("test.test@test.com");
        this.cliente.setNacionalidade("Brasileira");
        this.cliente.setNaturalidade("Pernambuco");
        this.cliente.setNome("Joaquim Barbosa");
        Calendar cal = Calendar.getInstance();
        cal.set(1979,2,23);
        this.cliente.setDataNascimento(cal);
    }
    @Test
    public void testControllerA() throws Exception{
        Cliente c = this.cliente;
        c.setCpf("854048580");
        String json = new Utilities().getJson(c);
        mockMvc.perform(MockMvcRequestBuilders.post("/resources/cliente")
                .header(HttpHeaders.AUTHORIZATION, "Basic QWRtaW46YWRtaW4=")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testControllerB() throws Exception{
        Cliente c = this.cliente;
        c.setEmail("fdkasldfsad.dladlkj.dadl");
        String json = new Utilities().getJson(c);
        mockMvc.perform(MockMvcRequestBuilders.post("/resources/cliente")
                .header(HttpHeaders.AUTHORIZATION, "Basic QWRtaW46YWRtaW4=")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testControllerC() throws Exception{
        String json = new Utilities().getJson(this.cliente);
        mockMvc.perform(MockMvcRequestBuilders.post("/resources/cliente")
                .header(HttpHeaders.AUTHORIZATION, "Basic QWRtaW46YWRtaW4=")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nome", is("Joaquim Barbosa")));
    }
    @Test
    public void testControllerD() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/resources/clientes")
                .header(HttpHeaders.AUTHORIZATION, "Basic QWRtaW46YWRtaW4=")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome", is("Joaquim Barbosa")));;
    }
    @Test
    public void testControllerF() throws Exception {
        List<Cliente> list = (List<Cliente>) repository.findAll();
        Cliente c = list.get(0);
        c.setNome("Pedro dos Santos");
        String json = new Utilities().getJson(c);
        mockMvc.perform(MockMvcRequestBuilders.put("/resources/cliente")
                .header(HttpHeaders.AUTHORIZATION, "Basic QWRtaW46YWRtaW4=")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nome", is("Pedro dos Santos")));
    }
    @Test
    public void testControllerG() throws Exception {
        List<Cliente> list = (List<Cliente>) repository.findAll();
        Cliente c = list.get(0);
        String json = new Utilities().getJson(c);
        mockMvc.perform(MockMvcRequestBuilders.delete("/resources/cliente")
                .header(HttpHeaders.AUTHORIZATION, "Basic QWRtaW46YWRtaW4=")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}