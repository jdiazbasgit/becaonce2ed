package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;
import javafx.scene.control.TextField;

@SuppressWarnings("serial")
public class Chat extends Frame {
	
	public Chat() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
		
		Label lNick=new Label ("NICK");
		Label lMensaje= new Label ("MENSAJE");
		Label lUsuario= new Label("USUARIO");
		
		Button bButton= new Button ("REGISTRAR");
		Button bButton1=new Button ("ENVIAR");
		
		TextArea tTextArea= new TextArea("USUARIOS");
		TextArea tTextArea2=new TextArea("MENSAJES");
		
		TextField tNick= new TextField ();
		TextField tMensaje= new TextField ();
				
		
		
		
		Panel pSuperior= new Panel();
		Panel pInferior= new Panel();
		Panel pIzquierda=new Panel();
		Panel pDerecha= new Panel();
		pSuperior.setBackground(Color.gray);
		pSuperior.setLayout(new BorderLayout());
		
	}
	

}
