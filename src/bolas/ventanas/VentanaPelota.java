package bolas.ventanas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import bolas.bolas.Pelota;
import bolas.eventos.ElRatonEnPlenoMeneo;
import bolas.hilos.Pintor;

@SuppressWarnings("serial")
public class VentanaPelota extends JFrame {

	private Image image;
	private Graphics externo;
	private boolean primeravez;
	private List<Pelota> pelota;
	private Image imagen;

	public VentanaPelota() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPrimeraVez(true);
		setPelota(new ArrayList<>());
		this.addMouseListener(new ElRatonEnPlenoMeneo(this));
	}

	private void setPelota(ArrayList arrayList) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	public void paint(Graphics g) {
		if (isPrimeraVez()) {
			setImagen(createImage(this.getWidth(), this.getHeight()));
			setExterno(getImagen().getGraphics());
			Pintor pintor = Pintor(this);
			pintor.start();
			setPrimeraVez(false);
		}
		try {
		Thread.sleep(5);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		getExterno().clearRect(0, 0, this.getWidth(), this.getHeight());
		for (Pelota pelota : getPelota()) {
			getExterno().fillOval(pelota.getPosicionX(), pelota.getPosicionY(), pelota.getDimension(), pelota.getDimension());
		}
		g.drawImage(getImagen(), 0, 0, this);
	}
	private Pintor Pintor(VentanaPelota ventanaPelota) {
		// TODO Auto-generated method stub
		return null;
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
		return primeravez;
	}

	public void setPrimeraVez(boolean primeraVez) {
		this.primeravez = primeraVez;
	}

	/*
	 * public Bola getBola() { return bola; }
	 * 
	 * public void setBola(Bola bola) { this.bola = bola; }
	 */

	public List<Pelota> getPelota() {
		return pelota;
	}

	public void setBolas(List<Pelota> pelota) {
		this.pelota = pelota;
	}

	
}