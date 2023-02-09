package bolas.hilos;

import java.awt.Rectangle;

import bolas.elementos.Bola;
import bolas.ventanas.VentanaBolas;

public class BolaHilo extends Thread {

	private Bola bola;
	private VentanaBolas ventanaBolas;

	public BolaHilo(Bola bola, VentanaBolas ventanaBolas) {
		this.bola = bola;
		this.ventanaBolas = ventanaBolas;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if ((int) Math.round(getBola().getPosicionX()) < 0
					|| (int) Math.round(getBola().getPosicionX()) > getVentanaBolas().getWidth() - getBola().getDimension()) {
				getBola().setSentidoX(getBola().getSentidoX() * -1);
			}
			if ((int) Math.round(getBola().getPosicionY()) < 0
					|| (int) Math.round(getBola().getPosicionY()) > getVentanaBolas().getHeight() - getBola().getDimension()) {
				getBola().setSentidoY(getBola().getSentidoY() * -1);
			}
			getBola().calcularPosicion();
			// setBolas(ventanaBolas.getBolas());
			// for (Bola bolaQueCompruebo : ventanaBolas.getBolas()) {
			Bola bolaQueCompruebo = this.bola;
			for (Bola otraBola : ventanaBolas.getBolas()) {
				if (bolaQueCompruebo.equals(otraBola))	
					continue;
				Rectangle bolaQueComprueboRect = new Rectangle((int) Math.round(bolaQueCompruebo.getPosicionX()),
						(int) Math.round(bolaQueCompruebo.getPosicionY()), bolaQueCompruebo.getDimension(),
						bolaQueCompruebo.getDimension());
				Rectangle otraBolaRect = new Rectangle((int) Math.round(otraBola.getPosicionX()), (int) Math.round(otraBola.getPosicionY()),
						otraBola.getDimension(), otraBola.getDimension());
				if (bolaQueComprueboRect.intersects(otraBolaRect)) {
					bolaQueCompruebo.setSentidoX(bolaQueCompruebo.getSentidoX() * -1);
					bolaQueCompruebo.setSentidoY(bolaQueCompruebo.getSentidoY() * -1);
					//otraBola.setSentidoX(otraBola.getSentidoX() * -1);
					//otraBola.setSentidoY(otraBola.getSentidoY() * -1);
					//while (bolaQueComprueboRect.intersects(otraBolaRect))
					//this.desplazarAlChocar(bolaQueCompruebo);
						//elBolero.desplazarAlChocar(otraBola);
					getBola().calcularPosicion();
				}
			}
			
			// }
		}
	}

	public void desplazarAlChocar(Bola bola){
		bola.calcularPosicion();		
	}
	
	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
	}

	public VentanaBolas getVentanaBolas() {
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

	/*
	 * public List<Bola> getBolas() { return bolas; }
	 * 
	 * public void setBolas(List<Bola> bolas) { this.bolas = bolas; }
	 */

}
