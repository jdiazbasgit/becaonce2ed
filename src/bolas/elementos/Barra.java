package bolas.elementos;

import bolas.ventanas.VentanaZonaDeJuego;

public class Barra {

	private int posicionX,posicionY,dimensionX, dimensionY;
	private boolean feclaIzquierdaPresionada, flechaDerechaPresionada;
	private VentanaZonaDeJuego ventanaBolas;
	
	public Barra(int posicionX, int posicionY, int dimensionX, int dimensionY, boolean flechaIzquierdaPresionada, boolean flechaDerechaPresionada, VentanaZonaDeJuego ventanaBolas) {
		
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		this.feclaIzquierdaPresionada = flechaIzquierdaPresionada;
		this.flechaDerechaPresionada = flechaDerechaPresionada;
		this.ventanaBolas = ventanaBolas;
	
	}
	
	public void mover() {
	if (isFeclaIzquierdaPresionada()) {	
		ventanaBolas.getBarra().setPosicionX(ventanaBolas.getBarra().getPosicionX()-1);
        if (ventanaBolas.getBarra().getPosicionX() < 10) {
        	ventanaBolas.getBarra().setPosicionX(10);
        }
    }
	if (isFlechaDerechaPresionada()) {			
		ventanaBolas.getBarra().setPosicionX(ventanaBolas.getBarra().getPosicionX()+1);
        if (ventanaBolas.getBarra().getPosicionX() > 580) {
        	ventanaBolas.getBarra().setPosicionX(580);
        }
    }
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

	public boolean isFeclaIzquierdaPresionada() {
		return feclaIzquierdaPresionada;
	}

	public void setFeclaIzquierdaPresionada(boolean feclaIzquierdaPresionada) {
		this.feclaIzquierdaPresionada = feclaIzquierdaPresionada;
	}

	public boolean isFlechaDerechaPresionada() {
		return flechaDerechaPresionada;
	}

	public void setFlechaDerechaPresionada(boolean flechaDerechaPresionada) {
		this.flechaDerechaPresionada = flechaDerechaPresionada;
	}



	
}

