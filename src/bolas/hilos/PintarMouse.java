package bolas.hilos;

import bolas.ventanas.VentanaBolasConMouse;

public class PintarMouse extends Thread{
	private VentanaBolasConMouse  ventanaBolasConMouse;

	public PintarMouse(VentanaBolasConMouse ventanaBolasConMouse) {
		this.ventanaBolasConMouse = ventanaBolasConMouse;
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
			getVentanaBolasConMouse().repaint();
		}

	}

	public VentanaBolasConMouse getVentanaBolasConMouse() {
		return ventanaBolasConMouse;
	}

	public void setVentanaBolasConMouse(VentanaBolasConMouse ventanaBolasConMouse) {
		this.ventanaBolasConMouse = ventanaBolasConMouse;
	}

}
