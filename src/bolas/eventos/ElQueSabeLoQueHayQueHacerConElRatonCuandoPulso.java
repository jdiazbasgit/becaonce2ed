package bolas.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bolas.ventanas.Cursor;

public class ElQueSabeLoQueHayQueHacerConElRatonCuandoPulso implements MouseListener {

	private Cursor cursor;

	public ElQueSabeLoQueHayQueHacerConElRatonCuandoPulso(Cursor cursor) {
		this.cursor = cursor;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
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

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}