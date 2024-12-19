package br.gov.pbh.prefeitura.cadastroCarros.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Carro.java
 * Este modelo representa a entidade Carro
 * @author Eric de Oliveira Campos
 *
 */

@Entity
@Table(name = "carro")
public class Carro {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "placa")
	private String placa;
	
	@Column(name = "fabricacao")
	private LocalDate fabricacao;
	
	protected Carro() {
		
	}
	
	public Carro(Long id, String modelo, String marca, String placa, LocalDate fabricacao) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca= marca;
		this.placa = placa;
		this.fabricacao = fabricacao;
	}

	public Carro(String modelo, String marca, String placa, LocalDate fabricacao) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.fabricacao = fabricacao;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDate getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(LocalDate fabricacao) {
		this.fabricacao = fabricacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
