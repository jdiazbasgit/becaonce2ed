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
			
			Rectangle yoRectangle = new Rectangle(getBola().getPosicionX(), getBola().getPosicionY(), getBola().getDimension(), getBola().getDimension());
			
			int i = 2;

			try {
				for (Bola otraBola : ventanaBolasRaton.getBolas()) {

					if (!getBola().equals(otraBola) || otraBola.equals(null)) {

						Rectangle otroRectangle = new Rectangle(otraBola.getPosicionX(), otraBola.getPosicionY(),
								otraBola.getDimension(), otraBola.getDimension());

						switch (i) {

						case 1: // Caso 1: Variable isIntersectado es intentar que lo cambien los sentidos una vez

							if (yoRectangle.intersects(otroRectangle) && !getBola().isIntersectado()) {

								getBola().setIntersectado(true);

								getBola().cambiarSentidoX();
								getBola().cambiarSentidoY();

								if (otraBola.getColor().equals(Color.RED)) {
									getBola().setColor(Color.RED);
								}

							} else {

								if (!yoRectangle.intersects(otroRectangle)) {
									getBola().setIntersectado(false);
								}

							}

							break;

						case 2: // Caso 2: 

							if (yoRectangle.intersects(otroRectangle)) {

								getBola().cambiarSentidoX();
								getBola().cambiarSentidoY();

								if (otraBola.getColor().equals(Color.RED)) {
									getBola().setColor(Color.RED);
								}

								getBola().setNumImpacto(getBola().getNumImpacto() - 1);

								if (getBola().getNumImpacto() == 0) {
									ventanaBolasRaton.getBolas().remove(getBola());
									break;
								}

							}

							break;

						default:

							System.out.println("No exise el menu " + i);
						
						}
					}
				}
			} catch (Exception e) {
				ventanaBolasRaton.getBolas().remove(getBola());
				e.printStackTrace();
				break;
			}

			getBola().calcularPosicion();
			
			if (i == 2) {
				if (getBola().getNumImpacto() == 0) {
					ventanaBolasRaton.getBolas().remove(getBola());
					break;
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
