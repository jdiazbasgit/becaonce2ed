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


@SuppressWarnings("serial")
public class Chat extends Frame {

	private Button bRegistrar,bEnviar;
	private TextField tNick,tMensaje;
	private Panel pSuperior,pInferior,pIzquierda,pIzquierdaSuperior;
	private TextArea taMensajes,taUsuarios;
	private Label lNick,lUsuarios,lMensajes;
	public Chat() {

setExtendedState(JFrame.MAXIMIZED_BOTH);
   this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
   this.setSize(800, 800);
		this.setLayout(new BorderLayout());
		setbRegistrar(new Button("Nick:"));		
	//componentes
	}
	public Button getbRegistrar() {
		return bRegistrar;
	}
	public void setbRegistrar(Button bRegistrar) {
		this.bRegistrar = bRegistrar;
	}
	public Button getbEnviar() {
		return bEnviar;
	}
	public void setbEnviar(Button bEnviar) {
		this.bEnviar = bEnviar;
	}
	public TextField gettNick() {
		return tNick;
	}
	public void settNick(TextField tNick) {
		this.tNick = tNick;
	}
	public TextField gettMensaje() {
		return tMensaje;
	}
	public void settMensaje(TextField tMensaje) {
		this.tMensaje = tMensaje;
	}
	public Panel getpSuperior() {
		return pSuperior;
	}
	public void setpSuperior(Panel pSuperior) {
		this.pSuperior = pSuperior;
	}
	public Panel getpInferior() {
		return pInferior;
	}
	public void setpInferior(Panel pInferior) {
		this.pInferior = pInferior;
	}
	public Panel getpIzquierda() {
		return pIzquierda;
	}
	public void setpIzquierda(Panel pIzquierda) {
		this.pIzquierda = pIzquierda;
	}
	public Panel getpIzquierdaSuperior() {
		return pIzquierdaSuperior;
	}
	public void setpIzquierdaSuperior(Panel pIzquierdaSuperior) {
		this.pIzquierdaSuperior = pIzquierdaSuperior;
	}
	public TextArea getTaMensajes() {
		return taMensajes;
	}
	public void setTaMensajes(TextArea taMensajes) {
		this.taMensajes = taMensajes;
	}
	public TextArea getTaUsuarios() {
		return taUsuarios;
	}
	public void setTaUsuarios(TextArea taUsuarios) {
		this.taUsuarios = taUsuarios;
	}
	public Label getlNick() {
		return lNick;
	}
	public void setlNick(Label lNick) {
		this.lNick = lNick;
	}
	public Label getlUsuarios() {
		return lUsuarios;
	}
	public void setlUsuarios(Label lUsuarios) {
		this.lUsuarios = lUsuarios;
	}
	public Label getlMensajes() {
		return lMensajes;
	}
	public void setlMensajes(Label lMensajes) {
		this.lMensajes = lMensajes;
	}

=======

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
