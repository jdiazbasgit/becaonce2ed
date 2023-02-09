package bolas.eventos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import bolas.ventanas.Cursor;

public class ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento implements MouseMotionListener {

	private Cursor cursor;

	public ElQueSabeLoQueHayQueHacerConElRatonEnMovimiento(Cursor cursor) {
		this.cursor = cursor;
	}

	public void mouseDragged(MouseEvent e) {
		if (e.getModifiersEx() == 1024)
			getCursor().getExterno().setColor(Color.RED);
		if (e.getModifiersEx() == 4096)
			getCursor().getExterno().setColor(Color.YELLOW);
		colocarCursor(e);
	}

	public void mouseMoved(MouseEvent e) {
		getCursor().getExterno().setColor(Color.BLUE);
		colocarCursor(e);

	}

	private void colocarCursor(MouseEvent e) {
		getCursor().setPosicionX(e.getX());
		getCursor().setPosicionY(e.getY());
		getCursor().repaint();
	}

	public Cursor getCursor() {
		return cursor;
	}

	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}

}
