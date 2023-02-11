package bolas.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bolas.bolas.Pelota;
import bolas.hilos.PelotaHilo;
import bolas.ventanas.VentanaPelota;

public class ElRatonEnPlenoMeneo implements MouseListener {

	
	private VentanaPelota ventanaPelota;

	public ElRatonEnPlenoMeneo(VentanaPelota ventanaPelota) {
		this.ventanaPelota = ventanaPelota;

	}

	public int dameIncremento() {
		int valor = (int) (Math.random() * 10);
		if (valor % 2 == 0)
			return 1;
		return 2;

	}

	public int dameSentido() {
		int valor = (int) (Math.random() * 10);
		if (valor % 2 == 0)
			return 1;
		return -1;

	}

	public void mouseClicked(MouseEvent e) {
		Pelota pelota = new Pelota(e.getX(), e.getY(), dameIncremento(), dameIncremento(), dameSentido(), dameSentido(),
				50);
		PelotaHilo pelotaHilo = new PelotaHilo(pelota, getVentanaPelota());
		pelotaHilo.start();
		getVentanaPelota().getPelota();

	}

	public  VentanaPelota getVentanaPelota() {
		return ventanaPelota;
	}

	@SuppressWarnings("unused")
	private void  setVentanaPelota(VentanaPelota ventanaPelota) {
       this.ventanaPelota = ventanaPelota;
		
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

}