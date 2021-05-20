package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.LivroDto;
import br.com.zupacademy.natalia.casadocodigo.dto.LivroDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.LivroEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public List<LivroDto> listaLivros() {
        Iterable<LivroEntity> livroIterable = livroRepository.findAll();
        List<LivroDto> listaLivroDto = new ArrayList<>();
        for (LivroEntity livro : livroIterable) {
            listaLivroDto.add(new LivroDto(livro));
        }
        return listaLivroDto;
    }
}

