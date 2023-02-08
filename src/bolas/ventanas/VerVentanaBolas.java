package bolas.ventanas;

public class VerVentanaBolas {

	public static void main(String[] args) {

		int i = 3;

		switch(i) {
		  case 1:
				VentanaBolaSimple v1 = new VentanaBolaSimple();
				v1.setVisible(true);
		    break;
		  case 2:
				VentanaBolas v2 = new VentanaBolas();
				v2.setVisible(true);
		    break;
		  case 3:
				VentanaBolasRaton v3 = new VentanaBolasRaton();
				v3.setVisible(true);
		    break;
		  default:
		    System.out.println("i es mayor a tres.");
		}

	}

}
