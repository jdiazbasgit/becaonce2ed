package chat.recepciones.cliente;

import java.net.Socket;
import java.util.Map;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.recepciones.Servidor;

public class EscuchaMensajeCliente extends Servidor {

	public EscuchaMensajeCliente(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		
		try {
			//Cliente.mensajeCompleto=(String) leerObjeto(socket);
			Cliente.mensajeCompleto = (String) leerMensaje(socket);
			getChat().getTaMensajes().append(Cliente.mensajeCompleto+"\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
	}

}
