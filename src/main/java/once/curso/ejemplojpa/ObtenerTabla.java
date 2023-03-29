package once.curso.ejemplojpa;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ObtenerTabla {

	public ObtenerTabla() {
	}

	public static void main(String[] args) {
		Connection conexion = null;
		try {
			DriverManager.registerDriver(new Driver());
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://82.223.202.137:3306/COMPANY?useSSL=false",
					"curso", "Cursocurso1;");
			
			PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM COMPANY.employees");
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.executeQuery();			
			ResultSetMetaData metadata = resultSet.getMetaData();
			int i = 1;
			String tabla = "charges";
			String tablaAClase = "Charge";
			//String tablaUpCap = tabla.substring(0, 1).toUpperCase() + tabla.substring(1);
			String equalsINT = "INT";
			String contenidoClase = "package once.curso.ejemplojpa.entities;\r\n" + 
			"import javax.persistence.Entity;\r\n" + 
			"import javax.persistence.GeneratedValue;\r\n" + 
			"import javax.persistence.GenerationType;\r\n" + 
			"import javax.persistence.Table;\r\n" + 
			"import org.springframework.data.annotation.Id;"+
			"import lombok.Data;"+
					"\r\n" +
					"@Data\r\n"+
					"@Entity\r\n"+
					"@Table (name = \""  +tabla+  "\") \r\n"+
					"public class "+tablaAClase +" {\r\n" + 
					"\r\n" +
					"@Id" +
					"\r\n" +
					"@GeneratedValue(strategy = GenerationType.AUTO)"+
					"\r\n";
			while (resultSet.next()) {
				String tipoDato = metadata.getColumnTypeName(i);
				if (tipoDato.equals(contenidoClase))
					tipoDato.toLowerCase();
				contenidoClase = contenidoClase + "private "+ metadata.getColumnTypeName(i) + " "+  metadata.getColumnName(i) + ";\r\n";
				//" +resultSet.getString(i) + "\";\r\n";			
				i++;
			}			
			
			contenidoClase = contenidoClase +"}";
			grabaArchivoSobreescribiendo("src/main/java/once/curso/ejemplojpa/entities/"+tablaAClase+".java", contenidoClase);
			
			

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
	public static  void grabaArchivoSobreescribiendo(String archivo, String textoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, false);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.println(textoAGrabar);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}