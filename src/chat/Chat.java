package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import java.awt.TextField;
import java.awt.Toolkit;

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
		//setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		this.setLayout(new BorderLayout());
		Dimension tamanoActualizableFrame = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(tamanoActualizableFrame.width/2,tamanoActualizableFrame.height/2);
		setLocation(tamanoActualizableFrame.width/4,tamanoActualizableFrame.height/4);
		System.out.println(tamanoActualizableFrame);
		
		
		this.setpSuperior(new Panel());
		this.add(getpSuperior(),BorderLayout.NORTH);
		getpSuperior().setLayout(new FlowLayout(FlowLayout.CENTER, 90, 20));
		getpSuperior().setBackground(Color.ORANGE);
		
		this.setlNick(new Label("Nick:"));
		getpSuperior().add(getlNick());
		
		this.settNick(new TextField("Escribe cómo te verán los demás",0));
		getpSuperior().add(gettNick());
		
		this.setbRegistrar(new Button("REGISTRAR"));
		getpSuperior().add(getbRegistrar());
		
		
		this.setpIzquierda(new Panel());
		this.add(getpIzquierda(),BorderLayout.WEST);
		getpIzquierda().setLayout(new BorderLayout());
		getpIzquierda().setBackground(Color.RED);
		//---------
		this.setpIzquierdaSuperior(new Panel());
		getpIzquierda().add(getpIzquierdaSuperior(),BorderLayout.NORTH);
		getpIzquierdaSuperior().setLayout(new BorderLayout());
		getpIzquierdaSuperior().setBackground(Color.DARK_GRAY);
		
		this.setlUsuarios(new Label("Usuarios:"));
		getpIzquierdaSuperior().add(getlUsuarios());
		//-----------
		
		getpIzquierda().add(getpIzquierdaSuperior());
		
				
		this.setTaUsuarios(new TextArea());
		//getpIzquierda().add(getTaUsuarios(),BorderLayout.CENTER);

		
		
		this.setpInferior(new Panel());
		this.add(getpInferior(),BorderLayout.SOUTH);
		getpInferior().setLayout(new FlowLayout(FlowLayout.CENTER, 90, 20));
		getpInferior().setBackground(Color.ORANGE);
		
		this.setlMensajes(new Label("Mensaje:"));
		getpInferior().add(getlMensajes());
		
		this.settMensaje(new TextField("Escribe un mensaje",60));
		getpInferior().add(gettMensaje());
		
		this.setbEnviar(new Button("ENVIAR"));
		getpInferior().add(getbEnviar());
		
		
		this.setTaMensajes(new TextArea());
		this.add(getTaMensajes());
		
		
		
		
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
