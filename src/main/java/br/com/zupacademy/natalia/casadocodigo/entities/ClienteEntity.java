package br.com.zupacademy.natalia.casadocodigo.entities;

import br.com.zupacademy.natalia.casadocodigo.dto.ClienteDtoRequest;
import org.springframework.util.Assert;


import javax.persistence.*;

@Entity
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nome;

    private String sobrenome;

    private String documento;//(cpf/cnpj)

    private String endereco;

    private String complemento;

    private String cidade;
    @ManyToOne
    private PaisEntity pais; //se o país tiver estados, um estado precisa ser selecionado
    @ManyToOne
    private EstadoEntity estado; //(caso aquele pais tenha estado) - apenas se o país tiver cadastro de estados

    private String telefone;

    private String cep;

    public ClienteEntity(ClienteDtoRequest cliente, EntityManager em) {
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.documento = cliente.getDocumento();
        this.endereco = cliente.getEndereco();
        this.complemento = cliente.getComplemento();
        this.cidade = cliente.getCidade();
        this.telefone = cliente.getTelefone();
        this.cep = cliente.getCep();
        this.pais = em.find(PaisEntity.class, cliente.getPaisId());
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public EstadoEntity getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}

