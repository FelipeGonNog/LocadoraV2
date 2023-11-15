package com.TestesFelipeGoncalves.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Aluguel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private LocalDate dataAluguel;
private LocalDate dataDevolucao;
private BigDecimal valor;

@ManyToOne
@JoinColumn(name = "cliente_id")
private Cliente cliente;

@ManyToOne
@JoinColumn(name = "carro_id")
private Carro carro;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public LocalDate getDataAluguel() {
	return dataAluguel;
}

public void setDataAluguel(LocalDate dataAluguel) {
	this.dataAluguel = dataAluguel;
}

public LocalDate getDataDevolucao() {
	return dataDevolucao;
}

public void setDataDevolucao(LocalDate dataDevolucao) {
	this.dataDevolucao = dataDevolucao;
}

public BigDecimal getValor() {
	return valor;
}

public void setValor(BigDecimal valor) {
	this.valor = valor;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Carro getCarro() {
	return carro;
}

public void setCarro(Carro carro) {
	this.carro = carro;
}



}
//()