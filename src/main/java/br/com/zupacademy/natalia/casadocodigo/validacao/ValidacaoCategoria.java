package br.com.zupacademy.natalia.casadocodigo.validacao;


import br.com.zupacademy.natalia.casadocodigo.dto.CategoriaDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.CategoriaEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidacaoCategoria implements Validator {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return ( CategoriaDtoRequest.class.isAssignableFrom(aClass));
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        CategoriaDtoRequest dtoCategoria = (CategoriaDtoRequest) o;
        Optional<CategoriaEntity> categoria = categoriaRepository.findByNomeCategoria(dtoCategoria.getNomeCategoria());

        if(categoria.isPresent()){
            errors.rejectValue("nomeCategoria", null, "O nome informado já existe");
        }

    }
}
