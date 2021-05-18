package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.AutorDto;
import br.com.zupacademy.natalia.casadocodigo.entities.AutorEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;



@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<String> novoAutor (@RequestBody @Valid AutorDto autor){
        AutorEntity autorEntity = new AutorEntity(autor);
        autorRepository.save(autorEntity);
        return ResponseEntity.ok("Autor criado");

    }
}
