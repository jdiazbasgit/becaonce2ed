package chat.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.cliente.EnvioMensajesCliente;
import chat.envios.cliente.EnvioRegistrCliente;
import chat.recepciones.Servidor;

public class ElQueSabeLoQueHacerConElTeclado implements KeyListener {
	
	private ChatGridBag chatGridBag;
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(getChatGridBag().getBRegistrar())) {
			if(!getChatGridBag().getTNick().getText().trim().equals("")) {
				EnvioRegistrCliente envioRegistrCliente= new EnvioRegistrCliente(Cliente.IP_SERVIDOR, Servidor.PUERTO_ESCUCHA_REGISTRO_SERVIDOR, chatGridBag);
				envioRegistrCliente.start();		
			}
			else {
				getChatGridBag().getTaMensajes().append("No puedes enviar un mensaje en blanco...\n");
			}
		}
		if(e.getSource().equals(getChatGridBag().getBEnviar())){
			EnvioMensajesCliente envioMensajesCliente= new EnvioMensajesCliente(Cliente.IP_SERVIDOR,Servidor.PUERTO_ESCUCHA_MENSAJE_SERVIDOR, chatGridBag);
			envioMensajesCliente.start();
		}
		

	}


	private ChatGridBag getChatGridBag() {
		
		return null;
	}


	public ElQueSabeLoQueHacerConElTeclado() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
