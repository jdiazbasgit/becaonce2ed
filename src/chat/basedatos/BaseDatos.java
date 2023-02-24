package chat.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class BaseDatos {

	public BaseDatos() {
	}
	
	public Connection getConexion() throws SQLException {
		Connection conexion= null;
		try {
			DriverManager.registerDriver(new Driver());
			conexion=DriverManager.getConnection("jdbc:mysql://82.223.202.137:3306/CHAT", "curso", "Cursocurso1;");
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
