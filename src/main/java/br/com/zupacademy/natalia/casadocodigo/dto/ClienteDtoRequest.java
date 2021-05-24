package br.com.zupacademy.natalia.casadocodigo.dto;

import br.com.zupacademy.natalia.casadocodigo.entities.ClienteEntity;
import br.com.zupacademy.natalia.casadocodigo.entities.EstadoEntity;
import br.com.zupacademy.natalia.casadocodigo.entities.PaisEntity;
import br.com.zupacademy.natalia.casadocodigo.validacao.CpfOrCnpj;
import br.com.zupacademy.natalia.casadocodigo.validacao.ExistId;
import br.com.zupacademy.natalia.casadocodigo.validacao.ValorUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDtoRequest {

   @NotBlank
   @Email
   @ValorUnico(domainClass = ClienteEntity.class, fieldName = "email")
   private String email;
   @NotBlank
   private String nome;
   @NotBlank
   private String sobrenome;
   @NotBlank
   @CpfOrCnpj
   @ValorUnico(domainClass = ClienteEntity.class, fieldName = "documento")
   private String documento;//(cpf/cnpj)
   @NotBlank
   private String endereco;
   @NotBlank
   private String complemento;
   @NotBlank
   private String cidade;
   @NotNull
   @ExistId(domainClass = PaisEntity.class, fieldValue = "id")
   private Long paisId; //(se o país tiver estados, um estado precisa ser selecionado)
   @ExistId(domainClass = EstadoEntity.class, fieldValue = "id")
   private Long estadoId; //(caso aquele pais tenha estado)
   @NotBlank
   private String telefone;
   @NotBlank
   private String cep;

   public ClienteDtoRequest(){};

   public String getEmail() {
      return email;
   }

   public String getNome() {
      return nome;
   }

   public String getSobrenome() {
      return sobrenome;
   }

   public String  getDocumento() {
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

   public Long getPaisId() {
      return paisId;
   }

   public Long getEstadoId() {
      return estadoId;
   }

   public String getTelefone() {
      return telefone;
   }

   public String getCep() {
      return cep;
   }



}
