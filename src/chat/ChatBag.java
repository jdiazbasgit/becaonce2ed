package chat;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.FocusAdapter;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")
public class ChatBag extends Frame {
	
	
	private Button bRegistrar,bEnviar;
	private TextField tNick, tMensaje;
	private TextArea taMensajes, taUsuarios;
	private Label lNick, lUsuarios, lMensaje;
	
	
	public ChatBag() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());

		setLayout(new GridBagLayout());
		
		
		setbRegistrar(new Button ("Registrar"));
		GridBagConstraints restriccionesbRegistrar = new GridBagConstraints();
		
		getbRegistrar().setFont(new Font(Font.DIALOG,Font.BOLD,20));
		
		restriccionesbRegistrar.gridx = 2;
		restriccionesbRegistrar.gridy = 0;
		
		restriccionesbRegistrar.weightx = 0.2;		
		add(bRegistrar,restriccionesbRegistrar);
		
		
		setbEnviar(new Button("Enviar"));
		GridBagConstraints restriccionesbEnviar = new GridBagConstraints();
		
		getbEnviar().setFont(new Font(Font.DIALOG,Font.BOLD,20));
		
		restriccionesbEnviar.gridx = 2;
		restriccionesbEnviar.gridy = 3;
		
		add(bEnviar,restriccionesbEnviar);
		
		setlNick(new Label("Nick"));
		
		GridBagConstraints restriccioneslNick = new GridBagConstraints();
		
		getlNick().setFont(new Font(Font.DIALOG,Font.BOLD,20));
		
		restriccioneslNick.gridx = 0;
		restriccioneslNick.gridy = 0;
		
		restriccioneslNick.weightx = 0.2;
		restriccioneslNick.weighty = 0.2;
		
		add(lNick,restriccioneslNick);
		
		settNick(new TextField());
		GridBagConstraints restriccionestNick = new GridBagConstraints();
		
		restriccionestNick.gridx = 1;
		restriccionestNick.gridy = 0;
		
		restriccionestNick.weightx = 0.8;
		restriccionestNick.fill = GridBagConstraints.HORIZONTAL;
		add(tNick,restriccionestNick);

		settMensaje(new TextField());
		GridBagConstraints restriccionestMensaje = new GridBagConstraints();
		
		restriccionestMensaje.gridx = 1;
		restriccionestMensaje.gridy = 3;
		
		restriccionestMensaje.fill = GridBagConstraints.HORIZONTAL;
		
		add(tMensaje,restriccionestMensaje);
		
		setTaMensajes(new TextArea());
		GridBagConstraints restriccionestaMensajes = new GridBagConstraints();
		
		restriccionestaMensajes.gridx = 1;
		restriccionestaMensajes.gridy = 1;
		
		restriccionestaMensajes.gridwidth = 2;
		restriccionestaMensajes.gridheight = 2;
		restriccionestaMensajes.fill = GridBagConstraints.BOTH;
		
		add(getTaMensajes(),restriccionestaMensajes);
		
		setlUsuarios(new Label("Usuarios"));
		GridBagConstraints restriccioneslUsuarios = new GridBagConstraints();
		
		restriccioneslUsuarios.gridx = 0;
		restriccioneslUsuarios.gridy = 1;
		
		restriccioneslUsuarios.weighty = 0.1;
		
		add(lUsuarios,restriccioneslUsuarios);
		
		setTaUsuarios(new TextArea());
		GridBagConstraints restriccionestaUsuarios = new GridBagConstraints();
		
		restriccionestaUsuarios.gridx = 0;
		restriccionestaUsuarios.gridy = 2;
		
		restriccionestaUsuarios.weighty = 0.5;
		
		restriccionestaUsuarios.fill = GridBagConstraints.BOTH;
		
		add(taUsuarios,restriccionestaUsuarios);
		
		setlMensaje(new Label("Mensaje"));
		GridBagConstraints restriccioneslMensaje = new GridBagConstraints();
		
		restriccioneslMensaje.gridx = 0;
		restriccioneslMensaje.gridy = 3;
		
		restriccioneslMensaje.weighty = 0.2;
		
		add(lMensaje,restriccioneslMensaje);
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


	public Label getlMensaje() {
		return lMensaje;
	}


	public void setlMensaje(Label lMensaje) {
		this.lMensaje = lMensaje;
	}
	

}
