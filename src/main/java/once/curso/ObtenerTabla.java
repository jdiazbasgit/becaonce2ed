package once.curso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//import com.mysql.jdbc.Driver;

public class ObtenerTabla {

	public static void main(String[] args) {
		Connection conexion = null;
		try {			
			System.out.println("Versión 1.1\n"
					+ "**ATENCION:**\n"
					+ "Errores conocidos: se aplicarán por defecto relaciones @ManyToOne y se pueden generar Imports no utlizados, revisar el resultado\n"
					+ "Changelog 1.1: Eliminada la línea que bloquea la autoconfiguración de SpringBoot del archivo .yml"
					+ "\n"  
					+"  autoconfigure:\n"  
					+"    exclude: org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration\n"
					+"La exclusión de la autoconfiguración estaba causando que el entityManagerFactory no fuera creado automáticamente\n");
			System.out.println("Pulsa intro para continuar");
			leerTecladoTexto();
			System.out.println(" \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
			System.out.println("Escribe el nombre del esquema:");
			String esquema = leerTecladoTexto();
			String paquete = "package once.curso."+esquema.toLowerCase();
			File carpetaEntities = new File("src/main/java/once/curso/"+esquema.toLowerCase()+"/entities");
		    carpetaEntities.mkdirs();
		    File carpetaRepositories = new File("src/main/java/once/curso/"+esquema.toLowerCase()+"/repositories");
		    carpetaRepositories.mkdirs();
		    File carpetaServices = new File("src/main/java/once/curso/"+esquema.toLowerCase()+"/services");
		    carpetaServices.mkdirs();
		    System.out.println("Creadas las carpetas del proyecto");
			//DriverManager.registerDriver(new Driver());
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://82.223.202.137:3306/"+esquema+"?useSSL=false",
					"curso", "Cursocurso1;");
			PreparedStatement preparedStatementEsquema = conexion.prepareStatement("SELECT table_name FROM information_schema.tables "
					+ "WHERE table_schema = '"+esquema+"' AND table_type = 'BASE TABLE';");
			preparedStatementEsquema.execute();
			ResultSet resultSetEsquema = preparedStatementEsquema.executeQuery();
			String importsPrincipal = paquete+";\n" +
					"import org.springframework.beans.factory.annotation.Autowired;\n" + 
					"import org.springframework.boot.CommandLineRunner;\n" + 
					"import org.springframework.boot.SpringApplication;\n" + 
					"import org.springframework.boot.autoconfigure.SpringBootApplication;\n" + 
					"\n" + 
					"import lombok.Data;\n";
			String propiedadesPrincipal = "";
			String runsPrincipal = "";
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
				String equalsDATETIME = "DATETIME";
				String equalsDATE = "DATE";
				String equalsDECIMAL = "DECIMAL";
				String equalsTINYINT = "TINYINT";
				String equalsBLOB = "BLOB";
				//String containsID = "_id";
				boolean primeraVezImportColum = true;
				boolean primeraVezImportTemporal = true;
				boolean primeraVezImportJoin = true;
				String listaDeImports = "";
				String contenidoClase =  
				"import javax.persistence.Entity;\n" + 
				"import javax.persistence.GeneratedValue;\n" + 
				"import javax.persistence.GenerationType;\n" + 
				"import javax.persistence.Table;\n" +
				"import javax.persistence.Id;\n"+
				"import lombok.Data;"+
						"\n" +
						"@Data\n"+
						"@Entity\n"+
						"@Table (name = \""  +tabla+  "\") \n"+
						"public class "+tablaAClase +" {\n" + 
						"\n";
				String listaPrintsRun = "";
				while (i<=metadata.getColumnCount()) {
					
					String tipoDato = metadata.getColumnTypeName(i);
					String valorDato = metadata.getColumnName(i).toLowerCase();
					if (metadata.isAutoIncrement(i)) {
						contenidoClase = contenidoClase + "@Id\n"
						+ "@GeneratedValue(strategy = GenerationType.AUTO)\n";
					}
					if (tipoDato.equals(equalsINT)) {
						tipoDato = tipoDato.toLowerCase();
					}
					if (tipoDato.equals(equalsBLOB)) {
						tipoDato = "byte[]";
					}
					if (tipoDato.equals(equalsTINYINT)) {
						tipoDato = "boolean";
					}
					if (tipoDato.equals(equalsDECIMAL)) {
						tipoDato = "double";
					}
					if (tipoDato.equals(equalsVARCHAR)) {
						tipoDato = "String";
						contenidoClase = contenidoClase + "@Column (length = "+metadata.getColumnDisplaySize(i)+")\n";
						if (primeraVezImportColum) {
						listaDeImports = listaDeImports + "import javax.persistence.Column;\n";
						primeraVezImportColum = false;
						}
					}
					if (tipoDato.equals(equalsDATETIME) || tipoDato.equals(equalsDATE)) {
						tipoDato = "Calendar";
						contenidoClase = contenidoClase + "@Temporal (TemporalType.DATE)\n";
						if (primeraVezImportTemporal) {
						listaDeImports = listaDeImports + "import java.util.Calendar;\n"
								+"import javax.persistence.Temporal;\n"
								+"import javax.persistence.TemporalType;\n";
						primeraVezImportTemporal = false;
						}
					}
					if (valorDato.endsWith("_id")) {						
						contenidoClase = contenidoClase + "@ManyToOne\n@JoinColumn(name = \""+valorDato+"\")\n";	
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
						if (primeraVezImportJoin) {
						listaDeImports = listaDeImports
								+ "import javax.persistence.JoinColumn;\n"
								+ "import javax.persistence.ManyToOne;\n";
						primeraVezImportJoin = false;
						}
					}
					if (valorDato.contains("_")) {
						String[] porPartes = valorDato.split("_");
						String textoModificado = "";
						int j = 1;
						while (j <= porPartes.length) {
							if (j==1) {
							textoModificado = textoModificado + porPartes[j-1].toLowerCase();
							j++;
							continue;
							}
							if (j<= porPartes.length)
							textoModificado = textoModificado + porPartes[j-1].substring(0, 1).toUpperCase() + porPartes[j-1].substring(1);
							j++;
						}						
						valorDato = textoModificado;
						//valorDato = tipoDato.substring(0, 1).toLowerCase() + tipoDato.substring(1);						
					}
					
					
					contenidoClase = contenidoClase + "private "+ tipoDato + " "+  valorDato + ";\n";
					String getOrIs = ".get";
					if (tipoDato.equals("boolean")) {
						getOrIs = ".is";
					}
					listaPrintsRun = listaPrintsRun + "System.out.println("+tablaAClase.substring(0, 1).toLowerCase() + tablaAClase.substring(1)+
							getOrIs+valorDato.substring(0, 1).toUpperCase() + valorDato.substring(1)+"());\n";
					i++;
				}		
				//leerTecladoTexto();
				
				contenidoClase = paquete+".entities;\n"+listaDeImports+contenidoClase +"}";
				grabaArchivoSobreescribiendo("src/main/java/once/curso/"+esquema.toLowerCase()+"/entities/"+tablaAClase+".java", contenidoClase);
				System.out.println("---------------ENTITY CREADO CON EXITO------------------\n");
				
				String contenidoRepo = "package once.curso."+esquema.toLowerCase()+".repositories;\n" + 
						"\n" + 
						"import org.springframework.data.repository.CrudRepository;\n" + 
						"import org.springframework.stereotype.Repository;\n" + 
						"import once.curso."+esquema.toLowerCase()+".entities."+tablaAClase+";\n" + 
						"@Repository\n" + 
						"public interface "+tablaAClase+"CRUDRepository extends CrudRepository<"+tablaAClase+", Integer> {\n" + 
						"\n" + 
						"	\n" + 
						"}";
				grabaArchivoSobreescribiendo("src/main/java/once/curso/"+esquema.toLowerCase()+"/repositories/"+tablaAClase+"CRUDRepository.java", contenidoRepo);
				System.out.println("---------------REPOSITORY CREADO CON EXITO------------------\n");
				
				String contenidoServ = "package once.curso."+esquema.toLowerCase()+".services;\n" + 
						"\n" + 
						"import java.util.Optional;\n" + 
						"\n" + 
						"import org.springframework.beans.factory.annotation.Autowired;\n" + 
						"import org.springframework.stereotype.Service;\n" + 
						"\n" + 
						"import lombok.Data;\n" + 
						"import once.curso."+esquema.toLowerCase()+".entities."+tablaAClase+";\n" + 
						"import once.curso."+esquema.toLowerCase()+".repositories."+tablaAClase+"CRUDRepository;\n" + 
						"\n" + 
						"@Service\n" + 
						"@Data\n" + 
						"public class "+tablaAClase+"Service {\n" + 
						"\n" + 
						"	@Autowired\n" + 
						"	private "+tablaAClase+"CRUDRepository "+tablaAClase.substring(0, 1).toLowerCase() + tablaAClase.substring(1)+"CRUDRepository;\n" + 
						"\n" + 						
						"	public <S extends "+tablaAClase+"> S save(S entity) {\n" + 
						"		return get"+tablaAClase+"CRUDRepository().save(entity);\n" + 
						"	}\n" + 
						"\n" + 
						"	public <S extends "+tablaAClase+"> Iterable<S> saveAll(Iterable<S> entities) {\n" + 
						"		return get"+tablaAClase+"CRUDRepository().saveAll(entities);\n" + 
						"	}\n" + 
						"\n" + 
						"	public Optional<"+tablaAClase+"> findById(Integer id) {\n" + 
						"		return get"+tablaAClase+"CRUDRepository().findById(id);\n" + 
						"	}\n" + 
						"\n" + 
						"	public boolean existsById(Integer id) {\n" + 
						"		return get"+tablaAClase+"CRUDRepository().existsById(id);\n" + 
						"	}\n" + 
						"\n" + 
						"	public Iterable<"+tablaAClase+"> findAll() {\n" + 
						"		return get"+tablaAClase+"CRUDRepository().findAll();\n" + 
						"	}\n" + 
						"\n" + 
						"	public Iterable<"+tablaAClase+"> findAllById(Iterable<Integer> ids) {\n" + 
						"		return get"+tablaAClase+"CRUDRepository().findAllById(ids);\n" + 
						"	}\n" + 
						"\n" + 
						"	public long count() {\n" + 
						"		return get"+tablaAClase+"CRUDRepository().count();\n" + 
						"	}\n" + 
						"\n" + 
						"	public void deleteById(Integer id) {\n" + 
						"		get"+tablaAClase+"CRUDRepository().deleteById(id);\n" + 
						"	}\n" + 
						"\n" + 
						"	public void delete("+tablaAClase+" entity) {\n" + 
						"		get"+tablaAClase+"CRUDRepository().delete(entity);\n" + 
						"	}\n" + 
						"\n" + 
						"	public void deleteAllById(Iterable<? extends Integer> ids) {\n" + 
						"		get"+tablaAClase+"CRUDRepository().deleteAllById(ids);\n" + 
						"	}\n" + 
						"\n" + 
						"	public void deleteAll(Iterable<? extends "+tablaAClase+"> entities) {\n" + 
						"		get"+tablaAClase+"CRUDRepository().deleteAll(entities);\n" + 
						"	}\n" + 
						"\n" + 
						"	public void deleteAll() {\n" + 
						"		get"+tablaAClase+"CRUDRepository().deleteAll();\n" + 
						"	}\n" + 
						"}";
				grabaArchivoSobreescribiendo("src/main/java/once/curso/"+esquema.toLowerCase()+"/services/"+tablaAClase+"Service.java", contenidoServ);
				System.out.println("---------------SERVICIO CREADO CON EXITO------------------\n");
				System.out.println("\n\n\n\n\n\n\n\n");
				
				importsPrincipal = importsPrincipal + "import once.curso."+esquema.toLowerCase()+".services."+tablaAClase+"Service;\n"+
						"import once.curso."+esquema.toLowerCase()+".entities."+tablaAClase+";\n";
				propiedadesPrincipal = propiedadesPrincipal + 
						"@Autowired\nprivate "+tablaAClase+"Service "+
						tablaAClase.substring(0, 1).toLowerCase() + tablaAClase.substring(1)+"Service;\n";
				runsPrincipal = runsPrincipal+ "\nIterable<"+tablaAClase+"> iter"+tablaAClase+" = get"+tablaAClase+"Service"+"().findAll();\n"+
				"for ("+tablaAClase+" "+tablaAClase.substring(0, 1).toLowerCase() + tablaAClase.substring(1)+" : iter"+tablaAClase+") {\n"+
				listaPrintsRun+"}\n";
			}
			System.out.print("Escribe un nombre para la aplicación: ");
			String nombreAplicacion = leerTecladoTexto();
			String contenidoPrincipal = importsPrincipal +
					"@SpringBootApplication\n@Data\n" +
					"public class "+nombreAplicacion+" implements CommandLineRunner {\n" +
					propiedadesPrincipal +
					"public static void main(String[] args) {\n" +
					"SpringApplication.run("+nombreAplicacion+".class, args);\n}\n" +
					"public void run(String... args) throws Exception {\n" +
					"\n//--------------Código prescindible, imprimirá el contenido de las tablas en consola---------------\n" +
					runsPrincipal+
					"//--------------                                                                    ---------------\n"+
					"\n}\n}";
			grabaArchivoSobreescribiendo("src/main/java/once/curso/"+esquema.toLowerCase()+"/"+nombreAplicacion+".java", contenidoPrincipal);
			System.out.println("Ejecución terminada"
					+ " **Revisa el resultado y configura la conexión en el yml conforme al esquema ("+esquema+")**\n"
					+ "Ej: url: jdbc:mysql://127.0.0.1:3306/"+esquema);
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conexion.close();
			} catch (SQLException e) {
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