package chat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import chat.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")

public class ChatBagSwing extends JFrame {

	private JButton bRegistrar, bEnviar;
	private JTextField tNick, tMensaje;
	private TextArea taMensajes, taUsuarios;
	private JLabel lNick, lUsuarios, lMensajes;

	public ChatBagSwing() {

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
		//setbRegistrar(new JButton("Registrar"));
		setbRegistrar(new JButton(new ImageIcon("iconoRegistrar.png")));
		setbEnviar(new JButton("Enviar"));
		
		settNick(new JTextField("Nombre...", 40));
		settMensaje(new JTextField("Comentar...", 0));
		
		setTaMensajes(new TextArea("Area de mensajes"));
		setTaUsuarios(new TextArea("Lista de usuarios", 20, 1));
		
		setlNick(new JLabel("Nick:"));
		setlUsuarios(new JLabel("Usuarios:"));
		setlMensajes(new JLabel("Mensaje:"));
		
		Double gridx0weightx = 0.1;
		Double gridx1weightx = 0.8;
		Double gridx2weightx = 0.1;

		Double gridy0weighty = 0.1;
		Double gridy1weighty = 0.05;
		Double gridy2weighty = 0.75;
		Double gridy3weighty = 0.1;
		
		Insets insMargen = new Insets(5, 10, 5, 10);

		setLayout(new GridBagLayout());
		
		GridBagConstraints restLNick = new GridBagConstraints();
		restLNick.gridx = 0;
		restLNick.gridy = 0;
		restLNick.weightx = gridx0weightx;
		restLNick.weighty = gridy0weighty;
		restLNick.ipadx = 20;
		restLNick.anchor = GridBagConstraints.EAST;
		restLNick.insets = insMargen;
		getContentPane().add(getlNick(),restLNick);

		GridBagConstraints restTNick = new GridBagConstraints();
		restTNick.gridx = 1;
		restTNick.gridy = 0;
		restTNick.weightx = gridx1weightx;
		//restTNick.weighty = gridy0weighty;
		restTNick.anchor = GridBagConstraints.WEST;
		restTNick.insets = insMargen;
		gettNick().addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());
		getContentPane().add(gettNick(),restTNick);

		GridBagConstraints restBRegistrar = new GridBagConstraints();
		restBRegistrar.gridx = 2;
		restBRegistrar.gridy = 0;
		restBRegistrar.weightx = gridx2weightx;
		//restBRegistrar.weighty = gridy0weighty;
		restBRegistrar.ipadx = 20;
		restBRegistrar.anchor = GridBagConstraints.WEST;
		restBRegistrar.insets = insMargen;
		getContentPane().add(getbRegistrar(),restBRegistrar);

		GridBagConstraints restLUsuarios = new GridBagConstraints();
		restLUsuarios.gridx = 0;
		restLUsuarios.gridy = 1;
		//restLUsuarios.weightx = gridx0weightx;
		restLUsuarios.weighty = gridy1weighty;
		restLUsuarios.insets = insMargen;
		getContentPane().add(getlUsuarios(),restLUsuarios);

		GridBagConstraints restTaUsuarios = new GridBagConstraints();
		restTaUsuarios.gridx = 0;
		restTaUsuarios.gridy = 2;
		//restTaUsuarios.weightx = gridx0weightx;
		restTaUsuarios.weighty = gridy2weighty;
		restTaUsuarios.fill = GridBagConstraints.BOTH;
		restTaUsuarios.insets = insMargen;
		getContentPane().add(getTaUsuarios(),restTaUsuarios);

		GridBagConstraints restTaMensajes = new GridBagConstraints();
		restTaMensajes.gridx = 1;
		restTaMensajes.gridy = 1;
		//restTaMensajes.weightx = gridx1weightx + gridx2weightx;
		//restTaMensajes.weighty = gridy1weighty + gridy2weighty;
		restTaMensajes.gridwidth = 2;
		restTaMensajes.gridheight = 2;
		restTaMensajes.fill = GridBagConstraints.BOTH;
		restTaMensajes.insets = insMargen;
		getContentPane().add(getTaMensajes(),restTaMensajes);

		GridBagConstraints restLMensajes = new GridBagConstraints();
		restLMensajes.gridx = 0;
		restLMensajes.gridy = 3;
		//restLMensajes.weightx = gridx0weightx;
		restLMensajes.weighty = gridy3weighty;
		restLMensajes.ipadx = 50;
		restLMensajes.anchor = GridBagConstraints.EAST;
		restLMensajes.insets = insMargen;
		getContentPane().add(getlMensajes(),restLMensajes);

		GridBagConstraints restTMensaje = new GridBagConstraints();
		restTMensaje.gridx = 1;
		restTMensaje.gridy = 3;
		//restTMensaje.weightx = gridx1weightx;
		//restTMensaje.weighty = gridy3weighty;
		restTMensaje.fill = GridBagConstraints.HORIZONTAL;
		restTMensaje.insets = insMargen;
		gettMensaje().addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());
		getContentPane().add(gettMensaje(),restTMensaje);

		GridBagConstraints restBEnviar = new GridBagConstraints();
		restBEnviar.gridx = 2;
		restBEnviar.gridy = 3;
		//restBEnviar.weightx = gridx2weightx;
		//restBEnviar.weighty = gridy3weighty;
		restBEnviar.ipadx = 50;
		restBEnviar.anchor = GridBagConstraints.WEST;
		restBEnviar.insets = insMargen;
		getContentPane().add(getbEnviar(),restBEnviar);

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

	public JLabel getlMensajes() {
		return lMensajes;
	}

	public void setlMensajes(JLabel lMensajes) {
		this.lMensajes = lMensajes;
	}

}

