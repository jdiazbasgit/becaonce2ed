package chat.recepciones.servidor;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.servidor.EnvioMensajeServidor;
import chat.recepciones.Servidor;

public class EscuchaMensajesServidor extends Servidor {

	public EscuchaMensajesServidor(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		try {
			String mensaje = leerMensaje(socket);
			String ip = socket.getInetAddress().getHostAddress();
			String nick = Servidor.usuarios.get(ip);
			String respuesta = nick + " dice: " + mensaje;
			for (String ipDestino : Servidor.usuarios.keySet()) {
				EnvioMensajeServidor envioMensajeServidor = new EnvioMensajeServidor(ipDestino,
						Cliente.PUERTO_ESCUCHA_MENSAJE_CLIENTE, respuesta);
				envioMensajeServidor.start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}