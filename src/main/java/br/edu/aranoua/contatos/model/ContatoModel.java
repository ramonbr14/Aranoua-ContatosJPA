package br.edu.aranoua.contatos.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value="contato")
@Relation(collectionRelation = "contatos")
@JsonInclude(Include.NON_NULL)

public class ContatoModel extends RepresentationModel<ContatoModel>{
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	private Date dataNascimento;
	private int idade;
	private String certificado;
	private Instituicao instituição;

}
 