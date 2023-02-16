package chat.recepciones.servidor;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.servidor.EnvioMensajeServidor;
import chat.recepciones.Servidor;

public class EscuchaMensajeServidor extends Servidor {

	public EscuchaMensajeServidor(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		
		try {
			String mensajeCompleto=leerMensaje(socket);
			String ip= socket.getInetAddress().getHostAddress();
			//LFRM-BORRAR
			System.out.println("DESDE EscuchaMensajeServidor - mensajeCompleto: "+mensajeCompleto);
			Servidor.mensajeCompleto = mensajeCompleto;
			
			
			// REVISAR
			
			
			EnvioMensajeServidor envioMensajeServidor= new EnvioMensajeServidor("", Cliente.PUERTO_ESCUCHA_MENSAJE_CLIENTE, getChat());
			envioMensajeServidor.start();
			
			/*
			for (String destino : Servidor.mensajeCompleto.keySet()) {
				EnvioMensajeServidor envioMensajeServidor= new EnvioMensajeServidor(destino, Cliente.PUERTO_ESCUCHA_MENSAJE_CLIENTE, getChat());
				envioMensajeServidor.start();
				
			}
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
