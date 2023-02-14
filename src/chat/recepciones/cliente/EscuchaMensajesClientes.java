package chat.recepciones.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;

public class EscuchaMensajesClientes extends Cliente {

	public EscuchaMensajesClientes(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hacerAlgo(Socket socket) {
		// TODO Auto-generated method stub

	}

}
