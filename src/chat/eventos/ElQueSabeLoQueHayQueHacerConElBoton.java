package chat.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.cliente.EnvioMensajeCliente;
import chat.envios.cliente.EnvioRegistrCliente;
import chat.recepciones.Servidor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElQueSabeLoQueHayQueHacerConElBoton implements ActionListener {

	private ChatGridBag chatGridBag;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(getChatGridBag().getBRegistrar())) {
			if(!getChatGridBag().getTNick().getText().trim().equals("")) {
			EnvioRegistrCliente envioRegistrCliente= new EnvioRegistrCliente(Cliente.IP_SERVIDOR, Servidor.PUERTO_ESCUCHA_REGISTRO_SERVIDOR, getChatGridBag());
			envioRegistrCliente.start();
			}
			else {
				getChatGridBag().getTaMensajes().append("El nick no puede estar vacio...\n");
			}
		}
		if(e.getSource().equals(getChatGridBag().getBEnviar())){
			EnvioMensajeCliente envioMensajeCliente= new EnvioMensajeCliente(Cliente.IP_SERVIDOR, Cliente.PUERTO_ENVIO_MENSAJE_SERVIDOR, getChatGridBag());
			envioMensajeCliente.start();
			
			
		}
		

	}

}
