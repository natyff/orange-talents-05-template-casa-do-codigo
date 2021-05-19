package br.com.zupacademy.natalia.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDtoRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email(message = "Digite um e-mail valido")
    private String email;
    @NotBlank @Size(max = 400, message = "Descrição máximo de 400 caracteres")
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
