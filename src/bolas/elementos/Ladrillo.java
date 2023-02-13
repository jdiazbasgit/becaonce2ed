package bolas.elementos;

import java.awt.Color;

public class Ladrillo {

	private int posicionX,posicionY,dimensionX, dimensionY, Impactos;
	private Color color;
	
	
	public Ladrillo(int posicionX, int posicionY, int dimensionX, int dimensionY, Color color, int impactos) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		this.color = color;
		this.Impactos = impactos;
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



	public int getDimensionX() {
		return dimensionX;
	}



	public void setDimensionX(int dimensionX) {
		this.dimensionX = dimensionX;
	}



	public int getDimensionY() {
		return dimensionY;
	}



	public void setDimensionY(int dimensionY) {
		this.dimensionY = dimensionY;
	}

	public int getImpactos() {
		return Impactos;
	}



	public void setImpactos(int impactos) {
		Impactos = impactos;
	}



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}

	
}

