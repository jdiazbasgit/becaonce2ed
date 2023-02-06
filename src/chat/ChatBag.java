package chat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")

public class ChatBag extends Frame {

	private Button bRegistrar, bEnviar;
	private TextField tNick, tMensaje;
	private TextArea taMensajes, taUsuarios;
	private Label lNick, lUsuarios, lMensajes;

	public ChatBag() {

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
		setbRegistrar(new Button("Registrar"));
		setbEnviar(new Button("Enviar"));
		
		settNick(new TextField("Nombre...", 40));
		settMensaje(new TextField("Comentar...", 0));
		
		setTaMensajes(new TextArea("Area de mensajes"));
		setTaUsuarios(new TextArea("Lista de usuarios", 20, 1));
		
		setlNick(new Label("Nick:"));
		setlUsuarios(new Label("Usuarios:"));
		setlMensajes(new Label("Mensaje:"));
		
		Double gridx0weightx = 0.1;
		Double gridx1weightx = 0.8;
		Double gridx2weightx = 0.1;

		Double gridy0weighty = 0.1;
		Double gridy1weighty = 0.05;
		Double gridy2weighty = 0.75;
		Double gridy3weighty = 0.1;
		
		Insets insMargen = new Insets(5, 10, 5, 10);

		setLayout(new GridBagLayout());
		
		GridBagConstraints restLNick =new GridBagConstraints();
		restLNick.gridx = 0;
		restLNick.gridy = 0;
		restLNick.weightx = gridx0weightx;
		restLNick.weighty = gridy0weighty;	
		restLNick.ipadx = 20;	
		restLNick.anchor = GridBagConstraints.EAST;
		restLNick.insets = insMargen;
		add(getlNick(),restLNick);

		GridBagConstraints restTNick =new GridBagConstraints();
		restTNick.gridx = 1;
		restTNick.gridy = 0;
		restTNick.weightx = gridx1weightx;
		restTNick.weighty = gridy0weighty;	
		restTNick.anchor = GridBagConstraints.WEST;
		restTNick.insets = insMargen;
		gettNick().addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());
		add(gettNick(),restTNick);

		GridBagConstraints restBRegistrar =new GridBagConstraints();
		restBRegistrar.gridx = 2;
		restBRegistrar.gridy = 0;
		restBRegistrar.weightx = gridx2weightx;
		restBRegistrar.weighty = gridy0weighty;		
		restBRegistrar.ipadx = 20;	
		restBRegistrar.anchor = GridBagConstraints.WEST;
		restBRegistrar.insets = insMargen;
		add(getbRegistrar(),restBRegistrar);

		GridBagConstraints restLUsuarios =new GridBagConstraints();
		restLUsuarios.gridx = 0;
		restLUsuarios.gridy = 1;
		restLUsuarios.weightx = gridx0weightx;
		restLUsuarios.weighty = gridy1weighty;		
		restLUsuarios.insets = insMargen;
		add(getlUsuarios(),restLUsuarios);

		GridBagConstraints restTaUsuarios =new GridBagConstraints();
		restTaUsuarios.gridx = 0;
		restTaUsuarios.gridy = 2;
		restTaUsuarios.weightx = gridx0weightx;
		restTaUsuarios.weighty = gridy2weighty;
		restTaUsuarios.fill = GridBagConstraints.BOTH;
		restTaUsuarios.insets = insMargen;
		add(getTaUsuarios(),restTaUsuarios);

		GridBagConstraints restTaMensajes =new GridBagConstraints();
		restTaMensajes.gridx = 1;
		restTaMensajes.gridy = 1;
		restTaMensajes.weightx = gridx1weightx + gridx2weightx;
		restTaMensajes.weighty = gridy1weighty + gridy2weighty;
		restTaMensajes.gridwidth = 2;
		restTaMensajes.gridheight = 2;
		restTaMensajes.fill = GridBagConstraints.BOTH;
		restTaMensajes.insets = insMargen;
		add(getTaMensajes(),restTaMensajes);

		GridBagConstraints restLMensajes =new GridBagConstraints();
		restLMensajes.gridx = 0;
		restLMensajes.gridy = 3;
		restLMensajes.weightx = gridx0weightx;
		restLMensajes.weighty = gridy3weighty;	
		restLMensajes.ipadx = 50;	
		restLMensajes.anchor = GridBagConstraints.EAST;
		restLMensajes.insets = insMargen;
		add(getlMensajes(),restLMensajes);

		GridBagConstraints restTMensaje =new GridBagConstraints();
		restTMensaje.gridx = 1;
		restTMensaje.gridy = 3;
		restTMensaje.weightx = gridx1weightx;
		restTMensaje.weighty = gridy3weighty;		
		restTMensaje.fill = GridBagConstraints.HORIZONTAL;
		restTMensaje.insets = insMargen;
		gettMensaje().addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());
		add(gettMensaje(),restTMensaje);

		GridBagConstraints restBEnviar =new GridBagConstraints();
		restBEnviar.gridx = 2;
		restBEnviar.gridy = 3;
		restBEnviar.weightx = gridx2weightx;
		restBEnviar.weighty = gridy3weighty;	
		restBEnviar.ipadx = 50;	
		restBEnviar.anchor = GridBagConstraints.WEST;
		restBEnviar.insets = insMargen;
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
/*
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
*/
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

