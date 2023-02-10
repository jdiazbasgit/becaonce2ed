package bolas.ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import bolas.bolas.Bola;
import bolas.eventos.CrearBolaConUnClick;
import bolas.hilos.BolaHilo;
import bolas.hilos.Pintor;

public class VentanaBolas extends JFrame {

	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	// private Bola bola;
	private List<Bola> bolas;

	

	public VentanaBolas() {
		// setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPrimeraVez(true);
		setBolas(new ArrayList<>());
		this.addMouseListener(new CrearBolaConUnClick(this));
	}

	@Override
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
		for (Bola bola : getBolas()) {
			getExterno().fillOval(bola.getPosicionX(), bola.getPosicionY(), bola.getDimension(), bola.getDimension());
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

	/*
	 * public Bola getBola() { return bola; }
	 * 
	 * public void setBola(Bola bola) { this.bola = bola; }
	 */

	public List<Bola> getBolas() {
		return bolas;
	}

	public void setBolas(List<Bola> bolas) {
		this.bolas = bolas;
	}

}