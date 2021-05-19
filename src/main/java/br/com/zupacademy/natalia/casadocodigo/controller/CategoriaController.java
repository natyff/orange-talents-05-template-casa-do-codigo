package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.CategoriaDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.CategoriaEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;


    @PostMapping
    public ResponseEntity<String> novaCategoria(@RequestBody @Valid CategoriaDtoRequest categoria){
        CategoriaEntity categoriaEntity = new CategoriaEntity(categoria);
       categoriaRepository.save(categoriaEntity);
       return ResponseEntity.ok().body(categoria.toString());
    }

}
