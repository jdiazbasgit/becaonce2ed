package bolas.bolas;

public class Bola {
	
	private int posicionX,posicionY,incrementoX,incrementoY,sentidoX,sentidoY,dimension;
	private int impactos;
	
	
	public Bola(int posicionX, int posicionY, int incrementoX, int incrementoY, int sentidoX, int sentidoY,
			int dimension,int impactos) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.incrementoX = incrementoX;
		this.incrementoY = incrementoY;
		this.sentidoX = sentidoX;
		this.sentidoY = sentidoY;
		this.dimension = dimension;
		this.impactos= impactos;
	}
	public void calcularPosicion() {
		setPosicionX(getPosicionX()+(getIncrementoX()*getSentidoX()));
		setPosicionY(getPosicionY()+(getIncrementoY()*getSentidoY()));
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

	public int getIncrementoX() {
		return incrementoX;
	}

	public void setIncrementoX(int incrementoX) {
		this.incrementoX = incrementoX;
	}

	public int getIncrementoY() {
		return incrementoY;
	}

	public void setIncrementoY(int incrementoY) {
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
	public int getRebotes() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getRebotesMaximos() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getImpactos() {
		return impactos;
	}
	public void setImpactos(int impactos) {
		this.impactos = impactos;
	}

}