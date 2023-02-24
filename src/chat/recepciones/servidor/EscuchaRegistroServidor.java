package chat.recepciones.servidor;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.envios.servidor.EnvioMensajeServidor;
import chat.envios.servidor.EnvioRegistroServidor;
import chat.recepciones.LevantarServidor;
import chat.recepciones.Servidor;

public class EscuchaRegistroServidor extends Servidor {

	public EscuchaRegistroServidor(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {		

		Connection conexion = null;
		try {

			String nick = null;
			try {
				nick = leerMensaje(socket);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String ip = socket.getInetAddress().getHostAddress();
			DriverManager.registerDriver(new Driver());
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + Cliente.IP_SERVIDOR + ":" + Cliente.PUERTO_BBDD + "/?useSSL=false",
					"curso", "Cursocurso1;");

			PreparedStatement preparedStatementConsulta = conexion
					.prepareStatement("SELECT NAME FROM chatbbdd.users;");
			ResultSet resultSet = preparedStatementConsulta.executeQuery();
			boolean usado = false;
			while (resultSet.next()) {
				if (resultSet.getString(1).equals(nick)) {
					EnvioMensajeServidor envioMensajeServidor = new EnvioMensajeServidor(ip,
							Cliente.PUERTO_ESCUCHA_MENSAJE_CLIENTE, "el usuario ya existe");
					envioMensajeServidor.start();
					usado = true;
					// return;
				}
			}
			
			if (!usado) {
				PreparedStatement preparedStatement1 = conexion.prepareStatement(
						"INSERT INTO chatbbdd.users (NAME,IP_ADDRESS)" + " VALUES ('" + nick + "','" + ip + "');");
				preparedStatement1.execute();
				PreparedStatement preparedStatementConsulta2 = conexion
						.prepareStatement("SELECT IP_ADDRESS FROM chatbbdd.users;");
				ResultSet resultSet2 = preparedStatementConsulta2.executeQuery();
				while (resultSet2.next()) {					
						EnvioRegistroServidor envioRegistroServidor= new EnvioRegistroServidor(resultSet2.getString(1), Cliente.PUERTO_ESCUCHA_REGISTRO_CLIENTE, getChat());
						envioRegistroServidor.start();					
				}
			}

		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}

	}

}
