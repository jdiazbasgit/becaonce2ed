package bolas.ventanas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import bolas.bolas.Bola;
import bolas.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
import bolas.hilos.Pintor;

@SuppressWarnings("serial")
public class VentanaBolas extends JPanel {

	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	private List<Bola> bolas;

	public VentanaBolas() {
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBolas(new ArrayList<>());
		setPrimeraVez(true);		
		addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton(this));
	}

	
	@Override
	public void paint(Graphics g) {
		if (isPrimeraVez()) {
			setImagen(createImage(this.getWidth(), this.getHeight()));
			setExterno(getImagen().getGraphics());

			// setBola(new Bola(100, 100, 1, 1, 1, -1, 50));
			/*
			 * Bola bola = new Bola(100, 100, 1, 1, -1, 1, 25); Bola bola1 = new Bola(50,
			 * 50, 1, 1, -1, -1, 60); Bola bola2 = new Bola(80, 10, 1, 1, -1, 1, 50); Bola
			 * bola3 = new Bola(200, 300, 1, 1, 1, -1, 100); Bola bola4 = new Bola(10, 400,
			 * 1, 1, 1, 1, 5);
			 * 
			 * getBolas().add(bola); getBolas().add(bola1); getBolas().add(bola2);
			 * getBolas().add(bola3); getBolas().add(bola4);
			 * 
			 * BolaHilo bolaHilo = new BolaHilo(bola, this); BolaHilo bolaHilo1 = new
			 * BolaHilo(bola1, this); BolaHilo bolaHilo2 = new BolaHilo(bola2, this);
			 * BolaHilo bolaHilo3 = new BolaHilo(bola3, this); BolaHilo bolaHilo4 = new
			 * BolaHilo(bola4, this);
			 * 
			 * bolaHilo.start(); bolaHilo1.start(); bolaHilo2.start(); bolaHilo3.start();
			 * bolaHilo4.start();
			 */
			Pintor pintor = new Pintor(this);
			pintor.start();
			setPrimeraVez(false);
		}

		/*
		 * g.setColor(Color.YELLOW); g.fillRect(100, 100, 100, 100);
		 * g.setColor(Color.RED); g.drawOval(250, 100, 100, 100); int[] x = { 50, 100,
		 * 150 }; int[] y = { 80, 300, 250 }; g.drawPolygon(x, y, 3);
		 */

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getExterno().clearRect(0, 0, this.getWidth(), this.getHeight());
		for (Bola bola : this.getBolas()) {
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

	/*
	 * public Bola getBola() { return bola; }
	 * 
	 * public void setBola(Bola bola) { this.bola = bola; }
	 */



}
