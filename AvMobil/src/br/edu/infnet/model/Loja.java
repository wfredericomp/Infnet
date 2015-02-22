package br.edu.infnet.model;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
@SessionScoped
public class Loja {
	private String nome;
	private String endereco;
	private ArrayList<Carro> listCar = new ArrayList<Carro>();
	private ArrayList<Motocicleta> listMotocicleta = new ArrayList<Motocicleta>();

	public Loja() {
		super();
	}

	public Loja(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Carro> getListCar() {
		return listCar;
	}

	public void setListCar(Carro listCar) {
		this.listCar.add(listCar);
	}

	public ArrayList<Motocicleta> getListMotocicleta() {
		return listMotocicleta;
	}

	public void setListMotocicleta(Motocicleta listMotocicleta) {
		this.listMotocicleta.add(listMotocicleta);
	}

}
