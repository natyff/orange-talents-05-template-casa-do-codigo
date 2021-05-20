package br.com.zupacademy.natalia.casadocodigo.repository;

import br.com.zupacademy.natalia.casadocodigo.entities.LivroEntity;
import org.springframework.data.repository.CrudRepository;


public interface LivroRepository extends CrudRepository<LivroEntity, Long> {

}
