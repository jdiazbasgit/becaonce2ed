package once.curso.ejemplojpa;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mysql.jdbc.Driver;

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
				String tabla = resultSetEsquema.getString(1);
				System.out.println("Creando entorno SB JPA para tabla: "+ tabla);
				System.out.print("Escribe nombre para la Entity "+ tabla + " en PascalCase y Singular: ");
				String tablaAClase = leerTecladoTexto();
				PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM "+esquema+"."+tabla);
				preparedStatement.execute();
				ResultSet resultSet = preparedStatement.executeQuery();			
				ResultSetMetaData metadata = resultSet.getMetaData();
				int i = 1;
				String equalsINT = "INT";
				String equalsVARCHAR = "VARCHAR";
				String equalsDATE = "DATETIME";
				//String containsID = "_id";
				String paquete = "package once.curso.ejemplojpa.entities;\r\n";
				String listaDeImports = "";
				String contenidoClase = paquete + listaDeImports + 
				"import javax.persistence.Entity;\r\n" + 
				"import javax.persistence.GeneratedValue;\r\n" + 
				"import javax.persistence.GenerationType;\r\n" + 
				"import javax.persistence.Table;\r\n" + 
				"import javax.persistence.Column;\r\n" +	
				"import java.util.Calendar;\r\n" +	
				"import javax.persistence.Temporal;\r\n" +
				"import javax.persistence.TemporalType;\r\n" +				
				"import javax.persistence.Id;\r\n"+
				"import javax.persistence.JoinColumn;\r\n"+
				"import javax.persistence.ManyToOne;\r\n"+				
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
					String valorDato = metadata.getColumnName(i).toLowerCase();
					if (tipoDato.equals(equalsINT)) {
						tipoDato = tipoDato.toLowerCase();
					}
					if (tipoDato.equals(equalsVARCHAR)) {
						tipoDato = "String";
						contenidoClase = contenidoClase + "@Column (length = "+metadata.getColumnDisplaySize(i)+")\r\n";
					}
					if (tipoDato.equals(equalsDATE)) {
						tipoDato = "Calendar";
						contenidoClase = contenidoClase + "@Temporal (TemporalType.DATE)\r\n";
					}
					if (valorDato.endsWith("_id")) {						
						contenidoClase = contenidoClase + "@ManyToOne\r\n@JoinColumn(name = \""+valorDato+"\")\r\n";	
						String[] porPartes = valorDato.split("_");
						String textoModificado = "";
						int j = 1;
						while (j <= porPartes.length) {
							if (j==1) {
							textoModificado = textoModificado + porPartes[j-1].toLowerCase();
							j++;
							continue;
							}
							if (j< porPartes.length)
							textoModificado = textoModificado + porPartes[j-1].substring(0, 1).toUpperCase() + porPartes[j-1].substring(1);
							j++;
						}						
						valorDato = textoModificado;
						System.out.println("**Detectada propiedad del tipo "+valorDato);
						System.out.print("Por favor escríbelo en PascalCase y Singular: ");
						tipoDato = leerTecladoTexto();
						valorDato = tipoDato.substring(0, 1).toLowerCase() + tipoDato.substring(1);
						listaDeImports = listaDeImports + "import once.curso.pruebasjpa.entities."+tipoDato+"\r\n";
					}
					
					
					contenidoClase = contenidoClase + "private "+ tipoDato + " "+  valorDato + ";\r\n";
					i++;
				}		
				//leerTecladoTexto();
				
				contenidoClase = listaDeImports+contenidoClase +"}";
				grabaArchivoSobreescribiendo("src/main/java/once/curso/ejemplojpa/entities/"+tablaAClase+".java", contenidoClase);
				System.out.println("---------------CREADO CON EXITO------------------\r\n");
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