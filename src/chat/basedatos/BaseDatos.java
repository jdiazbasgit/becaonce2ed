package chat.basedatos;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;



public class BaseDatos {
	public static final String  BASEMYSQL="jdbc:mysql://82.223.202.137:3306/CHAT"; 
	public static final String NOMBRECURSO="curso";
	public static final String CONTRACURSO="Cursocurso1;";
	public static final String DAMEUSUARIO="SELECT CHAT.USUARIO FROM CHAT.USUARIOS";
	public static final String INSERTARUS= "INSERT INTO USUARIOS (USUARIO,IP)VALUES ('?','?')";
    public static final String QUITARUSU=  " DELETE  FROM USUARIOS where USUARIO LIKE  '?'"; 


	public BaseDatos() {
	}
	
	public Connection getConexion() throws SQLException {
		Connection conexion= null;
		try {
			DriverManager.registerDriver(new Driver());
			conexion=DriverManager.getConnection(BASEMYSQL, NOMBRECURSO, CONTRACURSO);
			return conexion;
		} catch (SQLException e) {
			throw e;
		}
		
	}
	
	public void desconexion(Connection conexion) throws SQLException {
		
		conexion.close();
	}
	
	public ResultSet dameUsuarios() {
		ResultSet resulSet = null;
		 try {
			 PreparedStatement preparedStatement = (PreparedStatement ) getConexion().prepareStatement(DAMEUSUARIO);
			 resulSet= preparedStatement.executeQuery();
					 while (resulSet.next()) {
						 System.out.println(resulSet.getString(1));
					 }
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return resulSet;
	}
	public void agregarUsuario(String usuario) {
	
		 try {
			 PreparedStatement preparedStatement = (PreparedStatement ) getConexion().prepareStatement(INSERTARUS);
			
					
					 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		
	
	public void quitarUsuario(String usuario0) {
		
	}
	
	public String dameIpDeUsuario(String usuario) {
		return null;
	}

}
