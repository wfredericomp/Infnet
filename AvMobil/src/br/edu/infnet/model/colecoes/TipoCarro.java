package br.edu.infnet.model.colecoes;

import java.util.ArrayList;

public enum TipoCarro {
	PERUA(1), SUV(2), HATCH(3), SEDAN(4), VAN(5), CONVERSIVEL(6), OUTRO(7);

	private int value;

	private TipoCarro(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public static ArrayList<String> getNomes () {
		ArrayList<String> tipoCarro = new ArrayList<String>();
		
		for(TipoCarro car : TipoCarro.values()){
			tipoCarro.add(car.toString());
		}
				
		return tipoCarro;
		
	}
}
