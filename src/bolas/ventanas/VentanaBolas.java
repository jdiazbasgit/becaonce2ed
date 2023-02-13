package bolas.ventanas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import bolas.bolas.Bola;
import bolas.hilos.BolaHilo;
import bolas.hilos.Pintor;

public class VentanaBolas extends JFrame implements MouseListener  {
	private static final long serialVersionUID = 1L;
	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	private List<Bola> bolas;
	
	public VentanaBolas() {
		addMouseListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1200,800);
		setPrimeraVez(true);
		setBolas(new ArrayList<>());
	}

	@Override
	public void paint(Graphics g) {
		if (isPrimeraVez()) {
			setImagen(createImage(this.getWidth(), this.getHeight()));
			setExterno(getImagen().getGraphics());
			int dx = (int)(5*Math.random());
			int dy = (int)(5*Math.random());
			Bola bola = new Bola(100, 100, 1, 1, dx, dy, 100);
			getBolas().add(bola);
			BolaHilo bolaHilo = new BolaHilo(bola, this);
			bolaHilo.start();
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
			getExterno().drawOval(bola.getPosicionX(), bola.getPosicionY(), bola.getDimension(), bola.getDimension());
			getExterno().setFont(getExterno().getFont().deriveFont(30f));
			getExterno().drawString(String.valueOf(bolas.size()),bola.getPosicionX()+((bola.getDimension()-35) / 2), bola.getPosicionY()+((bola.getDimension()+10) / 2));
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
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int length = bolas.size();
		
		if (length <= 5) {
			int radius = 100; //(int)(100*Math.random());
			int dx = (int)(5*Math.random());
			int dy = (int)(5*Math.random());
			
			/*int r = (int)(255 * Math.random());
			int g = (int)(255 * Math.random());
			int b = (int)(255 * Math.random());*/
					
			Bola bola = new Bola(e.getX(), e.getY(), 1, 1, dx, dy, radius);
			getBolas().add(bola);
			BolaHilo bolaHilo = new BolaHilo(bola, this);
			bolaHilo.start();
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
