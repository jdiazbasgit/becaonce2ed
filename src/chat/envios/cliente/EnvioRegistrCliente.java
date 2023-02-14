package chat.envios.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;

public class EnvioRegistrCliente extends Cliente {

	public EnvioRegistrCliente(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		String nick=getChat().getTNick().getText();
		try {
			enviarTexto(socket, nick);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
