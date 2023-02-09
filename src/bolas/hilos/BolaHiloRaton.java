package bolas.hilos;

import java.awt.Color;
import java.awt.Rectangle;

import bolas.bolas.Bola;
import bolas.ventanas.VentanaBolasRaton;

public class BolaHiloRaton extends Thread {

	private Bola bola;
	private VentanaBolasRaton ventanaBolasRaton;

	public BolaHiloRaton(Bola bola, VentanaBolasRaton ventanaBolasRaton) {
		this.bola = bola;
		this.ventanaBolasRaton = ventanaBolasRaton;
	}

	@Override
	public void run() {
		while (true) {
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (getBola().getPosicionX() < 0 || getBola().getPosicionX() > getVentanaBolasRaton().getWidth() - getBola().getDimension())
				getBola().cambiarSentidoX();

			if (getBola().getPosicionY() < 0 || getBola().getPosicionY() > getVentanaBolasRaton().getHeight() - getBola().getDimension())
				getBola().cambiarSentidoY();
			
			getBola().calcularPosicion();
			
			Rectangle thisRectangle = new Rectangle(getBola().getPosicionX(), getBola().getPosicionY(), getBola().getDimension(), getBola().getDimension());
			
			for (Bola otraBola: ventanaBolasRaton.getBolas()) {

				if (!otraBola.equals(getBola())) {
					
					if (thisRectangle.intersects(new Rectangle(otraBola.getPosicionX(), otraBola.getPosicionY(), otraBola.getDimension(), otraBola.getDimension()))) {
						
						otraBola.cambiarSentidoX();
						otraBola.cambiarSentidoY();
						
						if (getBola().getColor().equals(Color.RED)) {
							otraBola.setColor(Color.RED);
						}
						
					}
					
				}
				
			}
		}
	}

	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
	}

	public VentanaBolasRaton getVentanaBolasRaton() {
		return ventanaBolasRaton;
	}

	public void setVentanaBolasRaton(VentanaBolasRaton ventanaBolasRaton) {
		this.ventanaBolasRaton = ventanaBolasRaton;
	}

}
