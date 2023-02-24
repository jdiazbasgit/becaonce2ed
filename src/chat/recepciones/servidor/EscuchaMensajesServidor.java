package chat.recepciones.servidor;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.servidor.EnvioMensajeServidor;
import chat.envios.servidor.EnvioRegistroServidor;
import chat.recepciones.LevantarServidor;
import chat.recepciones.Servidor;

public class EscuchaMensajesServidor extends Servidor {

	public EscuchaMensajesServidor(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		Connection conexion = null;
		try {
			String mensaje = leerMensaje(socket);
			String ip = socket.getInetAddress().getHostAddress();
			DriverManager.registerDriver(new Driver());
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + Cliente.IP_SERVIDOR + ":" + LevantarServidor.PUERTO_BBDD + "/?useSSL=false",
					"curso", "Cursocurso1;");
						
			PreparedStatement preparedStatementConsulta = conexion
					.prepareStatement("SELECT NAME FROM chatbbdd.users WHERE IP_ADDRESS='"+ip+"';");
			ResultSet resultSet = preparedStatementConsulta.executeQuery();
			String respuesta = null;
			while (resultSet.next()) {					
				respuesta = resultSet.getString(1) + " dice: " + mensaje;					
			}			
			
			PreparedStatement preparedStatementConsulta2 = conexion
					.prepareStatement("SELECT IP_ADDRESS FROM chatbbdd.users;");
			ResultSet resultSet2 = preparedStatementConsulta2.executeQuery();
			while (resultSet2.next()) {					
				EnvioMensajeServidor envioMensajeServidor = new EnvioMensajeServidor(resultSet2.getString(1),
						Cliente.PUERTO_ESCUCHA_MENSAJE_CLIENTE, respuesta);
				envioMensajeServidor.start();					
			}						
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
