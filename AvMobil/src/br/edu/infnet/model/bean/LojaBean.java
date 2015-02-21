package br.edu.infnet.model.bean;

import br.edu.infnet.model.Loja;

public class LojaBean {
	private Loja pojo = new Loja();

	public Loja getLoja() {
		return pojo;
	}

	public void gravaLoja() {
		System.out.println(this.pojo.getNome());
		this.pojo.setNome(this.pojo.getNome());

		System.out.println(this.pojo.getEndereco());
		this.pojo.setEndereco(this.pojo.getEndereco());
	}
}
