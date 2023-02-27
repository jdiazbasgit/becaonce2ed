package chat;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;
import chat.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
@SuppressWarnings("serial")

public class ChatBag extends Frame {

	private Choice ChSeleccionarUsuario;
	private Button bRegistrar, bEnviar,bConfirmarUsuarios;
	private TextField tNick, tMensaje;
	private TextArea taMensajes, taUsuarios;
	private Label lNick, lUsuarios, lMensajes,lPrivado;

	public ChatBag() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		/*
		 * Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
		 * setSize(dimension.width/2,dimension.height/2);
		 * setLocation(dimension.width/4,dimension.height/4);
		 */
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		this.addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());
		setLayout(new GridBagLayout());

//Botón Registrar
		
		setbRegistrar(new Button("REGISTRAR"));
		GridBagConstraints restriccionesbRegistrar = new GridBagConstraints();
		restriccionesbRegistrar.gridx = 2;
		restriccionesbRegistrar.gridy = 0;
		restriccionesbRegistrar.weightx = 0.2;
		add(getbRegistrar(), restriccionesbRegistrar);

//Botón Enviar
		
		setbEnviar(new Button("ENVIAR"));
		GridBagConstraints restriccionesbEnviar = new GridBagConstraints();
		restriccionesbEnviar.gridx = 2;
		restriccionesbEnviar.gridy = 6;
		add(getbEnviar(), restriccionesbEnviar);

//TextField Nick
		
		settNick(new TextField());
		GridBagConstraints restriccionestNick = new GridBagConstraints();
		restriccionestNick.gridx = 1;
		restriccionestNick.gridy = 0;
		restriccionestNick.weightx = 0.8;
		restriccionestNick.fill = GridBagConstraints.HORIZONTAL;
		add(gettNick(), restriccionestNick);
		
//TextField Mensaje
		
		settMensaje(new TextField());
		GridBagConstraints restriccionestMensaje = new GridBagConstraints();
		restriccionestMensaje.gridx = 1;
		restriccionestMensaje.gridy = 6;
		restriccionestMensaje.fill = GridBagConstraints.HORIZONTAL;
		add(gettMensaje(), restriccionestMensaje);
		
		setTaMensajes(new TextArea());
		GridBagConstraints restriccionesTaMensajes = new GridBagConstraints();
		restriccionesTaMensajes.gridx = 1;
		restriccionesTaMensajes.gridy = 1;
		restriccionesTaMensajes.gridwidth = 2;
		restriccionesTaMensajes.gridheight = 2;
		restriccionesTaMensajes.fill=GridBagConstraints.BOTH;
		add(getTaMensajes(), restriccionesTaMensajes);
		
		setlNick(new Label("NICK"));
		GridBagConstraints restriccioneslNick = new GridBagConstraints();
		restriccioneslNick.gridx = 0;
		restriccioneslNick.gridy = 0;
		restriccioneslNick.weightx = 0.2;
		restriccioneslNick.weighty = 0.2;
		add(getlNick(), restriccioneslNick);

		setlMensajes(new Label("MENSAJES"));
		GridBagConstraints restriccioneslMensajes = new GridBagConstraints();
		restriccioneslMensajes.gridx = 0;
		restriccioneslMensajes.gridy = 6;
		restriccioneslMensajes.weighty = 0.2;
		add(getlMensajes(), restriccioneslMensajes);
		
		setlUsuarios(new Label("USUARIOS"));
		GridBagConstraints restriccioneslUsuarios = new GridBagConstraints();
		restriccioneslUsuarios.gridx = 0;
		restriccioneslUsuarios.gridy = 1;
		restriccioneslUsuarios.weighty = 0.1;
		add(getlUsuarios(), restriccioneslUsuarios);

		setlPrivado(new Label("PRIVATE"));
		GridBagConstraints restriccioneslPrivado = new GridBagConstraints();
		restriccioneslMensajes.gridx = 0;
		restriccioneslMensajes.gridy = 3;
		restriccioneslMensajes.weighty = 0.1;
		add(getlPrivado(), restriccioneslPrivado);
		
		setbConfirmarUsuarios(new Button("CONFIRMAR"));
		GridBagConstraints restriccionesbConfirmarUsuarios = new GridBagConstraints();
		restriccionesbConfirmarUsuarios.gridx = 0;
		restriccionesbConfirmarUsuarios.gridy = 5;
		restriccionesbConfirmarUsuarios.weighty = 0.1;
		add(getbConfirmarUsuarios(), restriccionesbConfirmarUsuarios);
		
		setChSeleccionarUsuario(new Choice());
		GridBagConstraints restriccionesChSeleccionarUsuario = new GridBagConstraints();
		restriccionesChSeleccionarUsuario.gridx = 0;
		restriccionesChSeleccionarUsuario.gridy = 4;
		restriccionesChSeleccionarUsuario.weighty = 0.15;
		add(getChSeleccionarUsuario(), restriccionesChSeleccionarUsuario);
		
		setTaUsuarios(new TextArea(20,1));
		GridBagConstraints restriccionesTaUsuarios = new GridBagConstraints();
		restriccionesTaUsuarios.gridx = 0;
		restriccionesTaUsuarios.gridy = 2;
		restriccionesTaUsuarios.weighty = 0.15;
		restriccionesTaUsuarios.fill=GridBagConstraints.BOTH;
		add(getTaUsuarios(), restriccionesTaUsuarios);
	}

	private void addMouseListener() {
		
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
		return this.tNick;
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

	public Label getlPrivado() {
		return lPrivado;
	}

	public void setlPrivado(Label lPrivado) {
		this.lPrivado = lPrivado;
	}

	public Button getbConfirmarUsuarios() {
		return bConfirmarUsuarios;
	}

	public void setbConfirmarUsuarios(Button bConfirmarUsuarios) {
		this.bConfirmarUsuarios = bConfirmarUsuarios;
	}

	public Choice getChSeleccionarUsuario() {
		return ChSeleccionarUsuario;
	}

	public void setChSeleccionarUsuario(Choice chSeleccionarUsuario) {
		ChSeleccionarUsuario = chSeleccionarUsuario;
	}

}
