package ejemploexcepciones.coches;

import ejemploexcepciones.excepciones.RuedaPinchadaException;
import ejemploexcepciones.excepciones.SinBateriaException;
import ejemploexcepciones.excepciones.SinGasolinaException;

public class Coche {
	

	private boolean gasolina,bateria,rueda;
	
	public Coche() {
	}
	
	public void arrancar() throws SinGasolinaException, SinBateriaException, RuedaPinchadaException {
		if(!isGasolina())
			throw new SinGasolinaException("El coche no tiene gasolina");
		if(!isBateria())
			throw new SinBateriaException("la bateria esta agotada");
		if(!isRueda())
			throw new RuedaPinchadaException("la rueda esta pinchada");
		System.out.println("El motor esta en marcha y nos vamos de viaje");
	}
	
	public void vamonosDeViaje()  {
		
		while(isBateria()!=true || isGasolina()!=true || isRueda()!=true){
			try {
				arrancar();
				
			} catch (SinGasolinaException e) {
				System.out.println(e.getMessage());
				System.out.println("lleno el deposito de gasolina");
				setGasolina(true);
				e.printStackTrace();
				
			} catch (SinBateriaException e) {
				System.out.println(e.getMessage());
				System.out.println("compro una bateria nueva");
				setBateria(true);
				
				
			} catch (RuedaPinchadaException e) {
				System.out.println(e.getMessage());
				System.out.println("cambio la rueda");
				setRueda(true);
				
			}
			
			
		}
		try {
			arrancar();
		} catch (SinGasolinaException | SinBateriaException | RuedaPinchadaException e) {
			
		}
		
	}

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

}
