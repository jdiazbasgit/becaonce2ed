package once.curso.ejemplojpa;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ObtenerTabla {

	public ObtenerTabla() {
	}

	public static void main(String[] args) {
		Connection conexion = null;
		try {
			System.out.println("Versión 1.0, se aplicarán por defecto relaciones @ManyToOne, revisar el resultado\n");
			System.out.println("Escribe el nombre del esquema:");
			String esquema = leerTecladoTexto();
			DriverManager.registerDriver(new Driver());
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://82.223.202.137:3306/"+esquema+"?useSSL=false",
					"curso", "Cursocurso1;");
			PreparedStatement preparedStatementEsquema = conexion.prepareStatement("SELECT table_name FROM information_schema.tables "
					+ "WHERE table_schema = '"+esquema+"' AND table_type = 'BASE TABLE';");
			preparedStatementEsquema.execute();
			ResultSet resultSetEsquema = preparedStatementEsquema.executeQuery();
			while (resultSetEsquema.next()) {
				System.out.println("Creando entorno SB JPA para tabla: "+ resultSetEsquema.getString(1) );
				String tabla = resultSetEsquema.getString(1);
				System.out.println("Escribe el nombre para la Clase (PascalCase y Singular): ");
				String tablaAClase = leerTecladoTexto();
				PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM "+esquema+"."+tabla);
				preparedStatement.execute();
				ResultSet resultSet = preparedStatement.executeQuery();			
				ResultSetMetaData metadata = resultSet.getMetaData();
				int i = 1;
				String equalsINT = "INT";
				String equalsVARCHAR = "VARCHAR";
				String equalsDATE = "DATE";
				String containsID = "_id";
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
				while (i<=metadata.getColumnCount()) {
					String tipoDato = metadata.getColumnTypeName(i);
					System.out.println(metadata.getColumnDisplaySize(i));
					if (tipoDato.equals(equalsINT)) {
						tipoDato = tipoDato.toLowerCase();
					}
					if (tipoDato.equals(equalsVARCHAR)) {
						tipoDato = "String";
					}
					if (tipoDato.equals(equalsDATE)) {
						tipoDato = "GregorianCalendar";
					}
					if (tipoDato.contains(containsID)) {
						String textoModificado = tipoDato.replaceAll("_(\\w)", "$1");
						tipoDato = textoModificado;
					}
					
					
					contenidoClase = contenidoClase + "private "+ tipoDato + " "+  metadata.getColumnName(i).toLowerCase() + ";\r\n";
					i++;
				}		
				leerTecladoTexto();
				
				contenidoClase = contenidoClase +"}";
				grabaArchivoSobreescribiendo("src/main/java/once/curso/ejemplojpa/entities/"+tablaAClase+".java", contenidoClase);
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
	public static  void grabaArchivoSobreescribiendo(String archivo, String textoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, false);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.println(textoAGrabar);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static String leerTecladoTexto() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			return bufferedReader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

}