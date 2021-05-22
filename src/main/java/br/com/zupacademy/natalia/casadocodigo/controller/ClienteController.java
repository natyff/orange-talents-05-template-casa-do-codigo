package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.ClienteDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.ClienteEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.natalia.casadocodigo.validacao.EstadoPertencePais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;


@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private EstadoPertencePais estadoPertencePais;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoPertencePais);
    }

    @PersistenceContext
    EntityManager em;

    @PostMapping
    public ResponseEntity<String> novoCliente(@RequestBody @Valid ClienteDtoRequest cliente){
        ClienteEntity clienteEntity = new ClienteEntity(cliente, em);
        clienteRepository.save(clienteEntity);
        return ResponseEntity.ok(cliente.toString());

    }


}


