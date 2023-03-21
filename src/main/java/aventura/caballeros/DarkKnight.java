package aventura.caballeros;

import org.springframework.stereotype.Component;

import aventura.anotaciones.SniffThis;
import aventura.excepciones.SinEspadaException;
import lombok.Data;

@Data
@Component
public class DarkKnight extends Thread implements KnightInterface{
	
	//@Value("true")  esta anotaciÃ³n hace un set de espada, pero no la uso xq lo saquÃ© a un mÃ©todo que llamo en el main
	private boolean espada;
	private int sleepTime;
	@SniffThis
	public void embarcar() throws SinEspadaException {
		
		sleepThread();
		System.err.println("\n=========================================");
		System.err.println("("+this.getClass().getSimpleName()+") Ajá! voy a embarcarme en un misión!, rescatar princesas es mi pasión!");
		System.err.println("=========================================");
		if ((!isEspada())) {
			sleepThread();
			System.err.println("\n=========================================");
			System.err.println("("+this.getClass().getSimpleName()+") Ujú! sabía que algo se me olvidaba... :(");
			System.err.println("=========================================");
			sleepThread();
			throw new SinEspadaException("Espada no encontrada");
		}		
		matarAlDragon();	
	}
	@SniffThis
	public void matarAlDragon() {
		sleepThread();
		System.err.println("\n=========================================");
		System.err.println("("+this.getClass().getSimpleName()+") Ajá! he vuelto victorioso de matar al dragón!, a mí las mujeres y el ron!");
		System.err.println("=========================================");
		sleepThread();
	}
	@SniffThis
	public void entregarEspada(boolean x) {
		setEspada(x);
	}
	@SniffThis
	public void ajustarSleep(int y) {
		setSleepTime(y);
	}
	@SniffThis
	public void sleepThread() {
		try {
			Thread.sleep(getSleepTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
