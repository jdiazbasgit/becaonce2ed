package bolas.hilos;


import java.awt.Component;

import bolas.ventanas.VentanaPelota;

public class Pintor extends Thread {
	
	private VentanaPelota ventanaPelota;
	
	public Pintor(VentanaPelota ventanaPelota) {
		this.ventanaPelota = ventanaPelota;
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
								e.printStackTrace();
			}
			getVentanaPelota().repaint();
		}
		
	}

	

	

	private Component getVentanaPelota() {
		// TODO Auto-generated method stub
		return null;
	}


	public VentanaPelota getVentanaBolas() {
		return ventanaPelota;
	}

	public void setVentanaBolas(VentanaPelota ventanaBolas) {
		this.ventanaPelota = ventanaBolas;
	}

}
