package br.edu.infnet.model.bean;

import br.edu.infnet.model.Loja;

public class LojaBean {
	private Loja loja = new Loja();

	public Loja getLoja() {
		return loja;
	}

	public void gravaLoja() {
		System.out.println(this.loja.getNome());
		loja.setNome(this.loja.getNome());

		System.out.println(this.loja.getEndereco());
		loja.setEndereco(this.loja.getEndereco());
	}
}
