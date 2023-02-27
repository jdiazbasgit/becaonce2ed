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
	public static final String PASWORD = "Cursocurso1;";
	public static final String QUERY_CONSULTA = "SELECT CHAT.USUARIO FROM CHAT.USUARIOS";
	public static final String QUERY_ALTA = "INSERT INTO CHAT.USUSARIO (USUARIO,IP) VALUES (?,?)";
	public static final String QUERY_BAJA = "DELETE FROM CHAT.USUARIOS WHERE USUARIO=?";
	public static final String QUERY_IP = "SELECT IP FRON CHAT.USUSARIOS WHERE USUARIO=?";

	public BaseDatos() {
	}

	public Connection getConexion() throws SQLException {
		Connection conexion = null;
		try {
			DriverManager.registerDriver(new Driver());
			conexion = DriverManager.getConnection(BaseDatos.CADENA, BaseDatos.USUARIO, BaseDatos.PASWORD);
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
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public void agregarUsuario(String usuario, String ip) {

		try {
			PreparedStatement preparedStatement = getConexion().prepareStatement(BaseDatos.QUERY_ALTA);
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, ip);
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void quitarUsuario(String usuario0) {

		try {
			PreparedStatement preparedStatement = getConexion().prepareStatement(BaseDatos.QUERY_BAJA);
			preparedStatement.setString(1, USUARIO);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String dameIpDeUsuario(String usuario) {
		ResultSet resulSet = null;
		try {
			PreparedStatement preparedStatement = getConexion().prepareStatement(BaseDatos.QUERY_IP);
			preparedStatement.setString(1, USUARIO);
			resulSet = preparedStatement.executeQuery();
			resulSet.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;

	}

}