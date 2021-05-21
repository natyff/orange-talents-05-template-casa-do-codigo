package br.com.zupacademy.natalia.casadocodigo.entities;

import br.com.zupacademy.natalia.casadocodigo.dto.AutorDtoRequest;
import javax.persistence.*;
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


    public AutorEntity(AutorDtoRequest autorDtoRequest){
        this.nome = autorDtoRequest.getNome();
        this.email = autorDtoRequest.getEmail();
        this.descricao = autorDtoRequest.getDescricao();
        this.dataHoraRegistro = LocalDateTime.now();
    }
    public AutorEntity(){};

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
