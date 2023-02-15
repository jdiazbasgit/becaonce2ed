package chat.recepciones.servidor;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.servidor.EnvioMensajesServidor;
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
			String nombre = Servidor.usuarios.get(ip);
			String mensajesTotal = "\n"+ nombre+ " Dice: " +mensaje;
			
			for (String destino : Servidor.usuarios.keySet()) {
				EnvioMensajesServidor envioMensajesServidor= new EnvioMensajesServidor(destino, Cliente.PUERTO_ESCUCHA_MENSAJE_CLIENTE, mensajesTotal);
				envioMensajesServidor.start();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
