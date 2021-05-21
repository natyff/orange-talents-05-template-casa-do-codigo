package br.com.zupacademy.natalia.casadocodigo.controller;

import br.com.zupacademy.natalia.casadocodigo.dto.PaisDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.PaisEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping("/pais")
    public ResponseEntity<String> paisNovo(@RequestBody @Valid PaisDtoRequest pais){
        PaisEntity paisEntity = new PaisEntity(pais);
        paisRepository.save(paisEntity);
        return ResponseEntity.ok().build();
    }

}
