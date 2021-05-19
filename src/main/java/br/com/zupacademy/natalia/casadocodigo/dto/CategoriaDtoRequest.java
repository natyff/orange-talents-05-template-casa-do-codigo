package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.CategoriaEntity;
import br.com.zupacademy.natalia.casadocodigo.validacao.ValorUnico;
import javax.validation.constraints.NotBlank;

public class CategoriaDtoRequest {

    @NotBlank
    @ValorUnico(domainClass = CategoriaEntity.class, fieldName = "nomeCategoria")
    private String nomeCategoria;

    public CategoriaDtoRequest(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public CategoriaDtoRequest() {
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    @Override
    public String toString(){
        return "Nova categoria criada: " + nomeCategoria;
    }
}
