package bolas.elementos;

public class Barra {

	private int posicionX,posicionY,dimensionX, dimensionY;
	
	
	public Barra(int posicionX, int posicionY, int dimensionX, int dimensionY) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
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



	
}

