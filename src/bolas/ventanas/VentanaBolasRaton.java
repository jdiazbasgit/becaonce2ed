package bolas.ventanas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import bolas.bolas.Bola;
import bolas.cursor.Cursor;
import bolas.hilos.BolaHiloRaton;
import bolas.hilos.PintorRaton;

public class VentanaBolasRaton extends JFrame {

	private Image imagen;
	private Graphics externo;
	private boolean primeraVez;
	private List<Bola> bolas;
	private Cursor cursor;

	public VentanaBolasRaton() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPrimeraVez(true);
		setBolas(new ArrayList<>());
	}

	@Override
	public void paint(Graphics g) {

		if (isPrimeraVez()) {
			
			setImagen(createImage(this.getWidth(), this.getHeight()));
			setExterno(getImagen().getGraphics());

/*
			Bola bola = new Bola(100, 100, 1, 1, -1, 1, 25);
			Bola bola1 = new Bola(50, 50, 1, 1, -1, -1, 60);
			Bola bola2 = new Bola(80, 10, 1, 1, -1, 1, 50);
			Bola bola3 = new Bola(200, 300, 1, 1, 1, -1, 100);
			Bola bola4 = new Bola(10, 400, 1, 1, 1, 1, 5);

			getBolas().add(bola);
			getBolas().add(bola1);
			getBolas().add(bola2);
			getBolas().add(bola3);
			getBolas().add(bola4);

			BolaHiloRaton bolaHiloRaton = new BolaHiloRaton(bola, this);
			BolaHiloRaton bolaHiloRaton1 = new BolaHiloRaton(bola1, this);
			BolaHiloRaton bolaHiloRaton2 = new BolaHiloRaton(bola2, this);
			BolaHiloRaton bolaHiloRaton3 = new BolaHiloRaton(bola3, this);
			BolaHiloRaton bolaHiloRaton4 = new BolaHiloRaton(bola4, this);

			bolaHiloRaton.start();
			bolaHiloRaton1.start();
			bolaHiloRaton2.start();
			bolaHiloRaton3.start();
			bolaHiloRaton4.start();
*/
			Bola bola = new Bola(getCursor().getPosicionX(), 100, 1, 1, -1, 1, 25);
			getBolas().add(bola);
			BolaHiloRaton bolaHiloRaton = new BolaHiloRaton(bola, this);
			bolaHiloRaton.start();

			PintorRaton pintorRaton = new PintorRaton(this);
			pintorRaton.start();
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

	public List<Bola> getBolas() {
		return bolas;
	}

	public void setBolas(List<Bola> bolas) {
		this.bolas = bolas;
	}

}
