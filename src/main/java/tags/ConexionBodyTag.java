package tags;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.sql.DataSource;

import com.mysql.jdbc.Driver;

import lombok.Data;

@Data
public class ConexionBodyTag extends BodyTagSupport {

			DriverManager.registerDriver(new Driver());
			setConexion(DriverManager.getConnection(cadena,
					usuario, clave));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return EVAL_BODY_BUFFERED;

			InitialContext ctx= new InitialContext();
			DataSource dataSource=(DataSource) ctx.lookup("java:comp/env/jdbc/empresas");
			setConexion(dataSource.getConnection());
			//ResultSet resultSet=conexion.prepareStatement("select descripcion from cargos").executeQuery();
			//while(resultSet.next()) {
			//	System.out.println(resultSet.getString(1));
			//}
			return EVAL_BODY_BUFFERED;
		} catch (Exception e) {
			e.printStackTrace();
			return SKIP_PAGE;
		} 
			
		
			getConexion().close();
			getBodyContent().writeOut(getPreviousOut());
			return EVAL_PAGE;
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return SKIP_PAGE;		 
		}
	}

}
