package chat.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.cliente.EnvioMensajesCliente;
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
			if (Servidor.usuarios.containsValue(getChatGridBag().getTNick().getText().trim()))
				getChatGridBag().getTaMensajes().append("El Usuario ya está registrado \n");
			else {
				if(!getChatGridBag().getTNick().getText().trim().equals("")) {
					EnvioRegistrCliente envioRegistrCliente= new EnvioRegistrCliente(Cliente.IP_SERVIDOR, Servidor.PUERTO_ESCUCHA_REGISTRO_SERVIDOR, chatGridBag);
					envioRegistrCliente.start();
					}
					else {
						getChatGridBag().getTaMensajes().append("El nick no puede estar vacio...\n");
					}
			}
		}
		if(e.getSource().equals(getChatGridBag().getBEnviar())){
			EnvioMensajesCliente envioMensajesCliente= new EnvioMensajesCliente(Cliente.IP_SERVIDOR, Servidor.PUERTO_ESCUCHA_MENSAJE_SERVIDOR, chatGridBag);
			envioMensajesCliente.start();
		}
		

	}

}
