package bolas.eventos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import bolas.elementos.Bola;
import bolas.elementos.TimeTrap;
import bolas.hilos.BolaHilo;
import bolas.ventanas.VentanaBolas;

public class ElQueSabeLoQueHayQueHacerConElRaton implements MouseListener {

	private VentanaBolas ventanaBolas;

	public ElQueSabeLoQueHayQueHacerConElRaton(VentanaBolas ventanaBolas) {
		this.ventanaBolas = ventanaBolas;
	}

	public int generarRandom1o2(int i) {
		Random random = new Random();
		int resultado = random.nextInt(i) + 1;
		return resultado;
	}

	public int generarRandomPosNeg() {
		Random random = new Random();
		int resultado = random.nextInt(2) + 1;
		if (resultado == 1) {
			return -1;
		}
		return 1;
	}

	public Color generarColorAleatorio() {
		Random random = new Random();
		Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
		return color;
	}
	public int cualEsMayor(int a, int b) {
	    if (a > b) {
	        return a;
	    }
	    return b;
	}
	public int calcularVelocidad(int incrX, int incrY) {
		int maxIncrEnUso = cualEsMayor(incrX, incrY);
		return maxIncrEnUso*2;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(e.getPoint());
		//System.out.println(e);
		int incrX = generarRandom1o2(16);
		int incrY = generarRandom1o2(16);
		int velocidad = calcularVelocidad(incrX, incrY)/4;
		int velocidadRalentizada = velocidad;
		int dimensionBola = 30;
		int dimensionTrap = 20;
		int impactos = 0;
		if (e.getButton() == 1) {
			Bola bola = new Bola((e.getPoint().x)-(dimensionBola/2), (e.getPoint().y)-(dimensionBola/2), incrX, incrY,
					generarRandomPosNeg(), generarRandomPosNeg(), dimensionBola, generarColorAleatorio(), velocidad, velocidadRalentizada, impactos);
			//System.out.println(generarRandom1o2());
			// getVentanaBolas().getExterno().setColor(bola.getColor());
			this.ventanaBolas.getBolas().add(bola);
			BolaHilo bolaHilo = new BolaHilo(bola, getVentanaBolas());
			bolaHilo.start();
		}
		if (e.getButton() == 3) {
			TimeTrap timeTrap = new TimeTrap((e.getPoint().x)-(dimensionTrap/2), (e.getPoint().y)-(dimensionTrap/2),dimensionTrap);
			this.ventanaBolas.getTimeTraps().add(timeTrap);
			//BolaHilo bolaHilo = new BolaHilo(bola, getVentanaBolas());
			//bolaHilo.start();
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