package bolas.bolas;

public class Pelota {

	private int posicionX, posicionY, incrementoX, incrementoY, sentidoX, sentidoY, dimension;

	public void cacularPosicion() {
		setPosicionX(getPosicionX() + (getIncrementoX() * getSentidoX()));
		setPosicionY(getPosicionY() + (getIncrementoY() * getSentidoY()));
	}
    public Pelota(int posicionX, int posicionY, int dimension, int incrementoX, int incrementoY, int sentidoX, int sentidoY) {
    	this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.incrementoX = incrementoX;
		this.incrementoY = incrementoY;
		this.sentidoX = sentidoX;
		this.sentidoY = sentidoY;
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

    }
	

