package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.LivroEntity;

public class LivroListaDto {

    private Long id;
    private String titulo;

    public LivroListaDto(LivroEntity livroEntity){
        this.id = livroEntity.getId();
        this.titulo = livroEntity.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
