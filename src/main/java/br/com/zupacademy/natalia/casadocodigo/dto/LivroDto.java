package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.LivroEntity;

public class LivroDto {

    private Long id;
    private String titulo;

    public LivroDto(LivroEntity livroEntity){
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
