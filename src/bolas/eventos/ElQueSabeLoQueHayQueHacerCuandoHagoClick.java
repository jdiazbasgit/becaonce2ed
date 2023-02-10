package bolas.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bolas.bolas.Bola;
import bolas.hilos.BolaHilo;
import bolas.ventanas.VentanaBolas;

public class ElQueSabeLoQueHayQueHacerCuandoHagoClick implements MouseListener {

	private VentanaBolas ventanaBolas;
	
	public ElQueSabeLoQueHayQueHacerCuandoHagoClick(VentanaBolas ventanaBolas) {
		
		this.ventanaBolas = ventanaBolas;
	}
	
	public int dameIncremento(){
		
		int valor = (int) (Math.random()*10);
		if (valor%2==0)
			return 1;
		return 2;
		
	}
	
	
public int dameSentido(){
		
		int valor = (int) (Math.random()*10);
		if (valor%2==0)
			return 1;
		return -1;
		
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {

		Bola bola = new Bola (e.getX(), e.getY(),dameIncremento(), dameIncremento(), dameSentido(), dameSentido(), 40);
		BolaHilo bolahilo = new BolaHilo(bola,getVentanaBolas());
		bolahilo.start();
		getVentanaBolas().getBolas().add(bola);
	}

	public VentanaBolas getVentanaBolas() {
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
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

}
