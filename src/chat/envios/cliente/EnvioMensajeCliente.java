package chat.envios.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;

public class EnvioMensajeCliente extends Cliente {

	public EnvioMensajeCliente(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);
	}

	public EnvioMensajeCliente() {
	}

	@Override
	public void hacerAlgo(Socket socket) {
		String mensaje=getChat().getTMensaje().getText();
		try {
			enviarTexto(socket, mensaje);
			getChat().getTMensaje().setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}