package chat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import chat.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")

public class Chat extends JFrame {

	private JButton bRegistrar, bEnviar;
	private JTextField tNick, tMensaje;
	private Panel pSuperior, pInferior, pIzquierda, pIzquierdaSuperior;
	private TextArea taMensajes, taUsuarios;
	private JLabel lNick, lUsuarios, lMensajes;

	public JLabel getlMensajes() {
		return lMensajes;
	}

	public void setlMensajes(JLabel lMensajes) {
		this.lMensajes = lMensajes;
	}

	public Chat() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());

		
		setLayout(new GridBagLayout());
		//setLayout(new BorderLayout());
		//setpSuperior(new Panel());
		//setpInferior(new Panel());
		//setpIzquierda(new Panel());
		//setpIzquierdaSuperior(new Panel());
		//getpSuperior().setBackground(Color.green);
		//getpInferior().setBackground(Color.GREEN);
		//getpIzquierda().setBackground(Color.gray);
		//getpIzquierdaSuperior().setBackground(Color.LIGHT_GRAY);
		//this.add(getpSuperior(), BorderLayout.NORTH);
		//this.add(getpInferior(), BorderLayout.SOUTH);
		//this.add(getpIzquierda(), BorderLayout.WEST);

		//setlNick(new JLabel("Nick"));
		//settNick(new JTextField(100));
		//getpSuperior().add(getlNick());
		//getpSuperior().add(gettNick());
		//getpSuperior().add(getbRegistrar());

		//setbEnviar(new JButton("|>"));
		//setbRegistrar(new JButton("Registrar"));
		//setlMensajes(new JLabel("Mensajes"));
		//settMensaje(new JTextField(100));
		//getpInferior().add(getlMensajes());
		//getpInferior().add(gettMensaje());
		//getpInferior().add(getbEnviar());

		//setlUsuarios(new JLabel("Usuarios"));
		//settaUsuarios(new TextArea());
		//getpIzquierdaSuperior().add(getlUsuarios());
		//getpIzquierda().setLayout(new BorderLayout());
		//getpIzquierda().add(getpIzquierdaSuperior(), BorderLayout.NORTH);
		//getpIzquierda().add(gettaUsuarios(), BorderLayout.CENTER);

		//settaMensajes(new TextArea());
		//this.add(gettaMensajes(), BorderLayout.CENTER);
	
		setlNick(new JLabel());
		GridBagConstraints GBCSNick =new GridBagConstraints();
		GBCSNick.gridx =0;
		GBCSNick.gridy =0;
		GBCSNick.weightx=0.25;
		GBCSNick.weighty=0.2;	
		add(getlNick(),GBCSNick);
		
		settMensaje(new JTextField(100));		
		GridBagConstraints GBCSNickTestField =new GridBagConstraints();
		GBCSNickTestField.gridx =1;
		GBCSNickTestField.gridy =0;
		GBCSNickTestField.weightx=0.5;
		GBCSNickTestField.weighty=0.2;	
		add(gettMensaje(),GBCSNickTestField);
		//elDelNick.addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());
		
		
	    setbRegistrar(new JButton(new ImageIcon("Icono.png")));
		GridBagConstraints GBCSRegistrar =new GridBagConstraints();
		GBCSRegistrar.gridx =2;
		GBCSRegistrar.gridy =0;
		GBCSRegistrar.weightx=0.25;
		GBCSRegistrar.weighty=0.2;		
		add(getbRegistrar(),GBCSRegistrar);
		
		JLabel mensajes =new JLabel("Mensajes");
		GridBagConstraints GBCIMensaje =new GridBagConstraints();
		GBCIMensaje.gridx =0;
		GBCIMensaje.gridy =3;
		GBCIMensaje.weightx=0.25;
		GBCIMensaje.weighty=0.2;	
		add(mensajes,GBCIMensaje);
		
		JTextField elDelMensaje= new JTextField(100);
		elDelMensaje.setText("Escriba mensaje");
		GridBagConstraints GBCITexto =new GridBagConstraints();
		GBCITexto.gridx =1;
		GBCITexto.gridy =3;
		GBCITexto.weightx=0.5;
		GBCITexto.weighty=0.2;	
		add(elDelMensaje,GBCITexto);
		elDelMensaje.addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());
		
		JButton enviar= new JButton("Enviar");
		GridBagConstraints GBCIEnviar =new GridBagConstraints();
		GBCIEnviar.gridx =2;
		GBCIEnviar.gridy =3;
		GBCIEnviar.weightx=0.25;
		GBCIEnviar.weighty=0.2;	
		
		add(enviar,GBCIEnviar);
		
		JLabel usuarios = new JLabel("Usuarios");
		GridBagConstraints GBCIzSUsuario =new GridBagConstraints();
		GBCIzSUsuario.gridx =0;
		GBCIzSUsuario.gridy =1;
		GBCIzSUsuario.weightx=0.25;
		GBCIzSUsuario.weighty=0.1;	
		add(usuarios,GBCIzSUsuario);
		
		TextArea elDelUsuario = new TextArea(30,1);
		GridBagConstraints GBCIZSDondeEstanLosUsuarios =new GridBagConstraints();
		GBCIZSDondeEstanLosUsuarios.gridx =0;
		GBCIZSDondeEstanLosUsuarios.gridy =2;
		GBCIZSDondeEstanLosUsuarios.weightx=0.25;
		GBCIZSDondeEstanLosUsuarios.weighty=0.5;	
		GBCIZSDondeEstanLosUsuarios.fill=GridBagConstraints.BOTH;
		add(elDelUsuario,GBCIZSDondeEstanLosUsuarios);
		
		TextArea dondeEstanLosMensajes = new TextArea();
		GridBagConstraints GBCIzDondeEstanLosMensajes =new GridBagConstraints();
		GBCIzDondeEstanLosMensajes.gridx =1;
		GBCIzDondeEstanLosMensajes.gridy =1;
		GBCIzDondeEstanLosMensajes.gridheight =2;
		GBCIzDondeEstanLosMensajes.gridwidth =2;
		GBCIzDondeEstanLosMensajes.weightx=0.2;
		GBCIzDondeEstanLosMensajes.weighty=0.3;	
		GBCIzDondeEstanLosMensajes.fill=GridBagConstraints.BOTH;
		add(dondeEstanLosMensajes,GBCIzDondeEstanLosMensajes);
				
		
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

	public Panel getpSuperior() {
		return pSuperior;
	}

	public void setpSuperior(Panel pSuperior) {
		this.pSuperior = pSuperior;

	}

	public Panel getpInferior() {
		return pInferior;
	}

	public void setpInferior(Panel pInferior) {
		this.pInferior = pInferior;
	}

	public Panel getpIzquierda() {
		return pIzquierda;
	}

	public void setpIzquierda(Panel pIzquierda) {
		this.pIzquierda = pIzquierda;
	}

	public Panel getpIzquierdaSuperior() {
		return pIzquierdaSuperior;
	}

	public void setpIzquierdaSuperior(Panel pIzquierdaSuperior) {
		this.pIzquierdaSuperior = pIzquierdaSuperior;
	}

	public TextArea gettaMensajes() {
		return taMensajes;
	}

	public void settaMensajes(TextArea taMensajes) {
		this.taMensajes = taMensajes;
	}

	public TextArea gettaUsuarios() {
		return taUsuarios;
	}

	public void settaUsuarios(TextArea taUsuarios) {
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

	public void settMensaje(JTextField tMensaje) {
		this.tMensaje = tMensaje;
	}

}