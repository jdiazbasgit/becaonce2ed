package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

//import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")

public class EjemploBag extends Frame {

	private Button bRegistrar, bEnviar;
	private TextField tNick, tMensaje;
	private Panel pSuperior, pInferior, pIzquierda, pIzquierdaSuperior;
	private TextArea taMensajes, taUsuarios;
	private Label lNick, lUsuarios, lMensajes;

	public EjemploBag() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
		setbRegistrar(new Button("Registrar"));
		setbEnviar(new Button("Enviar"));
		
		settNick(new TextField("Nombre...", 0));
		settMensaje(new TextField("Comentar...", 0));
		
		setTaMensajes(new TextArea());
		setTaUsuarios(new TextArea());
		
		setlNick(new Label("Nick:"));
		setlUsuarios(new Label("Usuarios:"));
		setlMensajes(new Label("Mensaje:"));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints restLNick =new GridBagConstraints();
		restLNick.gridx = 0;
		restLNick.gridy = 0;
		restLNick.weightx=0.3;
		restLNick.weighty=0.2;		
		add(getlNick(),restLNick);

		GridBagConstraints restTNick =new GridBagConstraints();
		restTNick.gridx = 1;
		restTNick.gridy = 0;
		restTNick.weightx=0.3;
		restTNick.weighty=0.2;		
		add(gettNick(),restTNick);

		GridBagConstraints restBRegistrar =new GridBagConstraints();
		restBRegistrar.gridx = 2;
		restBRegistrar.gridy = 0;
		restBRegistrar.weightx=0.3;
		restBRegistrar.weighty=0.2;		
		add(getbRegistrar(),restBRegistrar);

		GridBagConstraints restLUsuarios =new GridBagConstraints();
		restLUsuarios.gridx = 0;
		restLUsuarios.gridy = 1;
		restLUsuarios.weightx=0.3;
		restLUsuarios.weighty=0.2;		
		add(getlUsuarios(),restLUsuarios);

		GridBagConstraints restTaUsuarios =new GridBagConstraints();
		restTaUsuarios.gridx = 0;
		restTaUsuarios.gridy = 2;
		restTaUsuarios.weightx=0.3;
		restTaUsuarios.weighty=0.2;		
		add(getTaUsuarios(),restTaUsuarios);

		GridBagConstraints restTaMensajes =new GridBagConstraints();
		restTaMensajes.gridx = 1;
		restTaMensajes.gridy = 1;
		restTaMensajes.weightx=0.3;
		restTaMensajes.weighty=0.2;
		restTaMensajes.gridwidth=2;
		restTaMensajes.gridheight=2;

		add(getTaMensajes(),restTaMensajes);

		GridBagConstraints restLMensajes =new GridBagConstraints();
		restLMensajes.gridx = 0;
		restLMensajes.gridy = 3;
		restLMensajes.weightx=0.3;
		restLMensajes.weighty=0.2;		
		add(getlMensajes(),restLMensajes);

		GridBagConstraints restTMensaje =new GridBagConstraints();
		restTMensaje.gridx = 1;
		restTMensaje.gridy = 3;
		restTMensaje.weightx=0.3;
		restTMensaje.weighty=0.2;		
		add(gettMensaje(),restTMensaje);

		GridBagConstraints restBEnviar =new GridBagConstraints();
		restBEnviar.gridx = 2;
		restBEnviar.gridy = 3;
		restBEnviar.weightx=0.3;
		restBEnviar.weighty=0.2;		
		add(getbEnviar(),restBEnviar);

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