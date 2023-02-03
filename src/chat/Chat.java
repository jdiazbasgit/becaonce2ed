package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.PopupMenu;
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

		setbRegistrar(new Button("REGISTRAR"));
		setbEnviar(new Button("ENVIAR"));
		settNick(new TextField(20));
		settMensaje(new TextField(20));
		setpSuperior(new Panel());
		setpInferior(new Panel());
		setpIzquierda(new Panel());
		setpIzquierdaSuperior(new Panel());
		setTaMensajes(new TextArea());
		setTaUsuarios(new TextArea());
		setlNick(new Label("USUARIO"));
		setlUsuarios(new Label("USUARIO"));
		setlMensajes(new Label("MENSAJE"));
		
		getpSuperior().setBackground(Color.GREEN);
		getpSuperior().add(getlNick());
		getpSuperior().add(gettNick());
		getpSuperior().add(getbRegistrar());
		this.add(getpSuperior(),BorderLayout.NORTH);
         
		getpInferior().setBackground(Color.RED);
		getpInferior().add(getlMensajes());
		getpInferior().add(gettMensaje());
		getpInferior().add(getbEnviar());
		this.add(getpInferior(),BorderLayout.SOUTH);
		
	    getpIzquierdaSuperior().setLayout(new BorderLayout());
		getpIzquierdaSuperior().setBackground(Color.MAGENTA);
		getpIzquierdaSuperior().add(getTaUsuarios());
		
		
		
		getpIzquierda().setLayout(new BorderLayout());
		getpIzquierda().add(getlUsuarios(),BorderLayout.NORTH);
		getpIzquierda().setBackground(Color.ORANGE);
		getpIzquierda().add(getpIzquierdaSuperior());
		this.add(getpIzquierda(),BorderLayout.WEST);
	
		
		
		this.add(getTaMensajes(),BorderLayout.CENTER);

		
		// componentes
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
