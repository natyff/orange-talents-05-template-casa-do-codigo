package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.ClienteEntity;

public class ClienteResponseDto {

    private Long id;


    public ClienteResponseDto() {}

    public ClienteResponseDto(ClienteEntity cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }

}

