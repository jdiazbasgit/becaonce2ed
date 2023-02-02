package chat;

import java.awt.Panel;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")
public class Chat extends Frame {
	
	public Chat() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
		
		
		
		
	}
	

}
