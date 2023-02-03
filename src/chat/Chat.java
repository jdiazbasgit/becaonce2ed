package chat;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

import chat.eventos.ElQueSabeLoQueHayQueHacerConLaVentana;

@SuppressWarnings("serial")
public class Chat extends Frame {
	private Button bRegistrar, bEnviar;
	private TextField tNick, tMensaje;
	private Panel pSuperior, pInferior, pIzquierda, pIzquierdaSuperior;
	private TextArea taMensajes, taUsuarios;
	private Label lNick, lUsuarios, lMensajes;
	
	public Chat() {
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		setSize(1200, 800);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    setLocation(x, y);
			
		setLayout(new BorderLayout());
		//setbRegistrar(new Button("Nick:"));		
		
		/* SUPERIOR */
		Label lNick = new Label("Nick:::");	
		lNick.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		TextField tNick = new TextField(50);
		tNick.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		Button bRegistrar = new Button("Registrar");
		bRegistrar.setFont(new Font("Verdana", Font.PLAIN, 20));
		
	    Panel pSuperior = new Panel();
	    pSuperior.setBackground(Color.RED);
		pSuperior.add(lNick);
		pSuperior.add(tNick);
		pSuperior.add(bRegistrar);
		
		pSuperior.add(lNick, BorderLayout.PAGE_START);
		pSuperior.add(tNick, BorderLayout.PAGE_START);
		pSuperior.add(bRegistrar, BorderLayout.PAGE_START);
		
	    pSuperior.setPreferredSize(new Dimension(Frame.MAXIMIZED_HORIZ, 45));
	    add(pSuperior, BorderLayout.NORTH);

	    
	    
	    /* INFERIOR */
	    Label lMensajes = new Label("Mensaje:::");	
	    lMensajes.setFont(new Font("Verdana", Font.PLAIN, 20));
	    
	    TextField tMensaje = new TextField(50);
	    tMensaje.setFont(new Font("Verdana", Font.PLAIN, 20));
	    
	    Button bEnviar = new Button("Enviar");
	    bEnviar.setFont(new Font("Verdana", Font.PLAIN, 20));
	    
	    Panel pInferior = new Panel();
	    pInferior.setBackground(Color.BLUE);
	    pInferior.setPreferredSize(new Dimension(Frame.MAXIMIZED_HORIZ, 45));
	  
	    pInferior.add(lMensajes);
	    pInferior.add(tMensaje);
		pInferior.add(bEnviar);
		
	    pInferior.add(lMensajes, BorderLayout.PAGE_START);
	    pInferior.add(tMensaje, BorderLayout.PAGE_START);
	    pInferior.add(bEnviar, BorderLayout.PAGE_START);
	    add(pInferior, BorderLayout.SOUTH);

	    
	    
	    /* CENTER */
	    TextArea taMensajes =new TextArea();	    
	    Panel pDerecha = new Panel();
	    pDerecha.setLayout(new BorderLayout());
	    pDerecha.setBackground(Color.GREEN);
	    pDerecha.add(taMensajes,BorderLayout.CENTER);
	    add(pDerecha,BorderLayout.CENTER);
	    
	    
	    
	    
	    /* IZQUIERDA */
	    TextArea taUsuarios =new TextArea();
	    
	    Label lUsuarios = new Label("Usuarios");
	    lUsuarios.setFont(new Font("Verdana", Font.PLAIN, 20));
	    
	    Panel pIzquierda = new Panel();
	    pIzquierda.setLayout(new BorderLayout());
	    pIzquierda.add(lUsuarios,BorderLayout.NORTH);
	    pIzquierda.setBackground(Color.YELLOW);
	    pIzquierda.add(taUsuarios,BorderLayout.CENTER);
	    pIzquierda.setPreferredSize(new Dimension(300, Frame.MAXIMIZED_VERT));
	    add(pIzquierda, BorderLayout.WEST);
	    
	    setTitle("Chat anónimo");
		
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
