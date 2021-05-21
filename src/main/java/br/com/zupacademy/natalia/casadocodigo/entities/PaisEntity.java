package br.com.zupacademy.natalia.casadocodigo.entities;

import br.com.zupacademy.natalia.casadocodigo.dto.PaisDtoRequest;

import javax.persistence.*;


@Entity
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePais;


    public PaisEntity(PaisDtoRequest pais) {
        this.nomePais = pais.getNomePais();
    }

    public PaisEntity(){};

    public Long getId() {
        return id;
    }

    public String getNomePais() {
        return nomePais;
    }

}
