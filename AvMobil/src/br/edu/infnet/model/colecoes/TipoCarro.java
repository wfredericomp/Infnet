package br.edu.infnet.model.colecoes;

public enum TipoCarro {
	PERUA(1), SUV(2), HATCH(3), SEDAN(4), VAN(5), CONVERSÍVEL(6), OUTRO(7);

	private int value;

	private TipoCarro(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
