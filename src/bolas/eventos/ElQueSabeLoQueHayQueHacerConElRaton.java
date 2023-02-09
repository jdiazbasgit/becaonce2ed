package bolas.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bolas.bolas.Bola;
import bolas.hilos.BolaHiloRaton;
import bolas.ventanas.VentanaBolasRaton;

public class ElQueSabeLoQueHayQueHacerConElRaton implements MouseListener {

	private VentanaBolasRaton vbr;

	public ElQueSabeLoQueHayQueHacerConElRaton(VentanaBolasRaton vbr) {
		this.vbr = vbr;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Bola bola = new Bola(e.getX(), e.getY(), 1, 1, -1, 1, 25);
		this.vbr.getBolas().add(bola);
		BolaHiloRaton bolaHiloRaton = new BolaHiloRaton(bola, getVbr());
		bolaHiloRaton.start();
	}

	public int generarIncremento() {
		Random random = new Random();
	    int resultado = random.nextInt(20) + 1;
		return resultado;
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

	public VentanaBolasRaton getVbr() {
		return vbr;
	}

	public void setVbr(VentanaBolasRaton vbr) {
		this.vbr = vbr;
	}

}
