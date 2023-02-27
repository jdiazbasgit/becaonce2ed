package chatPrivado;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javafx.scene.paint.Color;

import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ChatPrivado extends JFrame {

	private JButton BRegistrar, BEnviar, BEnviarPrivado;
	private JTextField TNick, TMensaje;
	private JTextArea TaMensajes;
	private JLabel LNick, LUsuarios, LMensajes, LPrivado;
	private JList<String> ListUsuarios;
	
	DefaultListModel<String> Usuarios = new DefaultListModel<String>();
	
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
		
		settNick(new JTextField(""));
		GridBagConstraints restTNick =new GridBagConstraints();
		restTNick.gridx = 1;
		restTNick.gridy = 0;
		restTNick.weightx=0.9;
		restTNick.fill = GridBagConstraints.HORIZONTAL;
		restTNick.insets = new Insets(0, 5, 0, 0);
		gettNick().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(gettNick(),restTNick);

		setBRegistrar(new JButton("Registrar"));
		GridBagConstraints restBRegistrar =new GridBagConstraints();
		restBRegistrar.gridx = 2;
		restBRegistrar.gridy = 0;
		restBRegistrar.weightx=0.05;
		restBRegistrar.ipady=5;
		restBRegistrar.ipadx=40;
		getBRegistrar().setFont(new Font("Verdana", Font.PLAIN, 15));
		getContentPane().add(getBRegistrar(),restBRegistrar);
		/* ==========================================================*/
		
		/* 2 ==========================================================*/			
		setLUsuarios(new JLabel("Usuarios:"));
		GridBagConstraints restLUsuarios =new GridBagConstraints();
		restLUsuarios.gridx = 0;
		restLUsuarios.gridy = 1;
		restLUsuarios.weighty=0.05;
		getLUsuarios().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(getLUsuarios(),restLUsuarios);
			
		setListUsuarios(new JList<>(Usuarios));
		GridBagConstraints restTaUsuarios =new GridBagConstraints();
		restTaUsuarios.gridx = 0;
		restTaUsuarios.gridy = 2;
		restTaUsuarios.weighty=0.50;
		restTaUsuarios.fill = GridBagConstraints.BOTH;
		getListUsuarios().setFont(new Font("Verdana", Font.PLAIN, 15));
		getContentPane().add(getListUsuarios(),restTaUsuarios);
		
		setLPrivado(new JLabel("Privado"));
		GridBagConstraints restLPrivado =new GridBagConstraints();
		restLPrivado.gridx = 0;
		restLPrivado.gridy = 3;
		restLPrivado.weighty=0.05;
		getLPrivado().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(getLPrivado(),restLPrivado);
		
		Choice ChoiceUsuarioPrivado = new Choice();   
		ChoiceUsuarioPrivado.add("....");    
		ChoiceUsuarioPrivado.add("....");
		GridBagConstraints restCPrivado =new GridBagConstraints();
		restCPrivado.gridx = 0;
		restCPrivado.gridy = 4;
		restCPrivado.weighty=0.05;
		ChoiceUsuarioPrivado.setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(ChoiceUsuarioPrivado,restCPrivado);
		
		
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
		setLMensajes(new JLabel("Mensaje:"));
		GridBagConstraints restLMensajes =new GridBagConstraints();
		restLMensajes.insets = new Insets(0, 0, 0, 10);
		restLMensajes.gridx = 0;
		restLMensajes.gridy = 5;
		restLMensajes.weighty=0.1;
		getLMensajes().setFont(new Font("Verdana", Font.PLAIN, 20));
		restLMensajes.anchor = GridBagConstraints.EAST;
		getContentPane().add(getLMensajes(),restLMensajes);

		setTMensaje(new JTextField("", 0));
		GridBagConstraints restTMensaje =new GridBagConstraints();
		restTMensaje.gridx = 1;
		restTMensaje.gridy = 5;	
		restTMensaje.fill = GridBagConstraints.HORIZONTAL;
		restTMensaje.insets = new Insets(0, 5, 0, 0);
		getTMensaje().setFont(new Font("Verdana", Font.PLAIN, 20));
		getContentPane().add(getTMensaje(),restTMensaje);
		
		setBEnviar(new JButton("Enviar"));
		GridBagConstraints restBEnviar =new GridBagConstraints();
		restBEnviar.gridx = 2;
		restBEnviar.gridy = 5;
		restBEnviar.ipady=5;
		restBEnviar.ipadx=50;
		getBEnviar().setFont(new Font("Verdana", Font.PLAIN, 15));
		getContentPane().add(getBEnviar(),restBEnviar);
	}
	
	public JButton getBRegistrar() {
		return BRegistrar;
	}

	public void setBRegistrar(JButton button) {
		this.BRegistrar = button;
	}

	public JButton getBEnviar() {
		return BEnviar;
	}

	public void setBEnviar(JButton bEnviar) {
		this.BEnviar = bEnviar;
	}

	public JTextField gettNick() {
		return TNick;
	}

	public void settNick(JTextField tNick) {
		this.TNick = tNick;
	}

	public JTextField getTMensaje() {
		return TMensaje;
	}

	public void setTMensaje(JTextField tMensaje) {
		this.TMensaje = tMensaje;
	}

	public JTextArea getTaMensajes() {
		return TaMensajes;
	}

	public void setTaMensajes(JTextArea taMensajes) {
		this.TaMensajes = taMensajes;
	}

	public JLabel getLNick() {
		return LNick;
	}

	public void setLNick(JLabel Label) {
		this.LNick = Label;
	}

	public JLabel getLUsuarios() {
		return LUsuarios;
	}

	public void setLUsuarios(JLabel lUsuarios) {
		this.LUsuarios = lUsuarios;
	}

	public JLabel getLMensajes() {
		return LMensajes;
	}

	public void setLMensajes(JLabel lMensajes) {
		this.LMensajes = lMensajes;
	}

	public JButton getBEnviarPrivado() {
		return BEnviarPrivado;
	}

	public void setBEnviarPrivado(JButton bEnviarPrivado) {
		BEnviarPrivado = bEnviarPrivado;
	}

	public JList<String> getListUsuarios() {
		return ListUsuarios;
	}

	public void setListUsuarios(JList<String> listUsuarios) {
		ListUsuarios = listUsuarios;
	}

	public JLabel getLPrivado() {
		return LPrivado;
	}

	public void setLPrivado(JLabel lPrivado) {
		LPrivado = lPrivado;
	}
}