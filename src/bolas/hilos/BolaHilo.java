package bolas.hilos;

import java.awt.Rectangle;
import java.util.List;

import bolas.bolas.Bola;
import bolas.ventanas.VentanaBolas;

public class BolaHilo extends Thread {

	private Bola bola;
	private VentanaBolas ventanaBolas;
	private List<Bola> bolas;

	public BolaHilo(Bola bola, VentanaBolas ventanaBolas) {
		this.bola = bola;
		this.ventanaBolas = ventanaBolas;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (getBola().getPosicionX() < 0
					|| getBola().getPosicionX() > getVentanaBolas().getWidth() - getBola().getDimension()) {
				getBola().setSentidoX(getBola().getSentidoX() * -1);
			}
			if (getBola().getPosicionY() < 0
					|| getBola().getPosicionY() > getVentanaBolas().getHeight() - getBola().getDimension()) {
				getBola().setSentidoY(getBola().getSentidoY() * -1);
			}
			getBola().calcularPosicion();
			setBolas(ventanaBolas.getBolas());
			for (Bola bolaQueCompruebo : getBolas()) {
				for (Bola otraBola : getBolas()) {
					if (bolaQueCompruebo.equals(otraBola))
						continue;
			          Rectangle bolaQueComprueboRect = new Rectangle(bolaQueCompruebo.getPosicionX(),bolaQueCompruebo.getPosicionY(), bolaQueCompruebo.getDimension(), bolaQueCompruebo.getDimension());
			          Rectangle otraBolaRect = new Rectangle(otraBola.getPosicionX(),otraBola.getPosicionY(), otraBola.getDimension(), otraBola.getDimension());
			          if (bolaQueComprueboRect.intersects(otraBolaRect)) {
			        	  bolaQueCompruebo.setSentidoX(bolaQueCompruebo.getSentidoX()*-1);
			        	  bolaQueCompruebo.setSentidoY(bolaQueCompruebo.getSentidoY()*-1);
			        	  otraBola.setSentidoX(otraBola.getSentidoX()*-1);
			        	  otraBola.setSentidoY(otraBola.getSentidoY()*-1);
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

	public VentanaBolas getVentanaBolas() {
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

	public List<Bola> getBolas() {
		return bolas;
	}

	public void setBolas(List<Bola> bolas) {
		this.bolas = bolas;
	}

}
