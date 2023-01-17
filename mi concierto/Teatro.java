package concierto;

public class Teatro {

	public static void main(String[] args) {
		Instrumento tambor = new Instrumento();
		tambor.setSonido("pum, pum, pum");
		Musico tamborilero = new Solista();
		tamborilero.setInstrumento(tambor);
		tamborilero.tocar();
		
		Instrumento platillo = new Instrumento();
		platillo.setSonido("chis, chis, chis");
		Musico platillero = new Solista();
		platillero.setInstrumento(platillo);
		platillero.tocar();
		
		Instrumento maraca = new Instrumento();
		Musico mrMaracas = new Solista();
		mrMaracas.setInstrumento(maraca);
		mrMaracas.getInstrumento().setSonido("chaca, chaca, cha!");
		mrMaracas.tocar();
		
		Instrumento voz = new Instrumento();
		voz.setSonido("jineteando en mi caballo, por la sierra yo me voy..");
		Musico antonioBanderas = new Solista();
		antonioBanderas.setInstrumento(voz);
		antonioBanderas.tocar();
		
		Instrumento bombo = new Instrumento("bumba, bumba, bumba");
		Musico bombero = new Solista (bombo);
		bombero.tocar();
		
		
		//Instrumento[] instrumentosArray = new Instrumento();
		
		Instrumento[] instrumentos = {tambor, platillo, maraca};
		Musico hombreOrquesta = new HombreOrquesta(instrumentos);
		hombreOrquesta.tocar();
		
	}
}


