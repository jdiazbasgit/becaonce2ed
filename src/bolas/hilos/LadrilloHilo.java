package bolas.hilos;

import java.awt.Color;
import java.awt.Rectangle;

import bolas.elementos.Barra;
import bolas.elementos.Bola;
import bolas.elementos.TimeTrap;
import bolas.ventanas.VentanaZonaDeJuego;

public class LadrilloHilo extends Thread {

	private Barra barra;
	private VentanaZonaDeJuego ventanaBolas;

	public LadrilloHilo(Barra barra, VentanaZonaDeJuego ventanaBolas) {
		this.setBarra(barra);
		this.ventanaBolas = ventanaBolas;
	}

	@Override
	public void run() {
		boolean matar = false;
		while (!matar) {
			try {
				Thread.sleep(1);
				// Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//ventanaBolas.getBarra().mover();

		}

	}

	public void desplazarAlChocar(Bola bola) {
		bola.calcularPosicion();
	}

	

	public VentanaZonaDeJuego getVentanaBolas() {
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaZonaDeJuego ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

	public Barra getBarra() {
		return barra;
	}

	public void setBarra(Barra barra) {
		this.barra = barra;
	}

	/*
	 * public List<Bola> getBolas() { return bolas; }
	 * 
	 * public void setBolas(List<Bola> bolas) { this.bolas = bolas; }
	 */

}
