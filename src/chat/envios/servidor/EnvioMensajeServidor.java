package chat.envios.servidor;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;
import lombok.Data;

@Data
public class EnvioMensajeServidor extends Cliente {

	private String mensaje;
	public EnvioMensajeServidor(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);

	}
	
	public EnvioMensajeServidor(String ip,int puerto,String mensaje) {
		setIp(ip);
		setPuerto(puerto);
		setMensaje(mensaje);
		
	}

	@Override
	public void hacerAlgo(Socket socket) {
		try {
			enviarTexto(socket, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}