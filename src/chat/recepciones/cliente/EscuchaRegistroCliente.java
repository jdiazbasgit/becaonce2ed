package chat.recepciones.cliente;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

import chat.ChatGridBag;
import chat.envios.Cliente;
import chat.recepciones.LevantarServidor;
import chat.recepciones.Servidor;

public class EscuchaRegistroCliente extends Servidor {

	public EscuchaRegistroCliente(int puerto, ChatGridBag chat) {
		super(puerto, chat);
	}

	@Override
	public void hacerAlgo(Socket socket) {
		/*try {
			Cliente.usuarios=(Map<String, String>) leerObjeto(socket);
			getChat().getTaUsuarios().setText("");
			for (String usuario : Cliente.usuarios.values()) {
				getChat().getTaUsuarios().append(usuario+"\n");
				
			}
			getChat().getTNick().setEnabled(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		*/
		Connection conexion = null;
		try {			
			DriverManager.registerDriver(new Driver());
			conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + Cliente.IP_SERVIDOR + ":" + Cliente.PUERTO_BBDD + "/?useSSL=false",
					"curso", "Cursocurso1;");

			PreparedStatement preparedStatementConsulta = conexion
					.prepareStatement("SELECT NAME FROM chatbbdd.users;");
			ResultSet resultSet = preparedStatementConsulta.executeQuery();
			getChat().getTaUsuarios().setText("");
			while (resultSet.next()) {
				getChat().getTaUsuarios().append(resultSet.getString(1)+"\n");				
			}
			getChat().getTNick().setEnabled(false);
			

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
