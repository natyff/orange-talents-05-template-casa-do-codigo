package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.EstadoEntity;
import br.com.zupacademy.natalia.casadocodigo.entities.PaisEntity;
import br.com.zupacademy.natalia.casadocodigo.validacao.ExistId;
import br.com.zupacademy.natalia.casadocodigo.validacao.ValorUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoDtoRequest {

    @NotBlank
    @ValorUnico(domainClass = EstadoEntity.class, fieldName = "nomeEstado")
    private String nomeEstado;
    @NotNull
    @ExistId(domainClass = PaisEntity.class, fieldValue = "id")
    private Long idPais;


    public EstadoDtoRequest(EstadoEntity estado){
        this.idPais = estado.getId();
        this.nomeEstado = estado.getNomeEstado();
    }

    public EstadoDtoRequest(){};

    public String getNomeEstado() {
        return nomeEstado;
    }

    public Long getIdPais() {
        return idPais;
    }
}
