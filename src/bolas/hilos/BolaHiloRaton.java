package bolas.hilos;

import java.awt.Color;
import java.awt.Rectangle;

import bolas.bolas.Bola;
import bolas.ventanas.VentanaBolasConMouse;

public class BolaHiloRaton extends Thread{

	private Bola bola;
	private VentanaBolasConMouse ventanaBolasConMouse;

	public BolaHiloRaton(Bola bola, VentanaBolasConMouse ventanaBolasConMouse) {
		this.bola = bola;
		this.ventanaBolasConMouse = ventanaBolasConMouse;
	}

	@Override
	public void run() {
		while (true) {
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (getBola().getPosicionX() < 0 || getBola().getPosicionX() > getventanaBolasConMouse().getWidth() - getBola().getDimension())
				getBola().cambiarSentidoX();

			if (getBola().getPosicionY() < 0 || getBola().getPosicionY() > getventanaBolasConMouse().getHeight() - getBola().getDimension())
				getBola().cambiarSentidoY();
			
			getBola().calcularPosicion();
			
			Rectangle thisRectangle = new Rectangle(getBola().getPosicionX(), getBola().getPosicionY(), getBola().getDimension(), getBola().getDimension());
			
			for (Bola otraBola: ventanaBolasConMouse.getBolas()) {

				if (!otraBola.equals(getBola())) {
					
					if (thisRectangle.intersects(new Rectangle(otraBola.getPosicionX(), otraBola.getPosicionY(), otraBola.getDimension(), otraBola.getDimension()))) {
						
						otraBola.cambiarSentidoX();
						otraBola.cambiarSentidoY();
						
						if (getBola().getColor().equals(Color.BLUE)) {
							otraBola.setColor(Color.BLUE);
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

	public VentanaBolasConMouse getventanaBolasConMouse() {
		return ventanaBolasConMouse;
	}

	public void setventanaBolasConMouse(VentanaBolasConMouse ventanaBolasConMouse) {
		this.ventanaBolasConMouse = ventanaBolasConMouse;
	}
}
