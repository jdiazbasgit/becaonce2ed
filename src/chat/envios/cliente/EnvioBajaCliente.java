package chat.envios.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;

public class EnvioBajaCliente extends Cliente {

	public EnvioBajaCliente(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hacerAlgo(Socket socket) {
		System.out.println("adios");

	}

}
