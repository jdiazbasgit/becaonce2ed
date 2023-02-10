package bolas.ventanas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VerVentanaBolas {

	public static void main(String[] args) {
		JFrame framePrincipal = new JFrame("Bolas Locas");
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.add(new VentanaBolas());
		Dimension tamanoDeLaPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		framePrincipal.setSize(tamanoDeLaPantalla.width/2,tamanoDeLaPantalla.height/2);
		framePrincipal.setLocation(tamanoDeLaPantalla.width/4,tamanoDeLaPantalla.height/4);
		//framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		framePrincipal.setVisible(true);
		}
}
