package chat.eventos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import chat.envios.Cliente;
import chat.envios.cliente.EnvioBajaCliente;

public class ElQueSabeLoQueHayQueHacerConLaVentana implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		EnvioBajaCliente envioBajaCliente= new EnvioBajaCliente(Cliente.IP_SERVIDOR, Cliente.PUERTO_ENVIO_BAJA_CLIENTE, null);
		envioBajaCliente.start();
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

}
