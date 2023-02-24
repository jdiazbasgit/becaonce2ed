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
import chat.envios.servidor.EnvioRegistroServidor;
import chat.recepciones.LevantarServidor;
import chat.recepciones.Servidor;

public class EscuchaBajaServidor extends Servidor {

	public EscuchaBajaServidor(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {

		Connection conexion = null;
		try {			
			String ip = socket.getInetAddress().getHostAddress();
			DriverManager.registerDriver(new Driver());
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + Cliente.IP_SERVIDOR + ":" + LevantarServidor.PUERTO_BBDD + "/?useSSL=false",
					"curso", "Cursocurso1;");
			PreparedStatement preparedStatement1 = conexion.prepareStatement(
					"DELETE FROM chatbbdd.users WHERE IP_ADDRESS='"+ip+"';");
			preparedStatement1.execute();
						
			PreparedStatement preparedStatementConsulta2 = conexion
					.prepareStatement("SELECT IP_ADDRESS FROM chatbbdd.users;");
			ResultSet resultSet2 = preparedStatementConsulta2.executeQuery();
			while (resultSet2.next()) {					
					EnvioRegistroServidor envioRegistroServidor= new EnvioRegistroServidor(resultSet2.getString(1), Cliente.PUERTO_ESCUCHA_REGISTRO_CLIENTE, getChat());
					envioRegistroServidor.start();					
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
