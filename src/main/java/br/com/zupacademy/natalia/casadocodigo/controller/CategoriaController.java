package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.CategoriaDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.CategoriaEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.natalia.casadocodigo.validacao.ValidacaoCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ValidacaoCategoria validacaoCategoria;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validacaoCategoria);
    }


    @PostMapping
    public ResponseEntity<String> novaCategoria(@RequestBody @Valid CategoriaDtoRequest categoria){
        CategoriaEntity categoriaEntity = new CategoriaEntity(categoria);
       categoriaRepository.save(categoriaEntity);
       return ResponseEntity.ok().body(categoria.toString());
    }

}
