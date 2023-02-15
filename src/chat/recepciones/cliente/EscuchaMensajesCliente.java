package chat.recepciones.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.recepciones.Servidor;

public class EscuchaMensajesCliente extends Servidor {

	public EscuchaMensajesCliente(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		String mensaje=getChat().getTMensaje().getText();
		String salidaMensaje="";
	
	try {
		mensaje(socket, salidaMensaje);
		getChat().getTMensaje().disable();
	} catch (Exception e){
		e.printStackTrace();
	}
	
}

	private void mensaje(Socket socket, String salidaMensaje) {
		// TODO Auto-generated method stub
		
	}

}