package chat.envios.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.recepciones.Servidor;

public class EnvioMensajesCliente extends Servidor {

	public EnvioMensajesCliente(int puerto, ChatGridBag chat) {
		super(puerto, chat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hacerAlgo(Socket socket) {
		// TODO Auto-generated method stub

	}

}
