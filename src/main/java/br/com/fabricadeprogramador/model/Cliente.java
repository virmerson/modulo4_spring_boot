package br.com.fabricadeprogramador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id @GeneratedValue 
	private Long id;
	
	private String nome;
	
	@Column(nullable=false, length=50)
	private String email;

	
	public Cliente() {
	}
	public Cliente(String nome, String email) {
		this.nome=nome;
		this.email=email;
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
	
	
}
