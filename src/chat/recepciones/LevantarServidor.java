package chat.recepciones;

import chat.recepciones.servidor.EscuchaBajaServidor;
import chat.recepciones.servidor.EscuchaMensajeServidor;
import chat.recepciones.servidor.EscuchaRegistroServidor;

public class LevantarServidor {

	public static void main(String[] args) {
		EscuchaRegistroServidor escuchaRegistroServidor = new EscuchaRegistroServidor(Servidor.PUERTO_ESCUCHA_REGISTRO_SERVIDOR,null);
		escuchaRegistroServidor.start();

		EscuchaMensajeServidor escuchaMensajeServidor = new EscuchaMensajeServidor(Servidor.PUERTO_ESCUCHA_MENSAJE_SERVIDOR,null);
		escuchaMensajeServidor.start();

		EscuchaBajaServidor escuchaBajaServidor= new EscuchaBajaServidor(Servidor.PUERTO_ESCUCHA_BAJA_SERVIDOR, null);
		escuchaBajaServidor.start();

	}

}
