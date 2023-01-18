package ejemploexcepciones.coches;

public class Viaje {

	public static void main(String[] args)  {
		Coche coche= new Coche();
		coche.setBateria(false);
		coche.setRueda(false);
		coche.setGasolina(false);
		
		coche.vamonosDeViaje();

	}

}
