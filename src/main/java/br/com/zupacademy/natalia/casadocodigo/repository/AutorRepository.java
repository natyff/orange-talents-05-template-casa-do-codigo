package br.com.zupacademy.natalia.casadocodigo.repository;

import br.com.zupacademy.natalia.casadocodigo.entities.AutorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<AutorEntity, Long> {


    Optional<AutorEntity> findByEmail(String email);
}
