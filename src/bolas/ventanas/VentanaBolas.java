package bolas.ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bolas.elementos.Bola;
import bolas.elementos.TimeTrap;
import bolas.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
import bolas.hilos.Pintor;

@SuppressWarnings("serial")
public class VentanaBolas extends JPanel {

	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	private List<Bola> bolas;
	private List<TimeTrap> timeTraps;
	private List<Bola> bolasTemporal;
	private List<TimeTrap> timeTrapsTemporal;
	

	public VentanaBolas() {
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBolas(new ArrayList<>());
		setTimeTraps(new ArrayList<>());
		setBolasTemporal(new ArrayList<>());
		setTimeTrapsTemporal(new ArrayList<>());
		setPrimeraVez(true);		
		addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton(this));
	}

	
	@Override
	public void paint(Graphics g) {
		if (isPrimeraVez()) {
			setImagen(createImage(this.getWidth(), this.getHeight()));
			setExterno(getImagen().getGraphics());
			

			/* setBola(new Bola(100, 100, 1, 1, 1, -1, 50));
			 * Bola bola = new Bola(100, 100, 1, 1, -1, 1, 25);
			 * getBolas().add(bola);			 * 
			 * BolaHilo bolaHilo = new BolaHilo(bola, this);		 * 
			 * bolaHilo.start();
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
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getExterno().clearRect(0, 0, this.getWidth(), this.getHeight());
		/*Image imagenSlim;
		imagenSlim = new ImageIcon("recursos/slime.png").getImage();*/
		Image imageMiniSlime;
		imageMiniSlime = new ImageIcon("recursos/minislime.png").getImage();
		
		for (Bola bola : this.getBolas()) {
			getExterno().setColor(bola.getColor());
			getExterno().fillOval((int) Math.round(bola.getPosicionX()),(int) Math.round(bola.getPosicionY()), bola.getDimension(), bola.getDimension());
		}
		for (TimeTrap timeTrap : this.getTimeTraps()) {
			getExterno().setColor(Color.RED);
			getExterno().drawImage(imageMiniSlime, timeTrap.getPosicionX()-(timeTrap.getDimension()/2), timeTrap.getPosicionY()-(timeTrap.getDimension()/2), this);
			//getExterno().drawRect(timeTrap.getPosicionX(),timeTrap.getPosicionY(), timeTrap.getDimension(), timeTrap.getDimension());
			
		}
		//getExterno().drawImage(imagenSlim, 0, 0, this);
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


	public List<TimeTrap> getTimeTraps() {
		return timeTraps;
	}


	public void setTimeTraps(List<TimeTrap> timeTraps) {
		this.timeTraps = timeTraps;
	}


	public List<TimeTrap> getTimeTrapsTemporal() {
		return timeTrapsTemporal;
	}


	public void setTimeTrapsTemporal(List<TimeTrap> timeTrapsTemporal) {
		this.timeTrapsTemporal = timeTrapsTemporal;
	}


	public List<Bola> getBolasTemporal() {
		return bolasTemporal;
	}


	public void setBolasTemporal(List<Bola> bolasTemporal) {
		this.bolasTemporal = bolasTemporal;
	}

	/*
	 * public Bola getBola() { return bola; }
	 * 
	 * public void setBola(Bola bola) { this.bola = bola; }
	 */



}
