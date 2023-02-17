package chat.recepciones.cliente;

import java.net.Socket;
import java.util.Map;

import javax.swing.JOptionPane;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.recepciones.Servidor;

public class EscuchaRegistroCliente extends Servidor {

	public EscuchaRegistroCliente(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		try {
			Cliente.usuarios=(Map<String, String>) leerObjeto(socket);
			for (String  nuevoNick : Servidor.usuarios.values()) {
			if(nuevoNick.equals(usuarios)) {
			JOptionPane.showInputDialog("Este usuario ya está registrado, elige otro");
			}else {
			getChat().getTaUsuarios().setText("");
			for (String usuario : Cliente.usuarios.values()) {
				getChat().getTaUsuarios().append(usuario+"\n");
			}
			}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}

}
