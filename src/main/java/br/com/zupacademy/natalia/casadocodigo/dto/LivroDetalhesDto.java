package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.AutorEntity;
import br.com.zupacademy.natalia.casadocodigo.entities.LivroEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class LivroDetalhesDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private Integer isbn;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPublicacao;
    private AutorResponseDto autor;


    public LivroDetalhesDto(LivroEntity livroEntity) {
        this.titulo = livroEntity.getTitulo();
        this.resumo = livroEntity.getResumo();
        this.sumario = livroEntity.getSumario();
        this.preco = livroEntity.getPreco();
        this.paginas = livroEntity.getPaginas();
        this.isbn = livroEntity.getIsbn();
        this.dataPublicacao = livroEntity.getDataPublicacao();
        this.autor = new AutorResponseDto(livroEntity.getAutor());

    }


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

    public AutorResponseDto getAutor() {
        return autor;
    }


}
