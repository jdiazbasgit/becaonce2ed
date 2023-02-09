package bolas.eventos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import bolas.bolas.Bola;
import bolas.hilos.BolaHilo;
import bolas.ventanas.VentanaBolas;

public class ElQueSabeLoQueHayQueHacerConElRaton implements MouseListener {

	private VentanaBolas ventanaBolas;

	public ElQueSabeLoQueHayQueHacerConElRaton(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

	public int generarRandom1o2() {
		Random random = new Random();
	    int resultado = random.nextInt(20) + 1;
		return resultado;
	}
	public int generarRandomPosNeg() {
		Random random = new Random();
	    int resultado = random.nextInt(2) + 1;
	    if (resultado == 1) {
	    	return -1;
	    }
	    else {
	    	return 1;
	    }
	}
	public Color generarColorAleatorio() {
        Random random = new Random();
        Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());        
        return color;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getPoint());

		Bola bola = new Bola(e.getPoint().x, e.getPoint().y, generarRandom1o2(), generarRandom1o2(),generarRandomPosNeg(),generarRandomPosNeg(), 50, generarColorAleatorio());
		System.out.println(generarRandom1o2());
		//getVentanaBolas().getExterno().setColor(bola.getColor());
		this.ventanaBolas.getBolas().add(bola);
		BolaHilo bolaHilo = new BolaHilo(bola, getVentanaBolas());
		bolaHilo.start();		
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

	public VentanaBolas getVentanaBolas() {
		return ventanaBolas;
	}

	public void setVentanaBolas(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

}