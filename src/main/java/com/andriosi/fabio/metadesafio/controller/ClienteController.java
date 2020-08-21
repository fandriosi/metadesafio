package com.andriosi.fabio.metadesafio.controller;

import com.andriosi.fabio.metadesafio.entity.Cliente;
import com.andriosi.fabio.metadesafio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    @Autowired
    private ClienteRepository repository ;
    @GetMapping("/Clientes")
    public @ResponseBody
    ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
    @PostMapping(value = "/Cliente")
    public @ResponseBody ResponseEntity<List<Cliente>>  addCliente(@RequestBody Cliente Cliente){
        repository.save(Cliente);
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
    @DeleteMapping(value = "/Cliente")
    public @ResponseBody ResponseEntity<List<Cliente>>  deleteClintes(@RequestBody Cliente Cliente){
        repository.delete(Cliente);
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }

    @PutMapping(value = "/Cliente")
    public @ResponseBody ResponseEntity<List<Cliente>>  updateCliente(@RequestBody Cliente Cliente){
        repository.save(Cliente);
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );

    }
}
