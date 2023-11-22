package com.TestesFelipeGoncalves.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String nome;
private Long cpf;

@OneToMany(mappedBy = "cliente")
private List<Aluguel> alugueis;

public Cliente() {
	
}
public Cliente(long id, String nome, Long cpf, List<Aluguel> alugueis) {
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.alugueis = alugueis;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Long getCpf() {
	return cpf;
}

public void setCpf(Long cpf) {
	this.cpf = cpf;
}

public List<Aluguel> getAlugueis() {
	return alugueis;
}

public void setAlugueis(List<Aluguel> alugueis) {
	this.alugueis = alugueis;
}
	
	


}
//()