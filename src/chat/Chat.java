package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")
public class Chat extends Frame {
	
	public Chat() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
	this.setLayout(new GridLayout(3,3));
		//componentes
		
		Label label1= new Label("usuario");
		Label label2 = new Label("mensaje");
		Label label3 = new Label ("enviar");
		
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel pCentral = new Panel();
		
		
		
	}
	

}
