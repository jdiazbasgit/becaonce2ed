package chatPrivado;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ChatPrivado extends JFrame {

	private JButton bRegistrar, bEnviar;
	private JTextField tNick, tMensaje;
	private JTextArea taMensajes, taUsuarios;
	private JLabel lNick, lUsuarios, lMensajes;
	
	public ChatPrivado() {
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1200,800);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    setLocation(x, y);
	    
		addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		setLayout(new GridBagLayout());
		
		setTitle("Chat de Java");
		ImageIcon img = new ImageIcon("./java.png");
	    setIconImage(img.getImage());
		
		/* 1 ==========================================================*/
		setlNick(new JLabel("Apodo:"));
		GridBagConstraints restLNick =new GridBagConstraints();
		restLNick.insets = new Insets(0, 0, 0, 10);
		restLNick.gridx = 0;
		restLNick.gridy = 0;
		restLNick.weightx=0.05;
		restLNick.weighty=0.05;
		restLNick.anchor = GridBagConstraints.EAST;
		getlNick().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(getlNick(), restLNick);
		
		settNick(new JTextField(""));
		GridBagConstraints restTNick =new GridBagConstraints();
		restTNick.gridx = 1;
		restTNick.gridy = 0;
		restTNick.weightx=0.9;
		restTNick.fill = GridBagConstraints.HORIZONTAL;
		restTNick.insets = new Insets(0, 5, 0, 0);
		gettNick().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(gettNick(),restTNick);

		setbRegistrar(new JButton("Registrar"));
		GridBagConstraints restBRegistrar =new GridBagConstraints();
		restBRegistrar.gridx = 2;
		restBRegistrar.gridy = 0;
		restBRegistrar.weightx=0.05;
		restBRegistrar.ipady=5;
		restBRegistrar.ipadx=40;
		getbRegistrar().setFont(new Font("Verdana", Font.PLAIN, 15));
		getContentPane().add(getbRegistrar(),restBRegistrar);
		/* ==========================================================*/
		
		/* 2 ==========================================================*/
		setlUsuarios(new JLabel("Usuarios:"));
		GridBagConstraints restLUsuarios =new GridBagConstraints();
		restLUsuarios.gridx = 0;
		restLUsuarios.gridy = 1;
		restLUsuarios.weighty=0.05;
		getlUsuarios().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(getlUsuarios(),restLUsuarios);
		
		setTaUsuarios(new JTextArea("", 20, 1));
		GridBagConstraints restTaUsuarios =new GridBagConstraints();
		restTaUsuarios.gridx = 0;
		restTaUsuarios.gridy = 2;
		restTaUsuarios.weighty=0.55;
		restTaUsuarios.fill = GridBagConstraints.BOTH;
		getTaUsuarios().setEditable(false);
		getTaUsuarios().setFont(new Font("Verdana", Font.PLAIN, 15));
		getContentPane().add(getTaUsuarios(),restTaUsuarios);
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
		
		/* 4 ==========================================================*/
		setlMensajes(new JLabel("Mensaje:"));
		GridBagConstraints restLMensajes =new GridBagConstraints();
		restLMensajes.insets = new Insets(0, 0, 0, 10);
		restLMensajes.gridx = 0;
		restLMensajes.gridy = 3;
		restLMensajes.weighty=0.1;
		getlMensajes().setFont(new Font("Verdana", Font.PLAIN, 20));
		restLMensajes.anchor = GridBagConstraints.EAST;
		getContentPane().add(getlMensajes(),restLMensajes);

		settMensaje(new JTextField("", 0));
		GridBagConstraints restTMensaje =new GridBagConstraints();
		restTMensaje.gridx = 1;
		restTMensaje.gridy = 3;	
		restTMensaje.fill = GridBagConstraints.HORIZONTAL;
		restTMensaje.insets = new Insets(0, 5, 0, 0);
		gettMensaje().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(gettMensaje(),restTMensaje);
		
		setbEnviar(new JButton("Enviar"));
		GridBagConstraints restBEnviar =new GridBagConstraints();
		restBEnviar.gridx = 2;
		restBEnviar.gridy = 3;
		restBEnviar.ipady=5;
		restBEnviar.ipadx=50;
		getbEnviar().setFont(new Font("Verdana", Font.PLAIN, 15));
		getContentPane().add(getbEnviar(),restBEnviar);
	}
	
	public JButton getbRegistrar() {
		return bRegistrar;
	}

	public void setbRegistrar(JButton button) {
		this.bRegistrar = button;
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

	public JTextArea getTaMensajes() {
		return taMensajes;
	}

	public void setTaMensajes(JTextArea taMensajes) {
		this.taMensajes = taMensajes;
	}

	public JTextArea getTaUsuarios() {
		return taUsuarios;
	}

	public void setTaUsuarios(JTextArea taUsuarios) {
		this.taUsuarios = taUsuarios;
	}

	public JLabel getlNick() {
		return lNick;
	}

	public void setlNick(JLabel Label) {
		this.lNick = Label;
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