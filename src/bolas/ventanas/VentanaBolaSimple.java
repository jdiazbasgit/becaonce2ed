package bolas.ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

import bolas.bolas.Bola;

public class VentanaBolaSimple extends JFrame {

	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	private Bola bola;

	public VentanaBolaSimple() {
		// setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPrimeraVez(true);
	}

	@Override
	public void paint(Graphics g) {

		if (isPrimeraVez()) {

			setImagen(createImage(this.getWidth(), this.getHeight()));
			setExterno(getImagen().getGraphics());
			setBola(new Bola(100, 100, 1, 1, 1, -1, 50));
			setPrimeraVez(false);

		}

		g.setColor(Color.YELLOW);
		g.fillRect(100, 100, 100, 100);
		g.setColor(Color.RED);
		g.drawOval(250, 100, 100, 100);
		int[] x = { 50, 100, 150 };
		int[] y = { 80, 300, 250 };
		g.drawPolygon(x, y, 3);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i <= this.getWidth(); i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			g.fillOval(i, 100, bola.getDimension(), bola.getDimension());
			g.drawImage(getImagen(), 0, 0, this);
		}
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

	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
	}

}
