package bolas.hilos;

import java.awt.Color;
import java.awt.Rectangle;

import bolas.elementos.Bola;
import bolas.elementos.TimeTrap;
import bolas.ventanas.VentanaZonaDeJuego;

public class BolaHilo extends Thread {

	private Bola bola;
	private VentanaZonaDeJuego ventanaBolas;

	public BolaHilo(Bola bola, VentanaZonaDeJuego ventanaBolas) {
		this.bola = bola;
		this.ventanaBolas = ventanaBolas;
	}

	@Override
	public void run() {
		boolean matar = false;
		while (!matar) {
			try {
				Thread.sleep((getBola().getVelocidadRalentizada() * getBola().getDimension())/100);
				// Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if ((int) Math.round(getBola().getPosicionX()) < 0
					|| (int) Math.round(getBola().getPosicionX()) > getVentanaBolas().getWidth()
							- getBola().getDimension()) {
				getBola().setSentidoX(getBola().getSentidoX() * -1);
			}
			if ((int) Math.round(getBola().getPosicionY()) < 0
					|| (int) Math.round(getBola().getPosicionY()) > getVentanaBolas().getHeight()
							- getBola().getDimension()) {
				getBola().setSentidoY(getBola().getSentidoY() * -1);
			}
			getBola().calcularPosicion();
			Bola bolaQueCompruebo = this.bola;
			// ventanaBolas.getBolasTemporal().addAll(ventanaBolas.getBolas());
			// ventanaBolas.getTimeTrapsTemporal().addAll(ventanaBolas.getTimeTraps());
			for (int i = 0; i < ventanaBolas.getBolas().size(); i++) {
				Bola otraBola = ventanaBolas.getBolas().get(i);
				
				Rectangle bolaQueComprueboRect = new Rectangle((int) Math.round(bolaQueCompruebo.getPosicionX()),
						(int) Math.round(bolaQueCompruebo.getPosicionY()), bolaQueCompruebo.getDimension(),
						bolaQueCompruebo.getDimension());
				Rectangle otraBolaRect = new Rectangle((int) Math.round(otraBola.getPosicionX()),
						(int) Math.round(otraBola.getPosicionY()), otraBola.getDimension(), otraBola.getDimension());

				
				
				

				for (int j = 0; j < ventanaBolas.getTimeTraps().size(); j++) {
					TimeTrap timeTrap = ventanaBolas.getTimeTraps().get(j);
					Rectangle timeTrapRect = new Rectangle(timeTrap.getPosicionX(), timeTrap.getPosicionY(),
							timeTrap.getDimension(), timeTrap.getDimension());
					if (bolaQueComprueboRect.intersects(timeTrapRect)) {
						bolaQueCompruebo.setVelocidadRalentizada(bolaQueCompruebo.getVelocidadThread() * 10);
						if (bolaQueCompruebo.getColor().getRed() >= 1) {
							Color colorRestRojo = new Color(bolaQueCompruebo.getColor().getRed() - 1,
									bolaQueCompruebo.getColor().getGreen(), bolaQueCompruebo.getColor().getBlue());
							bolaQueCompruebo.setColor(colorRestRojo);
						}
						if (bolaQueCompruebo.getColor().getBlue() >= 1) {
							Color colorRestBlue = new Color(bolaQueCompruebo.getColor().getRed(),
									bolaQueCompruebo.getColor().getGreen(), bolaQueCompruebo.getColor().getBlue() - 1);
							bolaQueCompruebo.setColor(colorRestBlue);
						}
						if (bolaQueCompruebo.getColor().getGreen() < 255) {
							Color colorRestGreen = new Color(bolaQueCompruebo.getColor().getRed(),
									bolaQueCompruebo.getColor().getGreen() + 1, bolaQueCompruebo.getColor().getBlue());
							bolaQueCompruebo.setColor(colorRestGreen);
						}
					} else {
						boolean noToca = true;
						for (int k = 0; k < ventanaBolas.getTimeTraps().size(); k++) {
							TimeTrap otraTimeTrap = ventanaBolas.getTimeTraps().get(k);
							Rectangle otraTimeTrapRect = new Rectangle(otraTimeTrap.getPosicionX(),
									otraTimeTrap.getPosicionY(), otraTimeTrap.getDimension(),
									otraTimeTrap.getDimension());
							if (!(bolaQueComprueboRect.intersects(otraTimeTrapRect)))
								continue;
							else {
								noToca = false;
								break;
							}
						}
						/*
						 * for (TimeTrap otraTimeTrap : ventanaBolas.getTimeTraps()) { }
						 */
						if (noToca) {
							bolaQueCompruebo.setVelocidadRalentizada(bolaQueCompruebo.getVelocidadThread());
						}

					}
				}
				/*
				 * for (TimeTrap timeTrap : ventanaBolas.getTimeTraps()) {
				 * 
				 * }
				 */

				if (bolaQueCompruebo.equals(otraBola))
					continue;

				if (bolaQueComprueboRect.intersects(otraBolaRect)) {
					bolaQueCompruebo.setSentidoX(bolaQueCompruebo.getSentidoX() * -1);
					bolaQueCompruebo.setSentidoY(bolaQueCompruebo.getSentidoY() * -1);
					//otraBola.setSentidoX(otraBola.getSentidoX() * -1);
					//otraBola.setSentidoY(otraBola.getSentidoY() * -1);
					otraBola.setImpactos(bolaQueCompruebo.getImpactos()+1);
					// while (bolaQueComprueboRect.intersects(otraBolaRect))
					// this.desplazarAlChocar(bolaQueCompruebo);
					// elBolero.desplazarAlChocar(otraBola);
					getBola().calcularPosicion();
					bolaQueCompruebo.setImpactos(bolaQueCompruebo.getImpactos()+1);
					//bolaQueCompruebo.setDimension(bolaQueCompruebo.getDimension()-5);
					
					// ventanaBolas.getBolas().set(i, otraBola);
				}

				/*
				 * for (Bola otraBola : ventanaBolas.getBolas()) {
				 * 
				 * }
				 */
				if (bolaQueCompruebo.getImpactos() >= 40) {
					matar = true;
				}

			}
			
		}
	}

	public void desplazarAlChocar(Bola bola) {
		bola.calcularPosicion();
	}

	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
	}

	public VentanaZonaDeJuego getVentanaBolas() {
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaZonaDeJuego ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

	/*
	 * public List<Bola> getBolas() { return bolas; }
	 * 
	 * public void setBolas(List<Bola> bolas) { this.bolas = bolas; }
	 */

}
