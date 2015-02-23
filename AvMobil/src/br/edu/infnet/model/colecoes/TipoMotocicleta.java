package br.edu.infnet.model.colecoes;

public enum TipoMotocicleta {
	BOBBER(1), CAFE_RACER(2), CUSTOM(3), CHOPPER(4), ESPORTIVA(5), FUN_BIKER(6), HYPER_SPORT(
			7), MAXI_TRAIL(8), MINIMOTOS_OU_POCKETBIKES(9), NAKED(10), OFF_ROAD(
			11), MOTOS_DE_TRIAL(12), SCOOTERS(13), SIDE_CAR(14), STREET(15), STREETFIGHTER(
			16), SUPERMOTARD(17), UNDERBONE(18), WHEELIE(19), X_TUDO(20), OUTRA(
			21);

	private int value;

	private TipoMotocicleta(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
