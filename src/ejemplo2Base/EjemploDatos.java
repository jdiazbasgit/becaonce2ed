package ejemplo2Base;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EjemploDatos {

	public EjemploDatos() {
	}

	public static void main(String[] args) {
		Connection conexion = null;
		try {
			DriverManager.registerDriver(new Driver());
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false",
					"curso", "Cursocurso1;");
			
			PreparedStatement preparedStatement3 = conexion.prepareStatement("select em.name, li.salary, ch.guys, ms.description \r\n"
					+ "from employees as em, laboral_information as li, children as ch, marital_statuses as ms, personal_information as pi\r\n"
					+ "\r\n"
					+ "where ms.id=pi.marital_statuses_id\r\n"
					+ "and ch.id=pi.children_id\r\n"
					+ "and li.id=em.LABORAL_INFORMATION_ID\r\n"
					+ "and em.PERSONAL_INFORMATION_ID=pi.id;");
			preparedStatement3.execute();
			ResultSet resultSet3 = preparedStatement3.executeQuery();
			while (resultSet3.next()) {
				System.out.println("Conozcamos a "+ resultSet3.getString(1).toUpperCase() 
				+ ", tiene un salario humilde de "+ resultSet3.getString(2)
				+ " granos de arroz, que emplea para cazar palomas. Las guisa junto a "+ resultSet3.getString(3)
				+ " hijo gandul que acogió tras quedarse "+ resultSet3.getString(4).toLowerCase()+"\n");				
			}			
			
			/*PreparedStatement preparedStatement2 = conexion.prepareStatement("select girls FROM  children");
			preparedStatement2.execute();
			ResultSet resultSet = preparedStatement2.executeQuery();
			while (resultSet.next()) {
				System.out.println("sus hijas son: "+ resultSet.getString(1) );				
			}

			PreparedStatement preparedStatement = conexion.prepareStatement("SELECT salary FROM laboral_information");
			
			ResultSet resultSet1 = preparedStatement.executeQuery();
			while (resultSet1.next()) {
				System.out.println("el sueldo es el siguiente: "+ resultSet1.getString(1) );
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
