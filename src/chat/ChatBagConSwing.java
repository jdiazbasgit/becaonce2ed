package chat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;
import chat.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
@SuppressWarnings("serial")

public class ChatBagConSwing extends JFrame {

	private JButton bRegistrar, bEnviar;
	private JTextField tNick, tMensaje;
	private TextArea taMensajes, taUsuarios;
	private JLabel lNick, lUsuarios, lMensajes;

	public ChatBagConSwing() {
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
		
		setbRegistrar(new JButton("REGISTRAR"));
		GridBagConstraints restriccionesbRegistrar = new GridBagConstraints();
		restriccionesbRegistrar.gridx = 2;
		restriccionesbRegistrar.gridy = 0;
		restriccionesbRegistrar.weightx = 0.2;
		getContentPane().add(getbRegistrar(), restriccionesbRegistrar);

//Botón Enviar
		
		setbEnviar(new JButton("ENVIAR"));
		GridBagConstraints restriccionesbEnviar = new GridBagConstraints();
		restriccionesbEnviar.gridx = 2;
		restriccionesbEnviar.gridy = 3;
		getContentPane().add(getbEnviar(), restriccionesbEnviar);

//TextField Nick
		
		settNick(new JTextField());
		GridBagConstraints restriccionestNick = new GridBagConstraints();
		restriccionestNick.gridx = 1;
		restriccionestNick.gridy = 0;
		restriccionestNick.weightx = 0.8;
		restriccionestNick.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(gettNick(), restriccionestNick);
		
//TextField Mensaje
		
		settMensaje(new JTextField());
		GridBagConstraints restriccionestMensaje = new GridBagConstraints();
		restriccionestMensaje.gridx = 1;
		restriccionestMensaje.gridy = 3;
		restriccionestMensaje.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(gettMensaje(), restriccionestMensaje);
		

//TextArea Mensajes
		
		setTaMensajes(new TextArea());
		GridBagConstraints restriccionesTaMensajes = new GridBagConstraints();
		restriccionesTaMensajes.gridx = 1;
		restriccionesTaMensajes.gridy = 1;
		restriccionesTaMensajes.gridwidth = 2;
		restriccionesTaMensajes.gridheight = 2;
		restriccionesTaMensajes.fill=GridBagConstraints.BOTH;
		getContentPane().add(getTaMensajes(), restriccionesTaMensajes);

//TextArea Usuarios
		
		setTaUsuarios(new TextArea(20,1));
		GridBagConstraints restriccionesTaUsuarios = new GridBagConstraints();
		restriccionesTaUsuarios.gridx = 0;
		restriccionesTaUsuarios.gridy = 2;
		restriccionesTaUsuarios.weighty = 0.5;
		restriccionesTaUsuarios.fill=GridBagConstraints.BOTH;
		getContentPane().add(getTaUsuarios(), restriccionesTaUsuarios);

// Label Nick
		
		setlNick(new JLabel("NICK"));
		GridBagConstraints restriccioneslNick = new GridBagConstraints();
		restriccioneslNick.gridx = 0;
		restriccioneslNick.gridy = 0;
		restriccioneslNick.weightx = 0.2;
		restriccioneslNick.weighty = 0.2;
		getContentPane().add(getlNick(), restriccioneslNick);

// Label Usuarios
		
		setlUsuarios(new JLabel("USUARIOS"));
		GridBagConstraints restriccioneslUsuarios = new GridBagConstraints();
		restriccioneslUsuarios.gridx = 0;
		restriccioneslUsuarios.gridy = 1;
		restriccioneslUsuarios.weighty = 0.1;
		getContentPane().add(getlUsuarios(), restriccioneslUsuarios);

		// Label Mensajes
		setlMensajes(new JLabel("MENSAJES"));
		GridBagConstraints restriccioneslMensajes = new GridBagConstraints();
		restriccioneslMensajes.gridx = 0;
		restriccioneslMensajes.gridy = 3;
		restriccioneslMensajes.weighty = 0.2;
		getContentPane().add(getlMensajes(), restriccioneslMensajes);

	}

	public JButton getbRegistrar() {
		return bRegistrar;
	}

	public void setbRegistrar(JButton bRegistrar) {
		this.bRegistrar = bRegistrar;
	}

	public JButton getbEnviar() {
		return bEnviar;
	}

	public void setbEnviar(JButton bEnviar) {
		this.bEnviar = bEnviar;
	}

	public JTextField gettNick() {
		return this.tNick;
	}

	public void settNick(JTextField tNick) {
		this.tNick = tNick;
	}

	public JTextField gettMensaje() {
		return tMensaje;
	}

	public void settMensaje(JTextField tMensaje) {
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

	public JLabel getlNick() {
		return lNick;
	}

	public void setlNick(JLabel lNick) {
		this.lNick = lNick;
	}

	public JLabel getlUsuarios() {
		return lUsuarios;
	}

	public void setlUsuarios(JLabel lUsuarios) {
		this.lUsuarios = lUsuarios;
	}

	public JLabel getlMensajes() {
		return lMensajes;
	}

	public void setlMensajes(JLabel lMensajes) {
		this.lMensajes = lMensajes;

	}

}
