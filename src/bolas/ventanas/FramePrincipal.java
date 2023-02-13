package bolas.ventanas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FramePrincipal extends JFrame {
	
	public FramePrincipal() {
		this.setTitle("                                                                              ▁ ▂ ▄ ▅ ▆ ▇ █ ArKaNoId █ ▇ ▆ ▅ ▄ ▂ ▁");
		ImageIcon icono = new ImageIcon("recursos/spain.png");
        this.setIconImage(icono.getImage());
		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tamanoDeLaPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(tamanoDeLaPantalla.width/2,tamanoDeLaPantalla.height-100);
		this.setLocation(tamanoDeLaPantalla.width/4,30);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		VentanaZonaDeJuego ventanaZonaDeJuego = new VentanaZonaDeJuego();
		GridBagConstraints gbcZonaDeJuego = new GridBagConstraints();
		GridBagConstraints gbcZonaDeDatos = new GridBagConstraints();
		gbcZonaDeJuego.gridx = 0;
		gbcZonaDeJuego.gridy = 0;
		//gbcZonaDeJuego.gridheight = GridBagConstraints.REMAINDER;
		gbcZonaDeJuego.fill = GridBagConstraints.BOTH;
		gbcZonaDeJuego.weightx = 0.75;
		gbcZonaDeJuego.weighty = 1.0;
		gbcZonaDeDatos.gridx = 1;
		gbcZonaDeDatos.gridy = 0;
		gbcZonaDeDatos.fill = GridBagConstraints.BOTH;
		gbcZonaDeDatos.weightx = 0.25;
		gbcZonaDeDatos.insets.left = 10;
		this.add(ventanaZonaDeJuego, gbcZonaDeJuego);
		this.add(new VentanaZonaDeDatos(), gbcZonaDeDatos);
		
		
		//framePrincipal.add(new VentanaZonaDeJuego());
		
		//framePrincipal.setVisible(true);
		}
}
