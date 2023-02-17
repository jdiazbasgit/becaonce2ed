package chat.recepciones.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.recepciones.Servidor;

public class EscuchaMensajesCliente extends Servidor {

	public EscuchaMensajesCliente(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
<<<<<<< HEAD
	/*public void hacerAlgo(Socket socket) {
		try {
			Cliente.usuarios=(Map<String, String>) leerObjeto(socket);
			getChat().getTaUsuarios().setText("");
			for (String usuario : Cliente.usuarios.values()) {
				getChat().getTaUsuarios().append(usuario+"\n");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}*/
=======
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
		
>>>>>>> branch 'feature/chatoperativo/grupo2' of https://github.com/jdiazbasgit/becaonce2ed.git
	}

}