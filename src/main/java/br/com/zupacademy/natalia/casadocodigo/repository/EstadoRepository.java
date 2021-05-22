package br.com.zupacademy.natalia.casadocodigo.repository;

import br.com.zupacademy.natalia.casadocodigo.entities.EstadoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EstadoRepository extends CrudRepository<EstadoEntity, Long> {

    List<EstadoEntity> findByPaisId(Long paisId);
}
