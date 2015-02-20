package br.edu.infnet.model;

import br.edu.infnet.model.colecoes.TipoMotocicleta;

public class Motocicleta {
	private Integer id;
	private String chassi;
	private String montadora;
	private String modelo;
	private TipoMotocicleta tipo;
	private String cor;
	private Integer cilindrada;
	private Integer capacidadeTanque;
	private Float preco;

	public Motocicleta() {
		super();
	}

	public Motocicleta(Integer id, String chassi, String montadora,
			String modelo, TipoMotocicleta tipo, String cor,
			Integer cilindrada, Integer capacidadeTanque, Float preco) {
		super();
		this.id = id;
		this.chassi = chassi;
		this.montadora = montadora;
		this.modelo = modelo;
		this.tipo = tipo;
		this.cor = cor;
		this.cilindrada = cilindrada;
		this.capacidadeTanque = capacidadeTanque;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoMotocicleta getTipo() {
		return tipo;
	}

	public void setTipo(TipoMotocicleta tipo) {
		this.tipo = tipo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(Integer cilindrada) {
		this.cilindrada = cilindrada;
	}

	public Integer getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(Integer capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

}
