package bolas.bolas;

import java.awt.Color;

import javax.swing.JFrame;

public class Bola extends JFrame {

	private int posicionX, posicionY, incrementoX, incrementoY, sentidoX, sentidoY, dimension;
	private Color color;
	private boolean intersectado;
	private int numImpacto;

	public Bola(int posicionX, int posicionY, int incrementoX, int incrementoY, int sentidoX, int sentidoY, int dimension) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.incrementoX = incrementoX;
		this.incrementoY = incrementoY;
		this.sentidoX = sentidoX;
		this.sentidoY = sentidoY;
		this.dimension = dimension;
	}

	public Bola(int posicionX, int posicionY, int incrementoX, int incrementoY, int sentidoX, int sentidoY, int dimension, Color color) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.incrementoX = incrementoX;
		this.incrementoY = incrementoY;
		this.sentidoX = sentidoX;
		this.sentidoY = sentidoY;
		this.dimension = dimension;
		this.color = color;
		this.intersectado = false;
		this.numImpacto = 500;
	}

	public void calcularPosicion() {
		setPosicionX(getPosicionX() + (getIncrementoX() * getSentidoX()));
		setPosicionY(getPosicionY() + (getIncrementoY() * getSentidoY()));
	}

	public void cambiarSentidoX() {
		setSentidoX(getSentidoX() * -1);
	}

	public void cambiarSentidoY() {
		setSentidoY(getSentidoY() * -1);
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isIntersectado() {
		return intersectado;
	}

	public void setIntersectado(boolean intersectado) {
		this.intersectado = intersectado;
	}

	public int getNumImpacto() {
		return numImpacto;
	}

	public void setNumImpacto(int numImpacto) {
		this.numImpacto = numImpacto;
	}

}
