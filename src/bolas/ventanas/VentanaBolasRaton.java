package bolas.ventanas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import bolas.bolas.Bola;
import bolas.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
import bolas.hilos.PintorRaton;

public class VentanaBolasRaton extends JFrame {

	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	private List<Bola> bolas;

	public VentanaBolasRaton() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPrimeraVez(true);
		this.addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton(this));
		setBolas(new ArrayList<>());
	}

	@Override
	public void paint(Graphics g) {

		if (isPrimeraVez()) {
			
			setImagen(createImage(this.getWidth(), this.getHeight()));
			setExterno(getImagen().getGraphics());
			PintorRaton pintorRaton = new PintorRaton(this);
			pintorRaton.start();
			setPrimeraVez(false);
		}

		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		getExterno().clearRect(0, 0, this.getWidth(), this.getHeight());

		for (Bola bola : getBolas()) {
			getExterno().setColor(bola.getColor());
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

	public List<Bola> getBolas() {
		return bolas;
	}

	public void setBolas(List<Bola> bolas) {
		this.bolas = bolas;
	}

}
