package bolas.ventanas;

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

import bolas.bolas.Pelota;
import bolas.eventos.ElRatonEnPlenoMeneo;
import bolas.hilos.PelotaHilo;
import bolas.hilos.Pintor;

@SuppressWarnings({ "unused", "serial" })
public class VentanaPelota extends JFrame {

	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	private Set<Pelota> bolas;
	private int rebotes = 2;
	private final int rebotesMaximos = 6;
	private Set<Pelota> pelota;

	public VentanaPelota() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPrimeraVez(true);
		setPelota(new HashSet<>(), pelota);
		this.addMouseListener(new ElRatonEnPlenoMeneo(this));
	}
	
	

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
		getExterno().drawString(String.valueOf(getPelota().size()), 50, 50);

		for (Pelota pelota : getPelota()) {

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

	public Set<Pelota> getPelota() {
		return pelota;
	}

	public void setPelota(Set<Pelota> Pelota, Set<Pelota> pelota) {
		this.pelota = pelota;
	}



	public void remove(Pelota pelota2) {
		// TODO Auto-generated method stub
		
	}

}