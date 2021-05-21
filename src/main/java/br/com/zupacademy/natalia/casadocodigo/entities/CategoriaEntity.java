package br.com.zupacademy.natalia.casadocodigo.entities;


import br.com.zupacademy.natalia.casadocodigo.dto.CategoriaDtoRequest;
import javax.persistence.*;


@Entity
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCategoria;


    public CategoriaEntity(CategoriaDtoRequest categoriaDto) {
        this.nomeCategoria = categoriaDto.getNomeCategoria();

    }

    public CategoriaEntity(){};
}
