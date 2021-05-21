package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.EstadoDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.EstadoEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class EstadoController {


    @Autowired
    EstadoRepository estadoRepository;

    @PersistenceContext
    EntityManager em;

    @PostMapping("/estado")
    public ResponseEntity<String> estadoNovo(@RequestBody @Valid EstadoDtoRequest estado){
        EstadoEntity estadoEntity = new EstadoEntity(estado, em);
        estadoRepository.save(estadoEntity);
        return ResponseEntity.ok().build();
    }
}
