package chat.envios.servidor;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.recepciones.Servidor;
import lombok.Data;
@Data

public class EnvioMensajesServidor extends Cliente {
	
	private String mensaje;

	public EnvioMensajesServidor(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);
	}
	
	public EnvioMensajesServidor(String ip, int puerto, String mensaje) {
		setMensaje(mensaje);
		setPuerto(puerto);
		setIp(ip);
	}
	
	@Override
	public void hacerAlgo(Socket socket) {
		try {
			enviarTexto(socket, getMensaje());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
