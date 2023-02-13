package bolas.hilos;

import bolas.ventanas.VentanaZonaDeJuego;

public class Pintor extends Thread {
	
	private VentanaZonaDeJuego ventanaBolas;
	
	public Pintor(VentanaZonaDeJuego ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			getVentanaBolas().repaint();
		}
		
	}

	

	public VentanaZonaDeJuego getVentanaBolas() {
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaZonaDeJuego ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

}
