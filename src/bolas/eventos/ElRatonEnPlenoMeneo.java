package bolas.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import bolas.ventanas.VentanaPelota;


public class ElRatonEnPlenoMeneo implements MouseMotionListener {

	

	private VentanaPelota ventanaPelota;

	public ElRatonEnPlenoMeneo(VentanaPelota ventanaPelota) {
		this.ventanaPelota = ventanaPelota;
	}

	/*
	 * public void mouseDragged(MouseEvent e) { if (e.getModifiersEx() == 1024)
	 * getCursor().getExterno().setColor(Color.YELLOW); if (e.getModifiersEx() ==
	 * 4096) getCursor().getExterno().setColor(Color.BLACK); colocarCursor(e); }
	 * 
	 * public void mouseMoved(MouseEvent e) {
	 * getCursor().getExterno().setColor(Color.CYAN); colocarCursor(e);
	 * 
	 * }
	 * 
	 * private void colocarCursor(MouseEvent e) {
	 * getCursor().setPosicionX(e.getX()); getCursor().setPosicionY(e.getY());
	 * getCursor().repaint(); }
	 */
	public int dameIncremento() {
		int valor = (int) (Math.random() * 20);
		if (valor % 2 == 0)
			return 1;
		return 2;

	}

	@SuppressWarnings("unused")
	public int dameSentido() {
		int valor = (int) (Math.random() * 20);
		if (valor % 2 == 0)
			
		return 1;
		return -1;

	}

	public VentanaPelota getVentanaPelota() {
		return ventanaPelota;
	}

	public void setVentanaPelota(VentanaPelota ventanaPelota, VentanaPelota ventanaPelota1) {
		this.ventanaPelota = ventanaPelota1;
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		

	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	

}