package bolas.eventos;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bolas.bolas.Bola;
import bolas.hilos.BolaHilo;
import bolas.ventanas.VentanaBolas;


public class ElQueSabeLoQueHayQueHacerConElRatonCuandoPulso implements MouseListener {
	
	private VentanaBolas ventanaBolas;
	
	public ElQueSabeLoQueHayQueHacerConElRatonCuandoPulso(VentanaBolas ventanaBolas) {
			this.ventanaBolas = ventanaBolas;
		
	}
	
	public int dameIncremento1() {
		int valor = (int) (Math.random()*10);
		if (valor % 2 == 0)
			return 1;
		return 2;
	}
	
	public int dameIncremento() {
		int valor = (int) (Math.random()*10);
		if (valor % 2 == 0)
			return 1;
		return -1;
		
	}

 
	@Override
	public void mouseClicked(MouseEvent e) {
		Bola bola = new Bola(e.getX(), e.getY(), dameIncremento(), dameIncremento(), dameSentido(), dameSentido(), 50);
		BolaHilo bolaHilo = new BolaHilo(bola, getVentanaBolas());
		bolaHilo.start();
		getVentanaBolas().getBolas().add(bola);
		
	
	}
	
	private int dameSentido() {
		// TODO Auto-generated method stub
		return 0;
	}

	public VentanaBolas getVentanaBolas() {
		return ventanaBolas;
	}


	public void setVentanaBolas(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}
	
	
	/*
	 * private int dameSentido() { // TODO Auto-generated method stub return 0; }
	 */
	@Override
	
	
	/*
	 * public void mousePressed(MouseEvent e) { getCursor().setPosicionX(e.getX());
	 * getCursor().setPosicionY(e.getY()); ((Component) getCursor()).repaint();
	 * 
	 * }
	 */

	/*
	 * private Object getCursor() { return null;
	
	}*/

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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


