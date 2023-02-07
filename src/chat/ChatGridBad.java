package chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import chat.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")

public class ChatGridBad extends JFrame {

	private JButton bRegistrar, bEnviar;
	private JTextField tNick, tMensaje;
	private TextArea taMensajes, taUsuarios;
	private JLabel lNick, lUsuarios, lMensaje;

	public ChatGridBad() {

		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		this.setLayout(new BorderLayout());
		Dimension tamanoActualizableFrame = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(tamanoActualizableFrame.width / 2, tamanoActualizableFrame.height / 2);
		setLocation(tamanoActualizableFrame.width / 4, tamanoActualizableFrame.height / 4);
		System.out.println(tamanoActualizableFrame);

		//setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.setLayout(new GridBagLayout());
		
		

		// ---Primera zona-------------------------

		this.setlNick(new JLabel("Nick:   "));
		this.settNick(new JTextField("Escribe cómo te verán los demás", 0));
		this.setbRegistrar(new JButton("REGISTRAR"));
		gettNick().addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());

		GridBagConstraints gbcLabelNick = new GridBagConstraints();
		GridBagConstraints gcbTextFieldNick = new GridBagConstraints();
		GridBagConstraints gbcButtonRegistrar = new GridBagConstraints();
		gbcLabelNick.gridx = 0;
		gbcLabelNick.gridy = 0;
		gbcLabelNick.weightx = 0.2;
		gbcLabelNick.weighty = 0.2;
		gbcLabelNick.anchor = GridBagConstraints.EAST;
		
		gcbTextFieldNick.gridx = 1;
		gcbTextFieldNick.gridy = 0;
		gcbTextFieldNick.weightx = 0.6;
		gcbTextFieldNick.fill = GridBagConstraints.HORIZONTAL;
		//Insets margenDechaDv4 = new Insets(0, 0, 0, tamanoActualizableFrame.width / 4);
		//gcbTextFieldNick.insets = margenDechaDv4;
		//gcbTextFieldNick.gridwidth = 2;

		gbcButtonRegistrar.gridx = 2;
		gbcButtonRegistrar.gridy = 0;
		gbcButtonRegistrar.weightx = 0.2;
		gbcButtonRegistrar.anchor = GridBagConstraints.WEST;
		Insets margenDechaDv7 = new Insets(0, 10, 0, tamanoActualizableFrame.width / 7);
		gbcButtonRegistrar.insets = margenDechaDv7;
		
		getContentPane().add(getlNick(), gbcLabelNick);
		getContentPane().add(gettNick(), gcbTextFieldNick);
		getContentPane().add(getbRegistrar(), gbcButtonRegistrar);

		// ---Segunda zona----------------------------

		this.setlUsuarios(new JLabel("Usuarios:"));
		this.setTaMensajes(new TextArea("Lista de mensajes, panel principal", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY));

		GridBagConstraints gbcLabelUsuarios = new GridBagConstraints();
		GridBagConstraints gcbTextAreaMensajes = new GridBagConstraints();
		gbcLabelUsuarios.gridx = 0;
		gbcLabelUsuarios.gridy = 1;
		gbcLabelUsuarios.weighty = 0.1;
		gbcLabelUsuarios.anchor = GridBagConstraints.SOUTH;

		gcbTextAreaMensajes.gridx = 1;
		gcbTextAreaMensajes.gridy = 1;
		gcbTextAreaMensajes.weighty = 0.1;
		gcbTextAreaMensajes.gridwidth = 2;
		gcbTextAreaMensajes.gridheight = 2;
		gcbTextAreaMensajes.fill = GridBagConstraints.BOTH;

		getContentPane().add(getlUsuarios(), gbcLabelUsuarios);
		getContentPane().add(getTaMensajes(), gcbTextAreaMensajes);

		this.setTaUsuarios(new TextArea("", 30, 1, TextArea.SCROLLBARS_VERTICAL_ONLY));

		GridBagConstraints gcbTextAreaUsuarios = new GridBagConstraints();
		gcbTextAreaUsuarios.gridx = 0;
		gcbTextAreaUsuarios.gridy = 2;
		gcbTextAreaUsuarios.weighty = 0.5;
		gcbTextAreaUsuarios.fill = GridBagConstraints.BOTH;

		getContentPane().add(getTaUsuarios(), gcbTextAreaUsuarios);

		// ---Tercera zona----------------------------

		this.setlMensaje(new JLabel("Mensaje:   "));
		this.settMensaje(new JTextField("Escribe un mensaje", 60));
		this.setbEnviar(new JButton("ENVIAR"));
		gettMensaje().addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());

		GridBagConstraints gbcLabelMensaje = new GridBagConstraints();
		GridBagConstraints gcbTextFieldMensaje = new GridBagConstraints();
		GridBagConstraints gbcButtonEnviar = new GridBagConstraints();
		gbcLabelMensaje.gridx = 0;
		gbcLabelMensaje.gridy = 3;
		gbcLabelMensaje.weighty = 0.2;
		gbcLabelMensaje.anchor = GridBagConstraints.EAST;
		

		gcbTextFieldMensaje.gridx = 1;
		gcbTextFieldMensaje.gridy = 3;
		gcbTextFieldMensaje.weighty = 0.2;
		gcbTextFieldMensaje.fill = GridBagConstraints.HORIZONTAL;
		//gcbTextFieldMensaje.gridwidth = 2;
		

		gbcButtonEnviar.gridx = 2;
		gbcButtonEnviar.gridy = 3;
		gbcButtonEnviar.weighty = 0.2;
		gbcButtonEnviar.anchor = GridBagConstraints.WEST;
		Insets margenDechaDv12 = new Insets(0, 10, 0, tamanoActualizableFrame.width / 18);
		gbcButtonEnviar.insets = margenDechaDv12;

		getContentPane().add(getlMensaje(), gbcLabelMensaje);
		getContentPane().add(gettMensaje(), gcbTextFieldMensaje);
		getContentPane().add(getbEnviar(), gbcButtonEnviar);

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
		return tNick;
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

	public JLabel getlMensaje() {
		return lMensaje;
	}

	public void setlMensaje(JLabel lMensaje) {
		this.lMensaje = lMensaje;
	}

}
