package bolas.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

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
		Bola bola = new Bola(e.getX(), e.getY(), generarIncremento(), generarIncremento(), generarOrientacion(), generarOrientacion(), generarDimension());
		this.vbr.getBolas().add(bola);
		BolaHiloRaton bolaHiloRaton = new BolaHiloRaton(bola, getVbr());
		bolaHiloRaton.start();
	}

	public int generarIncremento() {
		// Generar los tres numeros: 1, 2 y 3
		Random random = new Random();
	    int incremento = random.nextInt(2) + 1;
		return incremento;
	}
	
	public int generarOrientacion() {
		// Generar los cuatro numeros: -2, -1, 1 y 2
		Random random = new Random();
		int orientacion = random.nextInt(5) - 2;
		if (orientacion == 0) {
			return orientacion + 1;
		} else {
			return orientacion;
		}
	}

	public int generarDimension() {
		// Generar los cinco numeros: 20, 40, 60, 80 y 100
		Random random = new Random();
	    int dimension = (random.nextInt(4) + 1) * 20;
		return dimension;
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
