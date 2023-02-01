package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")
public class Chat extends Frame {
	
	public Chat() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
	this.setLayout(new BorderLayout(20,20));
	Panel pSuperior= new Panel();
	pSuperior.setBackground(Color.BLUE);
	this.add(pSuperior,BorderLayout.NORTH);
	
	
	}
	

}
