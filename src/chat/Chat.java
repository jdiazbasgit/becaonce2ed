package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")
public class Chat extends Frame {

	public Chat() {
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(800, 600);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		this.setLayout(new BorderLayout());
		Dimension tamanoActualizableFrame = this.getSize();
		System.out.println(tamanoActualizableFrame);
	    
		
		Panel pNorte = new Panel();
	    Panel pSur = new Panel();
	    Panel pOeste = new Panel();
	    Panel pCentro = new Panel();
	    
	    pNorte.setBackground(Color.BLUE);
	    pSur.setBackground(Color.DARK_GRAY);
	    pOeste.setBackground(Color.ORANGE);
	    pCentro.setBackground(Color.LIGHT_GRAY);

	    
	    this.add(pNorte, BorderLayout.NORTH);
	    this.add(pSur, BorderLayout.SOUTH);
	    this.add(pOeste, BorderLayout.WEST);
	    this.add(pCentro, BorderLayout.CENTER);	  
	    
	    pNorte.setLayout(new FlowLayout(FlowLayout.CENTER,90,50));
	    pNorte.add(new Label("Usuario"));
	    pNorte.add(new TextField("Introduce tu nombre", 0));
	    pNorte.add(new Button("Registrar"));
	   
	
	}

}
