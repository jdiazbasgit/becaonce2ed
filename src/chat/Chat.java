package chat;
import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;
@SuppressWarnings("serial")
public class Chat extends Frame {
	
	public Chat() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		this.setSize(800, 800);
		this.setLayout(new BorderLayout());
		
	
		
		
	}

}
