package br.com.zupacademy.natalia.casadocodigo.validacao;

import br.com.zupacademy.natalia.casadocodigo.dto.AutorDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.AutorEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidacaoEmail implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorDtoRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorDtoRequest dto = (AutorDtoRequest) o;
        Optional<AutorEntity> possivelAutor = autorRepository.findByEmail(dto.getEmail());

        if(possivelAutor.isPresent()){
            errors.rejectValue("email", null, "O email informado já existe");
        }
    }
}
