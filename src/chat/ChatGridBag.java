package chat;

import java.awt.Font;
import java.awt.BorderLayout;
//import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
//import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;

import chat.eventos.ElQueSabeLoQueHayQueHacerConElBoton;
import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;
import lombok.Data;

@SuppressWarnings("serial")

public class ChatGridBag extends JFrame {

	private JButton BRegistrar, BEnviar;
	private JTextField TNick, TMensaje;
	private JTextArea TaMensajes;
	private JLabel LNick, LUsuarios, LMensaje;

	private JList<String> ListUsuarios;
	
	public ChatGridBag() {
		//setSize(1200,800);
		addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		//setLayout(new BorderLayout());
		//Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		//setSize(tamanoActualizableFrame.width / 2, tamanoActualizableFrame.height / 2);
		//setLocation(tamanoActualizableFrame.width / 4, tamanoActualizableFrame.height / 4);
		// System.out.println(tamanoActualizableFrame);

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setLayout(new GridBagLayout());
		
		setTitle("Chat de Java");
		ImageIcon img = new ImageIcon("./java.png");
	    setIconImage(img.getImage());
	    

		/* 1 ==========================================================*/
		setLNick(new JLabel("Usuario:"));
		GridBagConstraints restLNick =new GridBagConstraints();
		restLNick.insets = new Insets(0, 0, 0, 10);
		restLNick.gridx = 0;
		restLNick.gridy = 0;
		restLNick.weightx=0.05;
		restLNick.weighty=0.05;
		restLNick.anchor = GridBagConstraints.EAST;
		getLNick().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(getLNick(), restLNick);
		
		setTNick(new JTextField(""));
		GridBagConstraints restTNick =new GridBagConstraints();
		restTNick.gridx = 1;
		restTNick.gridy = 0;
		restTNick.weightx=0.9;
		restTNick.fill = GridBagConstraints.HORIZONTAL;
		restTNick.insets = new Insets(0, 5, 0, 0);
		getTNick().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(getTNick(),restTNick);

		setBRegistrar(new JButton("Registrar"));
		GridBagConstraints restBRegistrar =new GridBagConstraints();
		restBRegistrar.gridx = 2;
		restBRegistrar.gridy = 0;
		restBRegistrar.weightx=0.05;
		restBRegistrar.ipady=5;
		restBRegistrar.ipadx=40;
		getBRegistrar().setFont(new Font("Verdana", Font.PLAIN, 15));
		getBRegistrar().addActionListener(new ElQueSabeLoQueHayQueHacerConElBoton(this));
		getContentPane().add(getBRegistrar(),restBRegistrar);
		/* ==========================================================*/
				
		
		/* 2 ==========================================================*/
		setLUsuarios(new JLabel("Usuarios:"));
		setListUsuarios(new JList<>());
		
		GridBagConstraints restLUsuarios =new GridBagConstraints();
		restLUsuarios.gridx = 0;
		restLUsuarios.gridy = 1;
		restLUsuarios.weighty=0.05;
		getLUsuarios().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(getLUsuarios(),restLUsuarios);
		GridBagConstraints restTaUsuarios =new GridBagConstraints();
		restTaUsuarios.gridx = 0;
		restTaUsuarios.gridy = 2;
		restTaUsuarios.weighty=0.55;
		restTaUsuarios.fill = GridBagConstraints.BOTH;
		getListUsuarios().setFont(new Font("Verdana", Font.PLAIN, 15));
		getContentPane().add(getListUsuarios(),restTaUsuarios);
		/* ==========================================================*/
		
		
		/* 3 ==========================================================*/
		setTaMensajes(new JTextArea());
		GridBagConstraints restTaMensajes =new GridBagConstraints();
		restTaMensajes.gridx = 1;
		restTaMensajes.gridy = 1;
		restTaMensajes.gridwidth=2;
		restTaMensajes.gridheight=2;
		restTaMensajes.insets = new Insets(0, 5, 0, 0);
		restTaMensajes.fill = GridBagConstraints.BOTH;
		getTaMensajes().setEditable(false);
		getTaMensajes().setFont(new Font("Verdana", Font.PLAIN, 15));
		getContentPane().add(getTaMensajes(),restTaMensajes);
		/* ==========================================================*/

	}

	public JButton getBRegistrar() {
		return BRegistrar;
	}

	public void setBRegistrar(JButton bRegistrar) {
		BRegistrar = bRegistrar;
	}

	public JButton getBEnviar() {
		return BEnviar;
	}

	public void setBEnviar(JButton bEnviar) {
		BEnviar = bEnviar;
	}

	public JTextField getTNick() {
		return TNick;
	}

	public void setTNick(JTextField tNick) {
		TNick = tNick;
	}

	public JTextField getTMensaje() {
		return TMensaje;
	}

	public void setTMensaje(JTextField tMensaje) {
		TMensaje = tMensaje;
	}

	public JTextArea getTaMensajes() {
		return TaMensajes;
	}

	public void setTaMensajes(JTextArea taMensajes) {
		TaMensajes = taMensajes;
	}

	public JLabel getLNick() {
		return LNick;
	}

	public void setLNick(JLabel lNick) {
		LNick = lNick;
	}

	public JLabel getLUsuarios() {
		return LUsuarios;
	}

	public void setLUsuarios(JLabel lUsuarios) {
		LUsuarios = lUsuarios;
	}

	public JLabel getLMensaje() {
		return LMensaje;
	}

	public void setLMensaje(JLabel lMensaje) {
		LMensaje = lMensaje;
	}

	public JList<String> getListUsuarios() {
		return ListUsuarios;
	}

	public void setListUsuarios(JList<String> listUsuarios) {
		ListUsuarios = listUsuarios;
	}

	
}