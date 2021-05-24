package br.com.zupacademy.natalia.casadocodigo.entities;

import br.com.zupacademy.natalia.casadocodigo.dto.EstadoDtoRequest;

import javax.persistence.*;

@Entity
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeEstado;
    @ManyToOne
    private PaisEntity pais;

    public EstadoEntity(EstadoDtoRequest estado, EntityManager em) {
        this.nomeEstado = estado.getNomeEstado();
        this.pais = em.find(PaisEntity.class, estado.getIdPais());
    }

    public EstadoEntity(){};

    public Long getId() {
        return id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public PaisEntity getPais() {
        return pais;
    }


}
