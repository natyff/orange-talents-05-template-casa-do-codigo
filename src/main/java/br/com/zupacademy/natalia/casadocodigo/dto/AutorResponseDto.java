package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.AutorEntity;

public class AutorResponseDto {

    private String nome;
    private String descricao;

    public AutorResponseDto(AutorEntity autorEntity){
        this.nome = autorEntity.getNome();
        this.descricao = autorEntity.getDescricao();
    }

    public String getNome() {
        return nome;
    }
    public String getDescricao(){
        return descricao;
    }
}
