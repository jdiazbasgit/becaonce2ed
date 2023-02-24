package baseDatos;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatosEmpleado {

	public DatosEmpleado() {
	}

	public static void main(String[] args) {
		Connection conexion = null;
		try {
			DriverManager.registerDriver(new Driver());
			conexion = DriverManager.getConnection("jdbc:mysql://82.223.202.137:3306/COMPANY?useSSL=false", "curso",
					"Cursocurso1;");
			PreparedStatement preparedStatement = conexion.prepareStatement("SELECT name FROM employees");
			PreparedStatement preparedStatement1 = conexion.prepareStatement("SELECT salary FROM laboral_information");
			PreparedStatement preparedStatement2 = conexion.prepareStatement("SELECT guys FROM children");
			PreparedStatement preparedStatement3 = conexion.prepareStatement("SELECT description FROM marital_statuses");
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			ResultSet resultSet3 = preparedStatement3.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
			while (resultSet1.next()) {
				System.out.println(resultSet1.getString(1));
			}
			while (resultSet2.next()) {
				System.out.println(resultSet2.getString(1));
			}
			while (resultSet3.next()) {
				System.out.println(resultSet3.getString(1));
			}
		}

		catch (SQLException e) {
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
