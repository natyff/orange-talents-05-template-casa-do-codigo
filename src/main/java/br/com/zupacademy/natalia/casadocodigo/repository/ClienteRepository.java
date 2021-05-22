package br.com.zupacademy.natalia.casadocodigo.repository;

import br.com.zupacademy.natalia.casadocodigo.entities.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {
}
