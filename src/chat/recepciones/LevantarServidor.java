package chat.recepciones;

import chat.recepciones.servidor.EscuchaRegistroServidor;

public class LevantarServidor {

	

	public static void main(String[] args) {
		EscuchaRegistroServidor escuchaRegistroServidor =
				new EscuchaRegistroServidor(Servidor.PUERTO_ESCUCHA_REGISTRO_SERVIDOR,null);
		escuchaRegistroServidor.start();

	}

}
