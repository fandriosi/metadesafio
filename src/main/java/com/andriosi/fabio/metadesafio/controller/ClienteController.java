package com.andriosi.fabio.metadesafio.controller;

import com.andriosi.fabio.metadesafio.entity.Cliente;
import com.andriosi.fabio.metadesafio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/resources")
public class ClienteController {
    @Autowired
    private ClienteRepository repository ;
    @GetMapping("/clientes")
    public @ResponseBody
    ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
    @PostMapping(value = "/clientes")
    public @ResponseBody ResponseEntity<Cliente>  addCliente(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(repository.save(cliente), HttpStatus.OK );
    }
    @DeleteMapping(value = "/clientes/{id}")
    public @ResponseBody ResponseEntity<Map<String, Boolean>> deleteClintes(@PathVariable(value = "id") Long id ){
        Optional<Cliente> cliente = repository.findById(id);
        repository.delete(cliente.get());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<>(response, HttpStatus.OK );
    }

    @PutMapping(value = "/clientes")
    public @ResponseBody ResponseEntity<Cliente>  updateCliente(@Valid @RequestBody Cliente cliente){
        repository.save(cliente);
        Optional<Cliente> c = repository.findById(cliente.getId());
        return new ResponseEntity<>(c.get(), HttpStatus.OK );
    }
    @GetMapping("/clientes/{id}")
    public @ResponseBody ResponseEntity<Cliente> findById(@PathVariable(value = "id") Long id){
        Optional<Cliente> cliente = repository.findById(id);
        return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
    }
}
