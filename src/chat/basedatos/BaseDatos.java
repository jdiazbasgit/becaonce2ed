package chat.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class BaseDatos {

	public static final String SERVER_LINK = "jdbc:mysql://82.223.202.137:3306/CHAT";
	public static final String SERVER_USER = "curso";
	public static final String SERVER_PASS = "Cursocurso1;";
	
	public BaseDatos() {
	}
	
	public Connection getConexion() throws SQLException {
		Connection conexion= null;
		try {
			DriverManager.registerDriver(new Driver());
			conexion=DriverManager.getConnection(BaseDatos.SERVER_LINK, BaseDatos.SERVER_USER, BaseDatos.SERVER_PASS);
			return conexion;
		} catch (SQLException e) {
			throw e;
		}
		
	}
	
	public void desconexion(Connection conexion) throws SQLException {
		conexion.close();
	}
	
	public ResultSet dameUsuarios() {
		return null;
	}
	public void agregarUsuario(String usuario) {
		
	}
	public void quitarUsuario(String usuario0) {
		
	}
	
	public String dameIpDeUsuario(String usuario) {
		return null;
	}

}