package com.sistematizacao.entregadores.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ENTREGADORES")

public class EntregadoresModel implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer cpf;
	private String nome;
	private Integer capcidade_veiculo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCapcidade_veiculo() {
		return capcidade_veiculo;
	}
	public void setCapcidade_veiculo(Integer capcidade_veiculo) {
		this.capcidade_veiculo = capcidade_veiculo;
	}
	
	
	

}
