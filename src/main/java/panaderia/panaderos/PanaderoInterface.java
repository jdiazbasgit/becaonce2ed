package panaderia.panaderos;

import panaderia.excepciones.PanCrudoException;
import sniffer.anotaciones.SniffThis;

public interface PanaderoInterface {
	@SniffThis
	public void hornear(int x) throws PanCrudoException;
	@SniffThis
	public void sacarDelHorno();
}
