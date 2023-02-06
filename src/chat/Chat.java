package chat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.JFrame;
import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")

public class Chat extends Frame {

	private Button bRegistrar, bEnviar;
	private TextField tNick, tMensaje;
	private Panel pSuperior, pInferior, pIzquierda, pIzquierdaSuperior;
	private TextArea taMensajes, taUsuarios;
	private Label lNick, lUsuarios, lMensajes;

	public Label getlMensajes() {
		return lMensajes;
	}

	public void setlMensajes(Label lMensajes) {
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

		//setlNick(new Label("Nick"));
		//settNick(new TextField(100));
		//getpSuperior().add(getlNick());
		//getpSuperior().add(gettNick());
		//getpSuperior().add(getbRegistrar());

		//setbEnviar(new Button("|>"));
		//setbRegistrar(new Button("Registrar"));
		//setlMensajes(new Label("Mensajes"));
		//settMensaje(new TextField(100));
		//getpInferior().add(getlMensajes());
		//getpInferior().add(gettMensaje());
		//getpInferior().add(getbEnviar());

		//setlUsuarios(new Label("Usuarios"));
		//settaUsuarios(new TextArea());
		//getpIzquierdaSuperior().add(getlUsuarios());
		//getpIzquierda().setLayout(new BorderLayout());
		//getpIzquierda().add(getpIzquierdaSuperior(), BorderLayout.NORTH);
		//getpIzquierda().add(gettaUsuarios(), BorderLayout.CENTER);

		//settaMensajes(new TextArea());
		//this.add(gettaMensajes(), BorderLayout.CENTER);
	
		Label nick = new Label("Nick");
		GridBagConstraints GBCSNick =new GridBagConstraints();
		GBCSNick.gridx =0;
		GBCSNick.gridy =0;
		GBCSNick.weightx=0.25;
		GBCSNick.weighty=0.2;	
		add(nick,GBCSNick);
		
		TextField elDelNick= new TextField(100);
		GridBagConstraints GBCSNickTestField =new GridBagConstraints();
		GBCSNickTestField.gridx =1;
		GBCSNickTestField.gridy =0;
		GBCSNickTestField.weightx=0.5;
		GBCSNickTestField.weighty=0.2;	
		add(elDelNick,GBCSNickTestField);
		elDelNick.addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());
		
		
		Button registrar = new Button("Registrar");
		GridBagConstraints GBCSRegistrar =new GridBagConstraints();
		GBCSRegistrar.gridx =2;
		GBCSRegistrar.gridy =0;
		GBCSRegistrar.weightx=0.25;
		GBCSRegistrar.weighty=0.2;	
		GBCSRegistrar.fill=GridBagConstraints.BOTH;
		add(registrar,GBCSRegistrar);
		
		Label mensajes =new Label("Mensajes");
		GridBagConstraints GBCIMensaje =new GridBagConstraints();
		GBCIMensaje.gridx =0;
		GBCIMensaje.gridy =3;
		GBCIMensaje.weightx=0.25;
		GBCIMensaje.weighty=0.2;	
		add(mensajes,GBCIMensaje);
		
		TextField elDelMensaje= new TextField(100);
		GridBagConstraints GBCITexto =new GridBagConstraints();
		GBCITexto.gridx =1;
		GBCITexto.gridy =3;
		GBCITexto.weightx=0.5;
		GBCITexto.weighty=0.2;	
		add(elDelMensaje,GBCITexto);
		
		Button enviar= new Button("|>");
		GridBagConstraints GBCIEnviar =new GridBagConstraints();
		GBCIEnviar.gridx =2;
		GBCIEnviar.gridy =3;
		GBCIEnviar.weightx=0.25;
		GBCIEnviar.weighty=0.2;	
		GBCIEnviar.fill=GridBagConstraints.BOTH;
		add(enviar,GBCIEnviar);
		
		Label usuarios = new Label("Usuarios");
		GridBagConstraints GBCIzSUsuario =new GridBagConstraints();
		GBCIzSUsuario.gridx =0;
		GBCIzSUsuario.gridy =1;
		GBCIzSUsuario.weightx=0.25;
		GBCIzSUsuario.weighty=0.1;	
		add(usuarios,GBCIzSUsuario);
		
		TextArea elDelUsuario = new TextArea();
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

	public void settMensaje(TextField tMensaje) {
		this.tMensaje = tMensaje;
	}

}