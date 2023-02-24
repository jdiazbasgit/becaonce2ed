package chat.recepciones;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chat.envios.Cliente;
import chat.recepciones.servidor.EscuchaBajaServidor;
import chat.recepciones.servidor.EscuchaMensajesServidor;
import chat.recepciones.servidor.EscuchaRegistroServidor;

public class LevantarServidor {


	public static final int PUERTO_BBDD = 3306;

	public static void main(String[] args) {
		EscuchaRegistroServidor escuchaRegistroServidor =
				new EscuchaRegistroServidor(Servidor.PUERTO_ESCUCHA_REGISTRO_SERVIDOR,null);
		escuchaRegistroServidor.start();
		EscuchaBajaServidor escuchaBajaServidor= new EscuchaBajaServidor(Servidor.PUERTO_ESCUCHA_BAJA_SERVIDOR, null);
		escuchaBajaServidor.start();
		EscuchaMensajesServidor escuchaMensajesServidor= new EscuchaMensajesServidor(Servidor.PUERTO_ESCUCHA_MENSAJE_SERVIDOR, null);
		escuchaMensajesServidor.start();
		
		Connection conexion = null;
		try {
			DriverManager.registerDriver(new Driver());			
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://"+Cliente.IP_SERVIDOR+":"+PUERTO_BBDD+ "/?useSSL=false",
					"curso", "Cursocurso1;");
			
			PreparedStatement preparedStatement1 = conexion.prepareStatement("DROP TABLE IF EXISTS chatbbdd.users;");
			preparedStatement1.execute();
			
			PreparedStatement preparedStatement2 = conexion.prepareStatement("CREATE TABLE chatbbdd.users ("
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,"
					+ "  `NAME` VARCHAR(45) NOT NULL,"
					+ "  `IP_ADDRESS` VARCHAR(45) NOT NULL,"
					+ "  PRIMARY KEY (`ID`));");
			preparedStatement2.execute();
			
			/*ResultSet resultSet3 = preparedStatement3.executeQuery();
			while (resultSet3.next()) {
				System.out.println("Conozcamos a "+ resultSet3.getString(1).toUpperCase() 
				+ ", tiene un salario humilde de "+ resultSet3.getString(2)
				+ " granos de arroz, que emplea para cazar palomas. Las guisa junto a "+ resultSet3.getString(3)
				+ " hijo gandul que acogió tras quedarse "+ resultSet3.getString(4).toLowerCase()+"\n");				
			}*/				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
