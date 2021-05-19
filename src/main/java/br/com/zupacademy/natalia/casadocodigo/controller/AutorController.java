package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.AutorDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.AutorEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.natalia.casadocodigo.validacao.ValidacaoEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    ValidacaoEmail validacaoEmail;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validacaoEmail);
    }

    @PostMapping
    public ResponseEntity<String> novoAutor (@RequestBody @Valid AutorDtoRequest autor){
        AutorEntity autorEntity = new AutorEntity(autor);
        autorRepository.save(autorEntity);
        return ResponseEntity.ok(autor.toString());
    }
}
