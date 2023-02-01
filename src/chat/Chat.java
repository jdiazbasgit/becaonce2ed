package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
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

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
	    Panel pSuperior = new Panel();
	    pSuperior.setBackground(Color.YELLOW);
	    pSuperior.setLayout(new FlowLayout(FlowLayout.CENTER,100,25));
	    pSuperior.add(new Label("Usuario"));
	    pSuperior.add(new TextField("Nombre...", 0));
	    pSuperior.add(new Button("Registrar"));

	    Panel pInferior = new Panel();
	    pInferior.setBackground(Color.GREEN);
	    pInferior.setLayout(new FlowLayout(FlowLayout.CENTER,100,25));
	    pInferior.add(new Label("Mensaje"));
	    pInferior.add(new TextField("Comentar...", 0));
	    pInferior.add(new Button("Enviar"));

	    Panel pIzquierda = new Panel();
	    pIzquierda.setBackground(Color.BLUE);
	    pIzquierda.setLayout(new FlowLayout(FlowLayout.CENTER,25,100));
	    pIzquierda.add(new Label("Usuarios"));

	    Panel pCentro = new Panel();
	    pCentro.setBackground(Color.PINK);
	    pCentro.setLayout(new FlowLayout(FlowLayout.CENTER,25,100));
	    pCentro.add(new Label("Area de mensajes"));

	    this.add(pSuperior, BorderLayout.NORTH);
	    this.add(pInferior, BorderLayout.SOUTH);
	    this.add(pIzquierda, BorderLayout.WEST);
	    this.add(pCentro);
	    
	}
	
}
