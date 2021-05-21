package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.LivroDetalhesDto;
import br.com.zupacademy.natalia.casadocodigo.dto.LivroListaDto;
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
import java.util.Optional;

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
    public List<LivroListaDto> listaLivros() {
        Iterable<LivroEntity> livroIterable = livroRepository.findAll();
        List<LivroListaDto> listaLivroListaDto = new ArrayList<>();
        for (LivroEntity livro : livroIterable) {
            listaLivroListaDto.add(new LivroListaDto(livro));
        }
        return listaLivroListaDto;
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<LivroDetalhesDto> detalheLivro(@PathVariable Long id){
        Optional<LivroEntity> livro = livroRepository.findById(id);
        if(livro.isPresent()){
            return ResponseEntity.ok(new LivroDetalhesDto(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }

}

