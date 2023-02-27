package chat.recepciones.cliente;

import java.net.Socket;
import java.util.Map;

import chat.ChatGridBag;
import chat.basedatos.BaseDatos;
import chat.envios.Cliente;
import chat.recepciones.Servidor;

public class EscuchaRegistroCliente extends Servidor {

	public EscuchaRegistroCliente(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void hacerAlgo(Socket socket) {
		try {			
			BaseDatos basedatos = new BaseDatos();
			
			Cliente.usuarios=(Map<String, String>) leerObjeto(socket);

			for (String usuario : Cliente.usuarios.values()) {
				getChat().AddListItem(usuario);
				basedatos.agregarUsuario(usuario, Cliente.IP_SERVIDOR);
			}
						
			
			/*for (String usuario : Cliente.usuarios.values()) {
				System.out.println(usuario+"\n");
				users=usuario.toString();
			}
			getChat().getListUsuarios();
			
			getChat().getTaUsuarios().setText("");
			for (String usuario : Cliente.usuarios.values()) {
				getChat().getTaUsuarios().append(usuario+"\n");
				
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
