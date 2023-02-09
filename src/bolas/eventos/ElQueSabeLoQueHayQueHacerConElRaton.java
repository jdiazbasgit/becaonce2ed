package bolas.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import bolas.bolas.Bola;
import bolas.cursor.Cursor;

public class ElQueSabeLoQueHayQueHacerConElRaton implements MouseListener {

	private Cursor cursor;
	private Bola bola;

	public ElQueSabeLoQueHayQueHacerConElRaton(Cursor cursor) {
		this.cursor = cursor;
	}

	public ElQueSabeLoQueHayQueHacerConElRaton(Bola bola) {
		this.bola = bola;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("("+e.getX()+" - "+e.getY()+")");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
