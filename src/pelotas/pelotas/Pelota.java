package pelotas.pelotas;

public class Pelota {

	private int posicionX, posicionY, incrementoX, incrementoY, sentidoX, sentidoY, dimension;
	private int impactos;

	public Pelota(int posicionX, int posicionY, int incrementoX, int incrementoY, int sentidoX, int sentidoY,
			int dimension) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.incrementoX = incrementoX;
		this.incrementoY = incrementoY;
		this.sentidoX = sentidoX;
		this.sentidoY = sentidoY;
		this.dimension = dimension;
	}
	
	
	public void calcularPosicion() {
		
		setPosicionX(getPosicionX()+(getIncrementoX()*getSentidoX()));
		setPosicionY(getPosicionY()+(getIncrementoY()*getSentidoY()));
		
		/* el método calcula la nueva posición de un objeto en un espacio bidimensional
		 *  en función de su posición actual, los incrementos en las direcciones x e y, 
		 *  y la dirección en la que se mueve el objeto en cada una de esas direcciones. 
		 *  Los métodos "getPosicionX" y "getPosicionY" se utilizan para recuperar 
		 *  los valores actuales de las variables de posición, mientras que los métodos 
		 *  "setPosicionX" y "setPosicionY" se utilizan
		 *   para actualizar esos valores con los nuevos cálculos de posición.*/
		 
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

	public int getImpactos() {
		return impactos;
	}

	public void setImpactos(int impactos) {
		this.impactos = impactos;
	}
}
