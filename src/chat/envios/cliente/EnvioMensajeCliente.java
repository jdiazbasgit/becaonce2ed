package chat.envios.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;

public class EnvioMensajeCliente extends Cliente {

	public EnvioMensajeCliente(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		String nick=getChat().getTNick().getText();
		String mensaje=getChat().getTMensaje().getText();
		String mensajeCompleto = nick + ": " +mensaje;
		//LFRM-BORRAR
		System.out.println("DESDE EnvioMensajeCliente - mensaje: " + mensajeCompleto);
		try {
			enviarTexto(socket, mensajeCompleto);
			//getChat().getTMensaje().disable();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
