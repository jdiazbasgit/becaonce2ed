package chat.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class BaseDatos {

	public static final String SERVER_LINK = "jdbc:mysql://82.223.202.137:3306/CHAT";
	public static final String SERVER_USER = "curso";
	public static final String SERVER_PASS = "Cursocurso1;";
	

	public static final String QUERY_TOTALUSERS="SELECT CHAT.USUARIO FROM CHAT.USUARIOS";
	public static final String QUERY_INSERT="INSERT INTO CHAT.USUARIO (USUARIO,IP) VALUES (?,?)";
	public static final String QUERY_DELETE="DELETE FROM CHAT.USUARIOS WHERE IP=?";
	//public static final String QUERY_IP="SELECT IP FROM CHAT.USUSARIOS WHERE USUARIO=?";
	
	
	public BaseDatos() {
	}
	
	public Connection establishConnection() throws SQLException {
		Connection conexion= null;
		try {
			DriverManager.registerDriver(new Driver());
			conexion=DriverManager.getConnection(BaseDatos.SERVER_LINK, BaseDatos.SERVER_USER, BaseDatos.SERVER_PASS);
			return conexion;
		} catch (SQLException e) {
			throw e;
		}
		
	}
	
	public void disconnect(Connection conexion) throws SQLException {
		conexion.close();
	}
	
	public ResultSet dameUsuarios() {
		ResultSet resultSet = null;
		try (PreparedStatement preparedStatement =  establishConnection().prepareStatement(BaseDatos.QUERY_TOTALUSERS)){
			
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
			PreparedStatement preparedStatement=  establishConnection().prepareStatement(BaseDatos.QUERY_INSERT);
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, ip);
			preparedStatement.execute();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void quitarUsuario(String ip) {
		try {
			PreparedStatement preparedStatement= establishConnection().prepareStatement(BaseDatos.QUERY_DELETE);
			preparedStatement.setString(1,ip);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String dameIpDeUsuario(String usuario) {
		return null;
	}

}