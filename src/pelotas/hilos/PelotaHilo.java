package pelotas.hilos;



import java.awt.Rectangle;
import pelotas.pelotas.Pelota;
import pelotas.ventanas.VentanaPelotas;
public class PelotaHilo extends Thread{
	
	private Pelota pelota;
	private VentanaPelotas ventanaPelotas;
	private final int rebotesMaximos = 1000;
	public PelotaHilo(Pelota pelota, VentanaPelotas ventanaPelotas) {
		
		this.pelota = pelota;
		this.ventanaPelotas = ventanaPelotas;
	
			
	}
	public void run() {
		while (true) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (getPelota().getPosicionX() < 0
					|| getPelota().getPosicionX() > getVentanaPelotas().getWidth() - getPelota().getDimension()) {
				getPelota().setSentidoX(getPelota().getSentidoX() * -1);
				
			}

			if (getPelota().getPosicionY() < 0
					|| getPelota().getPosicionY() > getVentanaPelotas().getHeight() - getPelota().getDimension()) {
				getPelota().setSentidoY(getPelota().getSentidoY() * -1);
				
			}
			try {
				for (Pelota otra : getVentanaPelotas().getPelotas()) {
					if (!getPelota().equals(otra)) {
						Rectangle yo = new Rectangle(getPelota().getPosicionX(),getPelota().getPosicionY(),getPelota().getDimension(),getPelota().getDimension());
						Rectangle otro = new Rectangle(otra.getPosicionX(),otra.getPosicionY(),otra.getDimension(),otra.getDimension());
						if (yo.intersects(otro)) {
							getPelota().setSentidoX(getPelota().getSentidoX()*-1);
							getPelota().setSentidoY(getPelota().getSentidoY()*-1);	
							getPelota().setImpactos(getPelota().getImpactos()+1);						
							}
					}				
				}
			} catch (Exception e) {
				getVentanaPelotas().getPelotas().remove(getPelota());
				break;
			}			
			
			getPelota().calcularPosicion();
			if (getPelota().getImpactos()>rebotesMaximos) {
				getVentanaPelotas().getPelotas().remove(getPelota());
				break;
				
			}
				
			}
		}
	

public Pelota getPelota() {
	return pelota;
}

public void setPelota(Pelota pelota) {
	this.pelota = pelota;
}

public VentanaPelotas getVentanaPelotas() {
	return ventanaPelotas;
}

public void setVentanaPelotas(VentanaPelotas ventanaPelotas) {
	this.ventanaPelotas = ventanaPelotas;
}

}