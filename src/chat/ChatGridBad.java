package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JFrame;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")

public class ChatGridBad extends Frame {

	private Button bRegistrar, bEnviar;
	private TextField tNick, tMensaje;
	private Panel pSuperior, pInferior, pIzquierda, pIzquierdaSuperior;
	private TextArea taMensajes, taUsuarios;
	private Label lNick, lUsuarios, lMensaje;

	public ChatGridBad(boolean grid) {

		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		this.setLayout(new BorderLayout());
		Dimension tamanoActualizableFrame = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(tamanoActualizableFrame.width / 2, tamanoActualizableFrame.height / 2);
		setLocation(tamanoActualizableFrame.width / 4, tamanoActualizableFrame.height / 4);
		System.out.println(tamanoActualizableFrame);
		
		
		if (grid) {
			// setExtendedState(JFrame.MAXIMIZED_BOTH);

			this.setLayout(new GridBagLayout());
			Insets margenExterior10 = new Insets(10, 30, 10, 30);

			// ---Primera zona-------------------------

			this.setlNick(new Label("Nick:"));
			this.settNick(new TextField("Escribe cómo te verán los demás", 0));
			this.setbRegistrar(new Button("REGISTRAR"));

			GridBagConstraints gbcLabelNick = new GridBagConstraints();
			GridBagConstraints gcbTextFieldNick = new GridBagConstraints();
			GridBagConstraints gbcButtonRegistrar = new GridBagConstraints();
			gbcLabelNick.gridx = 0;
			gbcLabelNick.gridy = 0;
			gbcLabelNick.weightx = 0.25;
			gbcLabelNick.weighty = 0.2;
			gbcLabelNick.anchor = GridBagConstraints.EAST;
			gbcLabelNick.insets = margenExterior10;

			gcbTextFieldNick.gridx = 1;
			gcbTextFieldNick.gridy = 0;
			gcbTextFieldNick.weightx = 0.5;
			gcbTextFieldNick.weighty = 0.2;
			gcbTextFieldNick.fill = GridBagConstraints.HORIZONTAL;

			gbcButtonRegistrar.gridx = 2;
			gbcButtonRegistrar.gridy = 0;
			gbcButtonRegistrar.weightx = 0.25;
			gbcButtonRegistrar.weighty = 0.2;
			gbcButtonRegistrar.anchor = GridBagConstraints.WEST;
			gbcButtonRegistrar.insets = margenExterior10;
			gbcButtonRegistrar.ipadx = 10;
			gbcButtonRegistrar.ipady = 10;

			this.add(getlNick(), gbcLabelNick);
			this.add(gettNick(), gcbTextFieldNick);
			this.add(getbRegistrar(), gbcButtonRegistrar);

			// ---Segunda zona----------------------------

			this.setlUsuarios(new Label("Usuarios:"));
			this.setTaMensajes(
					new TextArea("Lista de mensajes, panel principal", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY));

			GridBagConstraints gbcLabelUsuarios = new GridBagConstraints();
			GridBagConstraints gcbTextAreaMensajes = new GridBagConstraints();
			gbcLabelUsuarios.gridx = 0;
			gbcLabelUsuarios.gridy = 1;
			gbcLabelUsuarios.weightx = 0.25;
			gbcLabelUsuarios.weighty = 0.1;
			gbcLabelUsuarios.anchor = GridBagConstraints.SOUTH;

			gcbTextAreaMensajes.gridx = 1;
			gcbTextAreaMensajes.gridy = 1;
			gcbTextAreaMensajes.weightx = 0.75;
			gcbTextAreaMensajes.weighty = 0.1;
			gcbTextAreaMensajes.gridwidth = 2;
			gcbTextAreaMensajes.gridheight = 2;
			gcbTextAreaMensajes.fill = GridBagConstraints.BOTH;
			gcbTextAreaMensajes.insets = margenExterior10;

			add(getlUsuarios(), gbcLabelUsuarios);
			add(getTaMensajes(), gcbTextAreaMensajes);

			this.setTaUsuarios(new TextArea("", 22, 19, TextArea.SCROLLBARS_VERTICAL_ONLY));

			GridBagConstraints gcbTextAreaUsuarios = new GridBagConstraints();
			gcbTextAreaUsuarios.gridx = 0;
			gcbTextAreaUsuarios.gridy = 2;
			gcbTextAreaUsuarios.weightx = 0.25;
			gcbTextAreaUsuarios.weighty = 0.5;
			gcbTextAreaUsuarios.fill = GridBagConstraints.BOTH;
			gcbTextAreaUsuarios.insets = margenExterior10;

			add(getTaUsuarios(), gcbTextAreaUsuarios);

			// ---Tercera zona----------------------------

			this.setlMensaje(new Label("Mensaje:"));
			this.settMensaje(new TextField("Escribe un mensaje", 60));
			this.setbEnviar(new Button("ENVIAR"));

			GridBagConstraints gbcLabelMensaje = new GridBagConstraints();
			GridBagConstraints gcbTextFieldMensaje = new GridBagConstraints();
			GridBagConstraints gbcButtonEnviar = new GridBagConstraints();
			gbcLabelMensaje.gridx = 0;
			gbcLabelMensaje.gridy = 3;
			gbcLabelMensaje.weightx = 0.25;
			gbcLabelMensaje.weighty = 0.2;
			gbcLabelMensaje.anchor = GridBagConstraints.EAST;
			gbcLabelMensaje.insets = margenExterior10;

			gcbTextFieldMensaje.gridx = 1;
			gcbTextFieldMensaje.gridy = 3;
			gcbTextFieldMensaje.weightx = 0.5;
			gcbTextFieldMensaje.weighty = 0.2;
			gcbTextFieldMensaje.fill = GridBagConstraints.HORIZONTAL;

			gbcButtonEnviar.gridx = 2;
			gbcButtonEnviar.gridy = 3;
			gbcButtonEnviar.weightx = 0.25;
			gbcButtonEnviar.weighty = 0.2;
			gbcButtonEnviar.anchor = GridBagConstraints.WEST;
			gbcButtonEnviar.insets = margenExterior10;
			gbcButtonEnviar.ipadx = 10;
			gbcButtonEnviar.ipady = 10;

			this.add(getlMensaje(), gbcLabelMensaje);
			this.add(gettMensaje(), gcbTextFieldMensaje);
			this.add(getbEnviar(), gbcButtonEnviar);
		}
		
		
		//--------Chat SIN grid----------
		else {
			
			this.setpSuperior(new Panel());
			this.add(getpSuperior(),BorderLayout.NORTH);
			getpSuperior().setLayout(new FlowLayout(FlowLayout.CENTER, 90, 20));
			getpSuperior().setBackground(Color.ORANGE);
			
			this.setlNick(new Label("Nick:"));
			getpSuperior().add(getlNick());
			
			this.settNick(new TextField("Escribe cómo te verán los demás",0));
			getpSuperior().add(gettNick());
			
			this.setbRegistrar(new Button("REGISTRAR"));
			getpSuperior().add(getbRegistrar());
			
			
			this.setpIzquierda(new Panel());
			this.add(getpIzquierda(),BorderLayout.WEST);
			getpIzquierda().setLayout(new BorderLayout());
			getpIzquierda().setBackground(Color.RED);
			//---------
			this.setpIzquierdaSuperior(new Panel());
			getpIzquierda().add(getpIzquierdaSuperior(),BorderLayout.NORTH);
			getpIzquierdaSuperior().setLayout(new FlowLayout());
			getpIzquierdaSuperior().setBackground(Color.DARK_GRAY);
			
			this.setlUsuarios(new Label("Usuarios:"));
			getpIzquierdaSuperior().add(getlUsuarios());
			//-----------
			
			getpIzquierda().add(getpIzquierdaSuperior(),BorderLayout.NORTH);
			
					
			this.setTaUsuarios(new TextArea("",1,20,TextArea.SCROLLBARS_VERTICAL_ONLY));
			//getTaUsuarios().TextArea.SCROLLBARS_VERTICAL_ONLY
			getpIzquierda().add(getTaUsuarios(),BorderLayout.CENTER);

			
			
			this.setpInferior(new Panel());
			this.add(getpInferior(),BorderLayout.SOUTH);
			getpInferior().setLayout(new FlowLayout(FlowLayout.CENTER, 90, 20));
			getpInferior().setBackground(Color.ORANGE);		
			this.setlMensaje(new Label("Mensaje:"));
			getpInferior().add(getlMensaje());		
			this.settMensaje(new TextField("Escribe un mensaje",60));
			getpInferior().add(gettMensaje());		
			this.setbEnviar(new Button("ENVIAR"));
			getpInferior().add(getbEnviar());
			
			
			this.setTaMensajes(new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY));
			this.add(getTaMensajes());
		}

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
