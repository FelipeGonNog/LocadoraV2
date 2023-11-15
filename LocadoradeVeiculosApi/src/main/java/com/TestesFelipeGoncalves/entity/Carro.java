package com.TestesFelipeGoncalves.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Carro {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String marca;
private String modelo;
private Double valor;

@ManyToOne
private Cliente cliente;


public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}


public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public Double getValor() {
	return valor;
}

public void setValor(Double valor) {
	this.valor = valor;
}

}
//()