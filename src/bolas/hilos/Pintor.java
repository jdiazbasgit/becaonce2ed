package bolas.hilos;

import bolas.ventanas.VentanaBolas;

public class Pintor extends Thread {
	
	private VentanaBolas ventanaBolas;
	
	public Pintor(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getVentanaBolas().repaint();
		}
	}

	public VentanaBolas getVentanaBolas() {
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

}
