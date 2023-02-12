package pelotas.ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import pelotas.pelotas.Pelota;
import pelotas.eventos.ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento;
import pelotas.hilos.PelotaHilo;
import pelotas.hilos.Pintor;

@SuppressWarnings({ "serial", "unused" })
public class VentanaPelotas  extends JFrame {
	
	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	private Set<Pelota> pelotas;
	
	private int rebotes = 0;
	
	private final int rebotesMaximos = 5;

	
	public VentanaPelotas() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPrimeraVez(true);
		setPelotas(new HashSet<>());
		this.addMouseListener(new ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento(this));
	}

	/*
	 * Bola bola = new Bola(100, 100, 1, 1, -1, 1, 50);
	 * 
	 * getBolas().add(bola);
	 * 
	 * 
	 * BolaHilo bolaHilo = new BolaHilo(bola, this);
	 * 
	 * bolaHilo.start();
	 */

	public void paint(Graphics g) {
		if (isPrimeraVez()) {
			setImagen(createImage(this.getWidth(), this.getHeight()));
			setExterno(getImagen().getGraphics());
			Pintor pintor = new Pintor(this);
			pintor.start();
			setPrimeraVez(false);
		}

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getExterno().clearRect(0, 0, this.getWidth(), this.getHeight());
		getExterno().drawString(String.valueOf(getPelotas().size()), 50, 50);

		for (Pelota pelota : getPelotas()) {

			getExterno().fillOval(pelota.getPosicionX(), pelota.getPosicionY(), pelota.getDimension(), pelota.getDimension());
		}
		g.drawImage(getImagen(), 0, 0, this);
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public Graphics getExterno() {
		return externo;
	}

	public void setExterno(Graphics externo) {
		this.externo = externo;
	}

	public boolean isPrimeraVez() {
		return primeraVez;
	}

	public void setPrimeraVez(boolean primeraVez) {
		this.primeraVez = primeraVez;
	}

	public Set<Pelota> getPelotas() {
		return pelotas;
	}

	public void setPelotas(Set<Pelota> pelotas) {
		this.pelotas = pelotas;
	}

	

}
