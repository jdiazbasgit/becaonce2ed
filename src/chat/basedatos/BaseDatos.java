package chat.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class BaseDatos {
	
	public static final String CADENA = "jdbc:mysql://82.223.202.137:3306/CHAT";
	public static final String USUARIO = "curso";
	public static final String PASSWORD = "Cursocurso1";
	public static final String QUERY_CONSULTA = "SELECT USUARIO FROM CHAT.USUARIOS";
	public static final String QUERY_INSERTA = "INSERT INTO CHAT.USUARIOS (USUARIO) VALUES (?,?)";
	public static final String QUERY_BORRA = "DELETE FROM CHAT.USUARIOS WHERE USUARIO = ?";
	public static final String QUERY_CONSULTA_IP = "SELECT IP FROM CHAT.USUARIOS WHERE USUARIO = ?";

	public BaseDatos() {
	}

	public Connection getConexion() throws SQLException {
		Connection conexion = null;
		try {
			DriverManager.registerDriver(new Driver());
			conexion = DriverManager.getConnection(BaseDatos.CADENA, BaseDatos.USUARIO, BaseDatos.PASSWORD);
			return conexion;
		} catch (SQLException e) {
			throw e;
		}

	}

	public void desconexion(Connection conexion) throws SQLException {
		conexion.close();
	}

	public ResultSet dameUsuarios() {
		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = getConexion().prepareStatement(BaseDatos.QUERY_CONSULTA);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public void agregarUsuario(String usuario, String ip) {
		try {
			PreparedStatement preparedStatement = getConexion().prepareStatement(BaseDatos.QUERY_INSERTA);
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, ip);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void quitarUsuario(String usuario) {
		try {
			PreparedStatement preparedStatement = getConexion().prepareStatement(BaseDatos.QUERY_BORRA);
			preparedStatement.setString(1, usuario);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String dameIpDeUsuario(String usuario) throws SQLException {
		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = getConexion().prepareStatement(BaseDatos.QUERY_CONSULTA_IP);
			preparedStatement.setString(1, usuario);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
