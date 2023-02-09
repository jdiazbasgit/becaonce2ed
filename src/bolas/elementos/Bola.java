package bolas.elementos;

import java.awt.Color;

public class Bola {
	
	private int sentidoX,sentidoY,dimension,velocidadThread, velocidadRalentizada;
	private float posicionX,posicionY,incrementoX,incrementoY;
	private Color color;
	
	

	

	public Bola(float posicionX, float posicionY, float incrementoX, float incrementoY, int sentidoX, int sentidoY,
			int dimension, Color color, int velocidadThread, int velocidadRalentizada) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.incrementoX = incrementoX;
		this.incrementoY = incrementoY;
		this.sentidoX = sentidoX;
		this.sentidoY = sentidoY;
		this.dimension = dimension;
		this.color = color;
		this.velocidadThread = velocidadThread;
		this.velocidadRalentizada = velocidadRalentizada;
		
	}
	
	public void calcularPosicion() {
		setPosicionX(getPosicionX()+(getIncrementoX()*getSentidoX()));
		setPosicionY(getPosicionY()+(getIncrementoY()*getSentidoY()));
		
		/*
		  if (getColor().getRed()>180 && getColor().getGreen()<100 &&
		  getColor().getBlue()<100) { setIncrementoY(4); setIncrementoX(4); }
		 */
		
		/*
		if (getPosicionY() >= 500 && getIncrementoX()>1)
		{
			setIncrementoX(getIncrementoX()/2);
			setIncrementoY(getIncrementoY()/2);
		}else {
			setIncrementoX((float) (getIncrementoX()+0.2));
			setIncrementoY((float) (getIncrementoY()+0.2));
		}
		*/
	}

	public float getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(float posicionX) {
		this.posicionX = posicionX;
	}

	public float getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(float posicionY) {
		this.posicionY = posicionY;
	}

	public float getIncrementoX() {
		return incrementoX;
	}

	public void setIncrementoX(float incrementoX) {
		this.incrementoX = incrementoX;
	}

	public float getIncrementoY() {
		return incrementoY;
	}

	public void setIncrementoY(float incrementoY) {
		this.incrementoY = incrementoY;
	}

	public int getSentidoX() {
		return sentidoX;
	}

	public void setSentidoX(int sentidoX) {
		this.sentidoX = sentidoX;
	}

	public int getSentidoY() {
		return sentidoY;
	}

	public void setSentidoY(int sentidoY) {
		this.sentidoY = sentidoY;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getVelocidadThread() {
		return velocidadThread;
	}


	public void setVelocidadThread(int velocidadThread) {
		this.velocidadThread = velocidadThread;
	}


	public int getVelocidadRalentizada() {
		return velocidadRalentizada;
	}


	public void setVelocidadRalentizada(int velocidadRalentizada) {
		this.velocidadRalentizada = velocidadRalentizada;
	}

}
