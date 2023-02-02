package chat;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
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
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		this.setSize(1200, 800);
		this.setLayout(new BorderLayout());
		//setbRegistrar(new Button("Nick:"));		
		
		Label lblNick = new Label("Nick:::");
		
	    this.setLayout(new BorderLayout());
	    Panel pSuperior = new Panel();
	    pSuperior.setBackground(Color.RED);
	    pSuperior.add(lblNick,BorderLayout.SOUTH);
	    pSuperior.setPreferredSize(new Dimension(Frame.MAXIMIZED_HORIZ, 100));
	    this.add(pSuperior, BorderLayout.NORTH);

	    Panel pInferior = new Panel();
	    pInferior.setBackground(Color.BLUE);
	    pInferior.setPreferredSize(new Dimension(Frame.MAXIMIZED_HORIZ, 100));
	    this.add(pInferior, BorderLayout.SOUTH);

	    Panel pDerecha = new Panel();
	    pDerecha.setBackground(Color.GREEN);
	    this.add(pDerecha,BorderLayout.CENTER);

	    Panel pIzquierda = new Panel();
	    pIzquierda.setBackground(Color.YELLOW);
	    pIzquierda.setPreferredSize(new Dimension(200, Frame.MAXIMIZED_VERT));
	    this.add(pIzquierda, BorderLayout.WEST);
	    
	    this.setTitle("Chat anónimo");
		
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
