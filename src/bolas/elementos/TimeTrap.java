package bolas.elementos;

public class TimeTrap {

	private int posicionX,posicionY,dimension;
	
	
	public TimeTrap(int posicionX, int posicionY, int dimension) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.dimension = dimension;
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


	public int getDimension() {
		return dimension;
	}


	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	
}
