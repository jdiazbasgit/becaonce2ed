package chat.recepciones.servidor;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.servidor.EnvioRegistroServidor;
import chat.recepciones.Servidor;

public class EscuchaMensajesServidor extends Servidor {

	public EscuchaMensajesServidor(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		
		try {
			String mensaje=leerMensaje(socket);
			String ip= socket.getInetAddress().getHostAddress();
			Servidor.usuarios.put(ip, mensaje);
			for (String destino : Servidor.usuarios.keySet()) {
				EnvioRegistroServidor envioRegistroServidor= new EnvioRegistroServidor(destino, Cliente.PUERTO_ENVIO_MENSAJE_SERVIDOR, getChat());
				envioRegistroServidor.start();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
