package chat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

//import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")

public class EjemploBag extends JFrame {

	private JButton botonRegistrar, botonEnviar;
	private JTextField textNick, textMensaje;
	private JPanel pSuperior, pInferior, pIzquierda, pIzquierdaSuperior;
	private TextArea TextAreaMensajes, TextAreaUsuario;
	private JLabel JLabelNick, JLabelUsuarios, lMensajes;

	public EjemploBag() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
		setbotonRegistrar(new JButton("Registrar"));
		setbotonEnviar(new JButton("Enviar"));
		
		settextNick(new JTextField("Escribe tu nombre, k_p_llo", 0));
		settextMensaje(new JTextField("Escribe aqui tu mensaje pelele", 0));
		
		setTextAreaMensajes(new TextArea());
		setTextAreaUsuario(new TextArea(30,1));
		
		setJLabelNick(new JLabel("Nickname: "));
		setJLabelUsuarios(new JLabel("Usuarios: "));
		setlMensajes(new JLabel("Mensaje: "));
		setTitle("Whatsaaaaaaaaap!");
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints restJLabelNick =new GridBagConstraints();
		restJLabelNick.gridx = 0;
		restJLabelNick.gridy = 0;
		restJLabelNick.weightx=0.1;
		restJLabelNick.weighty=0.2;		
		add(getJLabelNick(),restJLabelNick);

		GridBagConstraints resttextNick =new GridBagConstraints();
		resttextNick.gridx = 1;
		resttextNick.gridy = 0;
		resttextNick.weightx=0.8;
		//resttextNick.weighty=0.2;
		resttextNick.fill=GridBagConstraints.HORIZONTAL;
		add(gettextNick(),resttextNick);

		//setbotonRegistrar(new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("icon.png"))));
		GridBagConstraints restbotonRegistrar =new GridBagConstraints();
		restbotonRegistrar.gridx = 2;
		restbotonRegistrar.gridy = 0;
		restbotonRegistrar.weightx=0.1;
		//restbotonRegistrar.weighty=0.2;		
		add(getbotonRegistrar(),restbotonRegistrar);

		GridBagConstraints restJLabelUsuarios =new GridBagConstraints();
		restJLabelUsuarios.gridx = 0;
		restJLabelUsuarios.gridy = 1;
		//restJLabelUsuarios.weightx=0.3;
		restJLabelUsuarios.weighty=0.05;		
		add(getJLabelUsuarios(),restJLabelUsuarios);

		GridBagConstraints restTextAreaUsuario =new GridBagConstraints();
		restTextAreaUsuario.gridx = 0;
		restTextAreaUsuario.gridy = 2;
		//restTextAreaUsuario.weightx=0.3;
		restTextAreaUsuario.weighty=0.55;		
		restTextAreaUsuario.fill= GridBagConstraints.BOTH;
		add(getTextAreaUsuario(),restTextAreaUsuario);

		GridBagConstraints restTextAreaMensajes =new GridBagConstraints();
		restTextAreaMensajes.gridx = 1;
		restTextAreaMensajes.gridy = 1;
		//restTextAreaMensajes.weightx=0.3;
		//restTextAreaMensajes.weighty=0.2;
		restTextAreaMensajes.gridwidth=2;
		restTextAreaMensajes.gridheight=2;
		restTextAreaMensajes.fill=GridBagConstraints.BOTH;
		add(getTextAreaMensajes(),restTextAreaMensajes);

		GridBagConstraints restLMensajes =new GridBagConstraints();
		restLMensajes.gridx = 0;
		restLMensajes.gridy = 3;
		//restLMensajes.weightx=0.3;
		restLMensajes.weighty=0.2;		
		add(getlMensajes(),restLMensajes);

		GridBagConstraints resttextMensaje =new GridBagConstraints();
		resttextMensaje.gridx = 1;
		resttextMensaje.gridy = 3;
		//resttextMensaje.weightx=0.3;
		//resttextMensaje.weighty=0.2;	
		resttextMensaje.fill=GridBagConstraints.HORIZONTAL;
		add(gettextMensaje(),resttextMensaje);

		GridBagConstraints restbotonEnviar =new GridBagConstraints();
		restbotonEnviar.gridx = 2;
		restbotonEnviar.gridy = 3;
		//restbotonEnviar.weightx=0.3;
		//restbotonEnviar.weighty=0.2;		
		add(getbotonEnviar(),restbotonEnviar);

	}

	
	
	public JButton getbotonRegistrar() {
		return botonRegistrar;
	}

	public void setbotonRegistrar(JButton botonRegistrar) {
		this.botonRegistrar = botonRegistrar;
	}

	public JButton getbotonEnviar() {
		return botonEnviar;
	}

	public void setbotonEnviar(JButton botonEnviar) {
		this.botonEnviar = botonEnviar;
	}

	public JTextField gettextNick() {
		return textNick;
	}

	public void settextNick(JTextField textNick) {
		this.textNick = textNick;
	}

	public JTextField gettextMensaje() {
		return textMensaje;
	}

	public void settextMensaje(JTextField textMensaje) {
		this.textMensaje = textMensaje;
	}

	public JPanel getpSuperior() {
		return pSuperior;
	}

	public void setpSuperior(JPanel pSuperior) {
		this.pSuperior = pSuperior;
	}

	public JPanel getpInferior() {
		return pInferior;
	}

	public void setpInferior(JPanel pInferior) {
		this.pInferior = pInferior;
	}

	public JPanel getpIzquierda() {
		return pIzquierda;
	}

	public void setpIzquierda(JPanel pIzquierda) {
		this.pIzquierda = pIzquierda;
	}

	public JPanel getpIzquierdaSuperior() {
		return pIzquierdaSuperior;
	}

	public void setpIzquierdaSuperior(JPanel pIzquierdaSuperior) {
		this.pIzquierdaSuperior = pIzquierdaSuperior;
	}

	public TextArea getTextAreaMensajes() {
		return TextAreaMensajes;
	}

	public void setTextAreaMensajes(TextArea TextAreaMensajes) {
		this.TextAreaMensajes = TextAreaMensajes;
	}

	public TextArea getTextAreaUsuario() {
		return TextAreaUsuario;
	}

	public void setTextAreaUsuario(TextArea TextAreaUsuario) {
		this.TextAreaUsuario = TextAreaUsuario;
	}

	public JLabel getJLabelNick() {
		return JLabelNick;
	}

	public void setJLabelNick(JLabel JLabelNick) {
		this.JLabelNick = JLabelNick;
	}

	public JLabel getJLabelUsuarios() {
		return JLabelUsuarios;
	}

	public void setJLabelUsuarios(JLabel JLabelUsuarios) {
		this.JLabelUsuarios = JLabelUsuarios;
	}

	public JLabel getlMensajes() {
		return lMensajes;
	}

	public void setlMensajes(JLabel lMensajes) {
		this.lMensajes = lMensajes;
	}
}