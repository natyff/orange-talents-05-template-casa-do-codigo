package br.com.zupacademy.natalia.casadocodigo.validacao;

import br.com.zupacademy.natalia.casadocodigo.dto.ClienteDtoRequest;
import br.com.zupacademy.natalia.casadocodigo.entities.EstadoEntity;
import br.com.zupacademy.natalia.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;


@Component
public class EstadoPertencePais implements Validator {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteDtoRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        ClienteDtoRequest clienteDtoRequest = (ClienteDtoRequest) obj;
        List<EstadoEntity> estados = estadoRepository.findByPaisId(clienteDtoRequest.getPaisId());
        if(estados.size()>=1  && clienteDtoRequest.getEstadoId() == null) {
            errors.rejectValue("estadoId", null, "Selecione um estado");
        }
        if(clienteDtoRequest.getEstadoId() !=null && estadoNaoPertencePais(estados, clienteDtoRequest)){
            errors.rejectValue("estadoId", null, "O estado informado, não pertence ao país informado ");
        }

    }
    public boolean estadoNaoPertencePais(List<EstadoEntity> estados, ClienteDtoRequest clienteDtoRequest){
        for(EstadoEntity estadoEntity :estados){
            if(clienteDtoRequest.getEstadoId().equals(estadoEntity.getId())){
                return false;
            }
        }
        return true;
    }
}