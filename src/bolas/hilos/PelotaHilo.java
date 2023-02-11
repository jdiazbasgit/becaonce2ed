package bolas.hilos;

import java.awt.Rectangle;


import bolas.bolas.Pelota;
import bolas.ventanas.VentanaPelota;

public class PelotaHilo extends Thread {

	private Pelota pelota;
	private VentanaPelota ventanaPelota;
	private final int rebotesMaximos = 111;

	public PelotaHilo(Pelota pelota, VentanaPelota ventanaPelota) {
		this.pelota = pelota;
		this.ventanaPelota = ventanaPelota;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			if (getPelota().getPosicionX() < 0
					|| getPelota().getPosicionX() > getVentanaPelota().getWidth() - getPelota().getDimension())
				getPelota().setSentidoX(getPelota().getSentidoX() * -1);

			if (getPelota().getPosicionY() < 0
					|| getPelota().getPosicionY() > getVentanaPelota().getHeight() - getPelota().getDimension())
				getPelota().setSentidoY(getPelota().getSentidoY() * -1);
try {
			for (Pelota otra : getVentanaPelota().getPelota()) {
				if (!getPelota().equals(otra)) {
					Rectangle yo = new Rectangle(getPelota().getPosicionX(), getPelota().getPosicionY(),
							getPelota().getDimension(), getPelota().getDimension());
					Rectangle otro = new Rectangle(otra.getPosicionX(), otra.getPosicionY(), otra.getDimension(),
							otra.getDimension());
					if (yo.intersects(otro)) {
						getPelota().setSentidoX(getPelota().getSentidoX() * -1);
						getPelota().setSentidoY(getPelota().getSentidoY() * -1);
						getPelota().setImpactos(getPelota().getImpactos() + 1);
					}
				}

			}

			//getPelota().cacularPosicion();

		}
	

	catch(

	Exception e)
	{
		getVentanaPelota().remove(getPelota());
		break;

	}

        getPelota().cacularPosicion();
       if (getPelota().getImpactos()>rebotesMaximos) {
	     getVentanaPelota().getPelota().remove(getPelota());
	break;
       }	
}
	}
	

	public Pelota getPelota() {
		return pelota;
	}

	public void setPelota(Pelota pelota) {
		this.pelota = pelota;
	}

	public VentanaPelota getVentanaPelota() {
		return ventanaPelota;
	}

	public void setVentanaPelotas(VentanaPelota ventanaPelota) {
		this.ventanaPelota = ventanaPelota;
	}

}
