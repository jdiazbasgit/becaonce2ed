package bolas.testCursorEjm;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

import bolas.testCursorEjm.ElQueSabe;

public class Cursor extends JFrame{
	
	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	private int posicionX, posicionY;
	
	public Cursor() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPrimeraVez(true);
		this.addMouseMotionListener(new ElQueSabe(this));
	}
	
	
	@Override
	public void paint(Graphics g) {
		if(isPrimeraVez()) {
			setImagen(createImage(getWidth(),getHeight()));
			setExterno(getImagen().getGraphics());
			getExterno().setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			setPrimeraVez(false);
		}
		
		//getExterno().clearRect(0, 0, getWidth(), getHeight());
		getExterno().drawString("("+getPosicionX()+" - "+getPosicionY()+")", getPosicionX(), getPosicionY());
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


	public int getPosicionX() {
		return posicionX;
	}


	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}


	public int getPosicionY() {
		return posicionY;
	}


	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

}