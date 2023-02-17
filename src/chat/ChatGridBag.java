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

import chat.eventos.ElQueSabeLoQueHayQueHacerConElBoton;
import chat.eventos.ElQueSabeLoQueHayQueHacerConElRaton;
import chat.eventos.ElQueSabeLoQueHayQueHacerConElTeclado;
import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;
import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ChatGridBag extends JFrame {

	private JButton bRegistrar, bEnviar,bEnviar2;
	private JTextField tNick, tMensaje,tPrivado;
	private TextArea taMensajes, taUsuarios;
	private JLabel lNick, lUsuarios, lMensaje;
	//private jChoice chUsuarios;
	

	public ChatGridBag() {

		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		this.setLayout(new BorderLayout());
		Dimension tamanoActualizableFrame = Toolkit.getDefaultToolkit().getScreenSize();
		//setSize(tamanoActualizableFrame.width / 2, tamanoActualizableFrame.height / 2);
		//setLocation(tamanoActualizableFrame.width / 4, tamanoActualizableFrame.height / 4);
		// System.out.println(tamanoActualizableFrame);

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.setLayout(new GridBagLayout());

		// ---Primera zona-------------------------

		this.setLNick(new JLabel("Nick:   "));
		this.setTNick(new JTextField());
		this.setBRegistrar(new JButton("REGISTRAR"));
		getBRegistrar().addActionListener(new ElQueSabeLoQueHayQueHacerConElBoton(this));

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
		// Insets margenDechaDv4 = new Insets(0, 0, 0, tamanoActualizableFrame.width /
		// 4);
		// gcbTextFieldNick.insets = margenDechaDv4;
		// gcbTextFieldNick.gridwidth = 2;

		gbcButtonRegistrar.gridx = 2;
		gbcButtonRegistrar.gridy = 0;
		gbcButtonRegistrar.weightx = 0.2;
		gbcButtonRegistrar.anchor = GridBagConstraints.WEST;
		Insets margenDechaDv7 = new Insets(0, 10, 0, tamanoActualizableFrame.width / 7);
		gbcButtonRegistrar.insets = margenDechaDv7;

		getContentPane().add(getLNick(), gbcLabelNick);
		getContentPane().add(getTNick(), gcbTextFieldNick);
		getContentPane().add(getBRegistrar(), gbcButtonRegistrar);

		// ---Segunda zona----------------------------

		this.setLUsuarios(new JLabel("Usuarios:"));
		this.setTaMensajes(new TextArea("Lista de mensajes, panel principal\n", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY));
		this.getTaMensajes().disable();
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

		getContentPane().add(getLUsuarios(), gbcLabelUsuarios);
		getContentPane().add(getTaMensajes(), gcbTextAreaMensajes);

		this.setTaUsuarios(new TextArea("", 30, 1, TextArea.SCROLLBARS_VERTICAL_ONLY));
		this.getTaUsuarios().disable();

		GridBagConstraints gcbTextAreaUsuarios = new GridBagConstraints();
		gcbTextAreaUsuarios.gridx = 0;
		gcbTextAreaUsuarios.gridy = 2;
		gcbTextAreaUsuarios.weighty = 0.2;
		gcbTextAreaUsuarios.fill = GridBagConstraints.BOTH;

		getContentPane().add(getTaUsuarios(), gcbTextAreaUsuarios);

		// ---Tercera zona----------------------------

		this.setLMensaje(new JLabel("Mensaje:   "));
		this.setTMensaje(new JTextField("Escribe un mensaje", 60));
		this.setBEnviar(new JButton("ENVIAR"));
		getBEnviar().addActionListener(new ElQueSabeLoQueHayQueHacerConElBoton(this));
		getTMensaje().addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton());
		getTMensaje().addKeyListener(new ElQueSabeLoQueHayQueHacerConElTeclado(this));

		GridBagConstraints gbcLabelMensaje = new GridBagConstraints();
		GridBagConstraints gcbTextFieldMensaje = new GridBagConstraints();
		GridBagConstraints gbcButtonEnviar = new GridBagConstraints();
		gbcLabelMensaje.gridx = 0;
		gbcLabelMensaje.gridy = 3;
		gbcLabelMensaje.weighty = 0.2;
		gbcLabelMensaje.anchor = GridBagConstraints.EAST;
/*
		GridBagConstraints gbcbEnviar2 =new GridBagConstraints();
		gbcbEnviar2.gridx=0;
		gbcbEnviar2.gridy=6;
		gbcbEnviar2.weighty=0.1;
		gbcbEnviar2.anchor=GridBagConstraints.EAST;
	
		GridBagConstraints gbctPrivado = new GridBagConstraints();
		gbctPrivado.gridx=0;
		gbctPrivado.gridy=4;
		gbctPrivado.weighty=0.1;
		gbctPrivado.anchor=GridBagConstraints.EAST;
		
			
		GridBagConstraints gbcchUsuarios = new GridBagConstraints();
		gbcchUsuarios.gridx=0;
		gbcchUsuarios.gridy=5;
		gbcchUsuarios.weighty=0.1;
		gbcchUsuarios.anchor=GridBagConstraints.EAST;
		*/
		
		gcbTextFieldMensaje.gridx = 1;
		gcbTextFieldMensaje.gridy = 7;
		gcbTextFieldMensaje.weighty = 0.2;
		gcbTextFieldMensaje.fill = GridBagConstraints.HORIZONTAL;
		// gcbTextFieldMensaje.gridwidth = 2;

		gbcButtonEnviar.gridx = 2;
		gbcButtonEnviar.gridy = 7;
		gbcButtonEnviar.weighty = 0.2;
		gbcButtonEnviar.anchor = GridBagConstraints.WEST;
		Insets margenDechaDv12 = new Insets(0, 10, 0, tamanoActualizableFrame.width / 18);
		gbcButtonEnviar.insets = margenDechaDv12;

		getContentPane().add(getLMensaje(), gbcLabelMensaje);
		getContentPane().add(getTMensaje(), gcbTextFieldMensaje);
		getContentPane().add(getBEnviar(), gbcButtonEnviar);

	}
}