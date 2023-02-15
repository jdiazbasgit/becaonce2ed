package chat;

import chat.envios.Cliente;
import chat.recepciones.cliente.EscuchaMensajeCliente;
import chat.recepciones.cliente.EscuchaRegistroCliente;

public class VerChat {

	public static void main(String[] args) {
		ChatGridBag chat= new ChatGridBag();
		chat.setVisible(true);
		EscuchaRegistroCliente escuchaRegistroCliente= new EscuchaRegistroCliente(Cliente.PUERTO_ESCUCHA_REGISTRO_CLIENTE, chat);
		escuchaRegistroCliente.start();
		EscuchaMensajeCliente escuchaMensajeCliente= new EscuchaMensajeCliente(Cliente.PUERTO_ESCUCHA_MENSAJE_CLIENTE, chat);
		escuchaMensajeCliente.start();
	}

}
