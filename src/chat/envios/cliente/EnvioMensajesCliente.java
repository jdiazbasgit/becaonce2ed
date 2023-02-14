package chat.envios.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;

public class EnvioMensajesCliente extends Cliente {

	public EnvioMensajesCliente(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		String mensaje=getChat().getTMensaje().getText().trim();
		
		
		try {
			enviarTexto(socket, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
