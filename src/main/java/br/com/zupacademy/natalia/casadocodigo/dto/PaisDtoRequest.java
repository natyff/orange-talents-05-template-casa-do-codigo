package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.PaisEntity;
import br.com.zupacademy.natalia.casadocodigo.validacao.ValorUnico;

import javax.validation.constraints.NotBlank;

public class PaisDtoRequest {

    @NotBlank @ValorUnico(domainClass = PaisEntity.class, fieldName = "nomePais")
    private String nomePais;

    public String getNomePais() {
        return nomePais;
    }

}
