package bolas.eventos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import bolas.elementos.Bola;
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
		} else {
			return 1;
		}
	}

	public Color generarColorAleatorio() {
		Random random = new Random();
		Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
		return color;
	}
	
	public int calcularVelocidad(int incrX, int incrY) {
				//TODO Utilizar este dato donde a más incremento = mayor sleep para sincronizar velocidades
		return 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(e.getPoint());
		//System.out.println(e);
		int incrX = generarRandom1o2();
		int incrY = generarRandom1o2();
		int velocidad = calcularVelocidad(incrX, incrY);
		int dimension = 40;
		if (e.getButton() == 1) {
			Bola bola = new Bola((e.getPoint().x)-(dimension/2), (e.getPoint().y)-(dimension/2), incrX, incrY,
					generarRandomPosNeg(), generarRandomPosNeg(), dimension, generarColorAleatorio(), velocidad);
			System.out.println(generarRandom1o2());
			// getVentanaBolas().getExterno().setColor(bola.getColor());
			this.ventanaBolas.getBolas().add(bola);
			BolaHilo bolaHilo = new BolaHilo(bola, getVentanaBolas());
			bolaHilo.start();
		}
		if (e.getButton() == 3) {
			Bola bola = new Bola(e.getPoint().x, e.getPoint().y, generarRandom1o2(), generarRandom1o2(),
					generarRandomPosNeg(), generarRandomPosNeg(), 50, generarColorAleatorio(), velocidad);
			System.out.println(generarRandom1o2());
			// getVentanaBolas().getExterno().setColor(bola.getColor());
			this.ventanaBolas.getBolas().add(bola);
			BolaHilo bolaHilo = new BolaHilo(bola, getVentanaBolas());
			bolaHilo.start();
		}
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