package panaderia.panaderos;

import org.springframework.stereotype.Component;

import panaderia.excepciones.PanCrudoException;
import sniffer.anotaciones.SniffThis;

@Component
public class Panadero implements PanaderoInterface{

	@SniffThis
	public void hornear(int x) throws PanCrudoException {
		
		System.out.println("Voy a hacer pan :)");
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (x<=1000) {
			throw new PanCrudoException("Demasiado pronto, el pan está crudo! :(");
		}
		sacarDelHorno();
	}	
	@SniffThis
	public void sacarDelHorno() {
		
		System.out.println("mmm... Pan caliente!");
		
	}	

}
