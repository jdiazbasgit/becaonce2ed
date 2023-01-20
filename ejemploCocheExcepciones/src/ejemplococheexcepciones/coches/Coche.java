package ejemplococheexcepciones.coches;

import ejemplococheexcepciones.excepciones.RuedaPinchadaException;
import ejemplococheexcepciones.excepciones.SinBateriaException;
import ejemplococheexcepciones.excepciones.SinGasolinaException;

public class Coche {

	private boolean gasolina, bateria, rueda;

	public boolean isGasolina() {
		return gasolina;
	}

	public void setGasolina(boolean gasolina) {
		this.gasolina = gasolina;
	}

	public boolean isBateria() {
		return bateria;
	}

	public void setBateria(boolean bateria) {
		this.bateria = bateria;
	}

	public boolean isRueda() {
		return rueda;
	}

	public void setRueda(boolean rueda) {
		this.rueda = rueda;
	}

	public Coche() {
	}

	public void arrancar() throws SinGasolinaException, SinBateriaException, RuedaPinchadaException {
		if (!isGasolina())
			throw new SinGasolinaException("El coche no tiene gasolina");
		if (!isBateria())
			throw new SinBateriaException("El coche no tiene bateria");
		if (!isRueda())
			throw new RuedaPinchadaException("El coche no tiene ruedas");
		System.out.println("El motor ronronea, nos vamos!");
	}

	public void vamosDeViaje() {

		while (isBateria() != true || isGasolina() != true || isRueda() != true) {
			try {
				arrancar();
				//System.out.println("El motor ronronea, nos vamos!");
			} catch (SinGasolinaException e) {
				System.out.println(e.getMessage());
				System.out.println("lleno el deposito de gasolina");
				setGasolina(true);
				
			} catch (SinBateriaException e) {
				System.out.println(e.getMessage());
				System.out.println("cambio la bateria");
				setBateria(true);
				
			} catch (RuedaPinchadaException e) {
				System.out.println(e.getMessage());
				System.out.println("cambio las ruedas");
				setRueda(true);

			}

		}
		try {
			System.out.println("hola");
			arrancar();
		} catch (Exception e) {
		//} catch (SinGasolinaException | SinBateriaException | RuedaPinchadaException e) {
			
		}

	}

}
