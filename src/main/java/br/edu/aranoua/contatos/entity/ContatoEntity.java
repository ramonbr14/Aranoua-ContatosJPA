package br.edu.aranoua.contatos.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.edu.aranoua.contatos.model.Instituicao;

@Entity
@Table(name="contato")
public class ContatoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String email;
	
	private String endereco;
	
	private String telefone;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Transient
	private int idade=0;
	
	@Transient
	private String certificado;
	
	@Transient
	private Instituicao instituicao;

	public ContatoEntity() {}

	public ContatoEntity(String nome, String email, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		if(idade == 0) {
			Calendar data = new GregorianCalendar();
			data.setTime(dataNascimento);
			Calendar hoje = Calendar.getInstance();
			idade = hoje.get(Calendar.YEAR)-data.get(Calendar.YEAR);
			
		}
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	
	
	
	
	

	
}
