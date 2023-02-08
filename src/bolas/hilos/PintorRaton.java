package bolas.hilos;

import bolas.ventanas.VentanaBolasRaton;

public class PintorRaton extends Thread {

	private VentanaBolasRaton ventanaBolasRaton;

	public PintorRaton(VentanaBolasRaton ventanaBolasRaton) {
		this.ventanaBolasRaton = ventanaBolasRaton;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getVentanaBolasRaton().repaint();
		}

	}

	public VentanaBolasRaton getVentanaBolasRaton() {
		return ventanaBolasRaton;
	}

	public void setVentanaBolasRaton(VentanaBolasRaton ventanaBolasRaton) {
		this.ventanaBolasRaton = ventanaBolasRaton;
	}

}
