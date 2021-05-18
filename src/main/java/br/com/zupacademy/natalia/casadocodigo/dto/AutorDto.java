package br.com.zupacademy.natalia.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDto {


    private String nome;
    private String email;
    private String descricao;


    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + ", E-mail: " + email + ", Descrição: " + descricao;
    }
}
