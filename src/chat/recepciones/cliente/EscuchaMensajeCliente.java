package chat.recepciones.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.recepciones.Servidor;

public class EscuchaMensajeCliente extends Servidor {

	public EscuchaMensajeCliente(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		try {
			String mensaje=leerMensaje(socket);
			getChat().getTaMensajes().append(mensaje+"\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}