package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.AutorEntity;
import br.com.zupacademy.natalia.casadocodigo.entities.CategoriaEntity;
import br.com.zupacademy.natalia.casadocodigo.entities.LivroEntity;
import br.com.zupacademy.natalia.casadocodigo.validacao.ExistId;
import br.com.zupacademy.natalia.casadocodigo.validacao.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.*;
import java.math.BigDecimal;

import java.util.Date;

public class LivroDtoRequest {

    @NotBlank @ValorUnico(domainClass = LivroEntity.class, fieldName = "titulo")
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull @DecimalMin("20.00")
    private BigDecimal preco;
    @NotNull @Min(value = 100)
    private Integer paginas;
    @NotNull @ValorUnico(domainClass = LivroEntity.class, fieldName = "isbn")
    private Integer isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPublicacao;
    @NotNull @ExistId(domainClass = CategoriaEntity.class, fieldValue = "id" )
    private Long categoriaId;
    @NotNull @ExistId(domainClass = AutorEntity.class, fieldValue = "id" )
    private Long autorId;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }
}
