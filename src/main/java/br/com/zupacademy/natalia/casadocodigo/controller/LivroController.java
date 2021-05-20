package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.LivroDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.LivroEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @PersistenceContext
    EntityManager em;


    @PostMapping
    public ResponseEntity<String> novoLivro(@RequestBody @Valid LivroDtoRequest livro){
        LivroEntity livroEntity = new LivroEntity(livro, em);
        livroRepository.save(livroEntity);
        return ResponseEntity.ok().build();
    }
}
