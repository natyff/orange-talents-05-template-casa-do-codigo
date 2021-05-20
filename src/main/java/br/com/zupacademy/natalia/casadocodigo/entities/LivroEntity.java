package br.com.zupacademy.natalia.casadocodigo.entities;

import br.com.zupacademy.natalia.casadocodigo.dto.LivroDtoRequest;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private Integer isbn;
    private Date dataPublicacao;
    @ManyToOne
    private CategoriaEntity categoria;
    @ManyToOne
    private AutorEntity autor;


    public LivroEntity(LivroDtoRequest livro, EntityManager em) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = em.find(CategoriaEntity.class, livro.getCategoriaId());
        this.autor = em.find(AutorEntity.class, livro.getAutorId());
    }

    public LivroEntity(){};

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
