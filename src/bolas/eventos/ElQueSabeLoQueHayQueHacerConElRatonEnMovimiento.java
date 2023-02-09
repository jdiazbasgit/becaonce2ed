package bolas.eventos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import bolas.bolas.Bola;
import bolas.cursor.Cursor;

public class ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento implements MouseMotionListener {

	private Cursor cursor;
	private Bola bola;

	public ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento(Cursor cursor) {
		this.cursor = cursor;
	}

	public ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento(Bola bola) {
		this.bola = bola;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getModifiersEx() == 1024)
			getCursor().getExterno().setColor(Color.RED);
		if (e.getModifiersEx() == 4096)
			getCursor().getExterno().setColor(Color.YELLOW);
		colocar(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		getCursor().getExterno().setColor(Color.BLUE);
		colocar(e);
	}

	private void colocar(MouseEvent e) {
		getCursor().setPosicionX(e.getX());
		getCursor().setPosicionY(e.getY());
		getCursor().repaint();

		getBola().setPosicionX(e.getX());
		getBola().setPosicionY(e.getY());
		getBola().repaint();
	}
	
	public Cursor getCursor() {
		return cursor;
	}

	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}
	
	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
	}

}
