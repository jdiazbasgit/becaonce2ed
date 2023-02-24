package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class EjemploDatos {

	public EjemploDatos() {
	}

	public static void main(String[] args) {
		// pasoss para conectar con una base de datos
		// 1.- Registrar el driver
		Connection conexion=null;
		try {
			DriverManager.registerDriver(new Driver());
			// 2.- Crear la conexion
			 conexion = DriverManager.getConnection("jdbc:mysql://82.223.202.137:3306/COMPANY?useSSL=false", "curso",
					"Cursocurso1;");
			// "jdbc:oracle:@thin:localhost:1521:company"

			PreparedStatement row = conexion
					.prepareStatement("insert into roles (rol) values (?)");
			row.setString(1, "Javier");
			//row.execute();
			row.setString(1, "asoltero triste");
			//row.execute();
			row.setString(1, "asoltero solo");
			//row.execute();
			
			PreparedStatement row2 = conexion
					.prepareStatement("delete from mAriTal_staTuses where description like '%soltero%'");
			//row2.execute();

			PreparedStatement preparedStatement = conexion
					.prepareStatement("SELECT name, nif FROM employees");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2));
			}

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
