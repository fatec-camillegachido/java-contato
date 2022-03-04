package com.aula2.contato.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String email;
	
	@Column(nullable = false)
	private String nome;
	
	private String telefone;
	
	public Contato() {}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
