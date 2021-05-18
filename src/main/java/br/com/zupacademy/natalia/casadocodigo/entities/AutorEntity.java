package br.com.zupacademy.natalia.casadocodigo.entities;

import br.com.zupacademy.natalia.casadocodigo.dto.AutorDto;
import org.hibernate.type.LocalDateTimeType;
import org.hibernate.type.LocalDateType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataHoraRegistro;


    public AutorEntity(AutorDto autorDto){
        this.nome = autorDto.getNome();
        this.email = autorDto.getEmail();
        this.descricao = autorDto.getDescricao();
        this.dataHoraRegistro = LocalDateTime.now();
    }
}
