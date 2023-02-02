package chat;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")
public class Chat extends Frame {
	
	public Chat() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
		//componentes
		
		Panel pSuperior = new Panel();
		pSuperior.setBackground(Color.CYAN);
		Panel pInferior = new Panel();
		pInferior.setBackground(Color.RED);
		Panel pIzquierdo = new Panel();
		pIzquierdo.setBackground(Color.YELLOW);
		
		
		Label 11 = new Label("uno");
		Label 12 = new Label("dos");
		Label 13 = new Label("tres");
		
		
	}
	

}
