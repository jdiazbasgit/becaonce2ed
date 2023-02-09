package bolas.ventanas;

import bolas.cursor.Cursor;

public class VerVentanaBolas {

	public static void main(String[] args) {

		int i = 4;

		switch (i) {
		case 1: // Una bola hacia derecha hasta final, sin poder cerrar la ventana
			VentanaBolaSimple v1 = new VentanaBolaSimple();
			v1.setVisible(true);
			break;
		case 2: // Cincos bolas mueven por su cuenta y cierra la ventana
			VentanaBolas v2 = new VentanaBolas();
			v2.setVisible(true);
			break;
		case 3: // Cursor con el informe de coordenado x e y
			Cursor cursor = new Cursor();
			cursor.setVisible(true);
			break;
		case 4: //
			VentanaBolasRaton v3 = new VentanaBolasRaton();
			v3.setVisible(true);
			break;
		default:
			System.out.println("No exise el menu " + i);
		}

	}

}
