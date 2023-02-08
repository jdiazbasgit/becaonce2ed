package chat;

import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;
import chat.eventos.ElQueSabeLoQueHayQueHacerConElRaton;

@SuppressWarnings({ "serial", "unused" })

public class ChatBag extends Frame {

	private Button bRegistrar, bEnviar;
	private TextField tNick, tMensaje;
	// private Panel pSuperior, pInferior, pIzquierda, pIzquierdaSuperior;
	private TextArea taMensajes, taUsuarios;
	private Label lNick, lUsuarios, lMensajes;

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
		
		//BUTTON REGISTRAR

		setbRegistrar(new Button("REGISTRAR"));
		GridBagConstraints restriccionesbRegistrar = new GridBagConstraints();
		restriccionesbRegistrar.gridx = 2;
		restriccionesbRegistrar.gridy = 0;
		restriccionesbRegistrar.weightx = 0.2;
		// restriccionesbRegistrar.weighty = 0.2;
		add(getbRegistrar(), restriccionesbRegistrar);
		
		//BUTTON ENVIAR

		setbEnviar(new Button("ENVIAR"));
		GridBagConstraints restriccionesbEnviar = new GridBagConstraints();
		restriccionesbEnviar.gridx = 2;
		restriccionesbEnviar.gridy = 3;
		// restriccionesbEnviar.weightx = 0.25;
		// restriccionesbEnviar.weighty = 0.2;
		add(getbEnviar(), restriccionesbEnviar);
		
		//TextField NICK

		settNick(new TextField());
		GridBagConstraints restriccionestNick = new GridBagConstraints();
		restriccionestNick.gridx = 1;
		restriccionestNick.gridy = 0;
		restriccionestNick.weightx = 0.8;
		// restriccionestNick.weighty = 0.2;
		restriccionestNick.fill = GridBagConstraints.HORIZONTAL;
		add(gettNick(), restriccionestNick);
		
		//TextField MENSAJE

		settMensaje(new TextField());
		GridBagConstraints restriccionestMensaje = new GridBagConstraints();
		restriccionestMensaje.gridx = 1;
		restriccionestMensaje.gridy = 3;
		// restriccionestMensaje.weightx = 0.5;
		//restriccionestMensaje.weighty = 0.2;
		restriccionestMensaje.fill = GridBagConstraints.HORIZONTAL;
		add(gettMensaje(), restriccionestMensaje);
		
		//TextArea MENSAJES

		setTaMensajes(new TextArea());
		GridBagConstraints restriccionesTaMensajes = new GridBagConstraints();
		restriccionesTaMensajes.gridx = 1;
		restriccionesTaMensajes.gridy = 1;
		restriccionesTaMensajes.gridwidth = 2;
		restriccionesTaMensajes.gridheight = 2;
		restriccionesTaMensajes.fill = GridBagConstraints.BOTH;
		add(getTaMensajes(), restriccionesTaMensajes);
		
		//TextArea USUARIOS

		setTaUsuarios(new TextArea(30, 1));
		GridBagConstraints restriccionesTaUsuarios = new GridBagConstraints();
		restriccionesTaUsuarios.gridx = 0;
		restriccionesTaUsuarios.gridy = 2;
		//restriccionesTaUsuarios.weightx = 0.5;
		//restriccionesTaUsuarios.weighty = 0.5;
		restriccionesTaUsuarios.fill = GridBagConstraints.BOTH;
		add(getTaUsuarios(), restriccionesTaUsuarios);
		
		//Label NICK

		setlNick(new Label("NICK"));
		GridBagConstraints restriccioneslNick = new GridBagConstraints();
		restriccioneslNick.gridx = 0;
		restriccioneslNick.gridy = 0;
		restriccioneslNick.weightx = 0.2;
		restriccioneslNick.weighty = 0.2;
		add(getlNick(), restriccioneslNick);
		
		//Label USUARIOS

		setlUsuarios(new Label("USUARIOS"));
		GridBagConstraints restriccioneslUsuarios = new GridBagConstraints();
		restriccioneslUsuarios.gridx = 0;
		restriccioneslUsuarios.gridy = 1;
		//restriccioneslUsuarios.weightx = 1;
		restriccioneslUsuarios.weighty = 0.1;
		add(getlUsuarios(), restriccioneslUsuarios);
		
		//Label MENSAJES

		setlMensajes(new Label("MENSAJE"));
		GridBagConstraints restriccioneslMensajes = new GridBagConstraints();
		restriccioneslMensajes.gridx = 0;
		restriccioneslMensajes.gridy = 3;
		//restriccioneslMensajes.weightx = 0.2;
		restriccioneslMensajes.weighty = 0.2;
		add(getlMensajes(), restriccioneslMensajes);

		// componentes

	}

	private void addMouseListener() {
		// TODO Auto-generated method stub
		
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

}
