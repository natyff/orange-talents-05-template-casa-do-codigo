package br.com.zupacademy.natalia.casadocodigo.repository;


import br.com.zupacademy.natalia.casadocodigo.entities.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Long> {

    Optional<CategoriaEntity> findByNomeCategoria(String nomeCategoria);
}
