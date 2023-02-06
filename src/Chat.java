

import java.awt.BorderLayout;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
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

	public Chat() {

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());

		setbRegistrar(new Button("REGISTRAR"));
		setbEnviar(new Button("ENVIAR"));
		settNick(new TextField(80));

		settMensaje(new TextField(80));
		setpSuperior(new Panel());
		setpInferior(new Panel());
		setpIzquierda(new Panel());
		setpIzquierdaSuperior(new Panel());
		setTaMensajes(new TextArea());
		setTaUsuarios(new TextArea());
		setlNick(new Label("NICK"));
		
		setlMensajes(new Label("NICK"));
		setlUsuarios(new Label("USUARIOS"));
		setlMensajes(new Label("MENSAJES"));
		

		getpSuperior().add(getlNick());
		getpSuperior().add(gettNick());
		getpSuperior().add(getbRegistrar());

		getpSuperior().setBackground(Color.blue);
		add(getpSuperior(), BorderLayout.NORTH);

		getpInferior().add(getlMensajes());
		getpInferior().add(gettMensaje());
		getpInferior().add(getbEnviar());
		getpInferior().setBackground(Color.blue);
		add(getpInferior(), BorderLayout.SOUTH);

		getpIzquierda().setLayout(new BorderLayout());
		getpIzquierda().setBackground(Color.YELLOW);
		add(getpIzquierda(), BorderLayout.WEST);
		add(getTaMensajes(), BorderLayout.CENTER);

		getpIzquierdaSuperior().add(getlUsuarios());
		getpIzquierda().add(getTaUsuarios(), BorderLayout.CENTER);
		getpIzquierda().add(getpIzquierdaSuperior(), BorderLayout.NORTH);
		getpIzquierdaSuperior().setBackground(Color.green);
		this.add(getpIzquierda(), BorderLayout.WEST);
		setbRegistrar(new Button("Nick:"));

		// componentes

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

	public Label getlMensajes() {
		return lMensajes;
	}

	public void setlMensajes(Label lMensajes) {
		this.lMensajes = lMensajes;

	}

}
