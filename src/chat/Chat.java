package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")

public class Chat extends Frame {

	private Button bRegistrar, bEnviar;
	private TextField tNick, tMensaje;
	private Panel pSuperior, pInferior, pIzquierda, pIzquierdaSuperior;
	private TextArea taMensajes, taUsuarios;
	private Label lNick, lUsuarios, lMensajes;

	public Chat() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		/*
		 * Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
		 * setSize(dimension.width/2,dimension.height/2);
		 * setLocation(dimension.width/4,dimension.height/4);
		 */

		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
		setbRegistrar(new Button("Registrar"));
		setbEnviar(new Button("Enviar"));
		
		settNick(new TextField("Nombre...", 0));
		settMensaje(new TextField("Comentar...", 0));
		
		setpSuperior(new Panel());
		setpInferior(new Panel());
		setpIzquierda(new Panel());
		setpIzquierdaSuperior(new Panel());

		setTaMensajes(new TextArea());
		setTaUsuarios(new TextArea());
		
		setlNick(new Label("Nick:"));
		setlUsuarios(new Label("Usuarios:"));
		setlMensajes(new Label("Mensaje:"));
		
		pSuperior.setBackground(Color.YELLOW);
		pSuperior.setLayout(new FlowLayout(FlowLayout.CENTER,100,25));
	    pSuperior.add(getlNick());
	    pSuperior.add(gettNick());
	    pSuperior.add(getbRegistrar());
	    this.add(pSuperior, BorderLayout.NORTH);
		
	    pInferior.setBackground(Color.GREEN);
	    pInferior.setLayout(new FlowLayout(FlowLayout.CENTER,100,25));
	    pInferior.add(getlMensajes());
	    pInferior.add(gettMensaje());
	    pInferior.add(getbEnviar());
	    this.add(pInferior, BorderLayout.SOUTH);
	    
	    pIzquierdaSuperior.setBackground(Color.CYAN);
	    pIzquierdaSuperior.setLayout(new FlowLayout());
	    pIzquierdaSuperior.add(getlUsuarios());

	    pIzquierda.setBackground(Color.BLUE);
	    pIzquierda.setLayout(new BorderLayout());
	    pIzquierda.add(getpIzquierdaSuperior(),BorderLayout.NORTH);
	    pIzquierda.add(getTaUsuarios(),BorderLayout.CENTER);
	    this.add(pIzquierda, BorderLayout.WEST);

	    this.add(getTaMensajes(),BorderLayout.CENTER);

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

}

