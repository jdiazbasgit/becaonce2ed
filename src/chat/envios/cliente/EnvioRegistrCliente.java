package chat.envios.cliente;

import java.net.Socket;

import chat.ChatGridBag;
import chat.envios.Cliente;

public class EnvioRegistrCliente extends Cliente {

	public EnvioRegistrCliente(String ip, int puerto, ChatGridBag chat) {
		super(ip, puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		String nick=getChat().getTNick().getText().trim();
		String salida="";
		for(int i=0;i<nick.length();i++) {
			if(!nick.substring(i,i+1).equals(" ") && !nick.substring(i,i+1).equals(Character.valueOf('\u3164').toString()))
				salida=salida+nick.substring(i,i+1);
		}
		try {
			enviarTexto(socket, salida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
