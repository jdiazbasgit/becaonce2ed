package bolas.hilos;

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
			if (getBola().getPosicionX() < 0
					|| getBola().getPosicionX() > getVentanaBolasRaton().getWidth() - getBola().getDimension())
				getBola().setSentidoX(getBola().getSentidoX() * -1);

			if (getBola().getPosicionY() < 0
					|| getBola().getPosicionY() > getVentanaBolasRaton().getHeight() - getBola().getDimension())
				getBola().setSentidoY(getBola().getSentidoY() * -1);
			getBola().calcularPosicion();
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
