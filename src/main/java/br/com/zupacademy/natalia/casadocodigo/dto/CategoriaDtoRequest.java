package br.com.zupacademy.natalia.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

public class CategoriaDtoRequest {

    @NotBlank
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
