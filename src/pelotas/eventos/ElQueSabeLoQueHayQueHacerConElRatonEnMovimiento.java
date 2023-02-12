package pelotas.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import pelotas.pelotas.Pelota;
import pelotas.hilos.PelotaHilo;
import pelotas.ventanas.Cursor;
import pelotas.ventanas.VentanaPelotas;

public class ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento implements MouseListener {
	
	
	private VentanaPelotas ventanaPelotas;
	

	public ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento(VentanaPelotas ventanaPelotas) {
		this.setVentanaPelotas(ventanaPelotas);
	}

	public ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento(Cursor cursor) {
		// TODO Auto-generated constructor stub
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
		Pelota pelota = new Pelota(e.getX(), e.getY(), dameIncremento(), dameIncremento(), dameSentido(), dameSentido(), 50);
		PelotaHilo pelotaHilo = new PelotaHilo(pelota, getVentanaPelotas());
		pelotaHilo.start();
		getVentanaPelotas().getPelotas().add(pelota);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public VentanaPelotas getVentanaPelotas() {
		return ventanaPelotas;
	}

	public void setVentanaPelotas(VentanaPelotas ventanaPelotas) {
		this.ventanaPelotas = ventanaPelotas;
	}


}
