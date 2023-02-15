package chat.recepciones.cliente;

import java.net.Socket;
import java.util.Map;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.recepciones.Servidor;

public class EscuchaMensajesCliente extends Servidor {

	public EscuchaMensajesCliente(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		try {
			String nuevoMensaje = leerMensaje(socket);
			getChat().getTaMensajes().append(nuevoMensaje+"\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.exit(0);
		}
	}

}
