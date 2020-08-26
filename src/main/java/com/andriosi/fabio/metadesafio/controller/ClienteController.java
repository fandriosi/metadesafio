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
import java.util.ArrayList;
import java.util.List;
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
    @RolesAllowed("ADMIN")
    @PostMapping(value = "/cliente")
    public @ResponseBody ResponseEntity<List<Cliente>>  addCliente(@Valid @RequestBody Cliente Cliente){
        repository.save(Cliente);
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }
    @DeleteMapping(value = "/cliente")
    public @ResponseBody ResponseEntity<List<Cliente>>  deleteClintes(@RequestBody Cliente Cliente){
        repository.delete(Cliente);
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );
    }

    @PutMapping(value = "/cliente")
    public @ResponseBody ResponseEntity<List<Cliente>>  updateCliente(@RequestBody Cliente Cliente){
        repository.save(Cliente);
        List<Cliente> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK );

    }
}
