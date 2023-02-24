package chat.eventos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.cliente.EnvioMensajeCliente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElQueSabeLoQueHayQueHacerConElTeclado implements KeyListener {
	
	private ChatGridBag chatGridBag;
	
	

	public ElQueSabeLoQueHayQueHacerConElTeclado() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			EnvioMensajeCliente envioMensajeCliente= new EnvioMensajeCliente(Cliente.IP_SERVIDOR, Cliente.PUERTO_ENVIO_MENSAJE_SERVIDOR, getChatGridBag());
			envioMensajeCliente.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
