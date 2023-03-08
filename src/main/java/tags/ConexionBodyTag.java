package tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.sql.DataSource;

import lombok.Data;

@Data
public class ConexionBodyTag extends BodyTagSupport {
	
	private Connection conexion;

	
	@Override
	public int doStartTag() throws JspException {
		
		try {
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
			
		
	}


	@Override
	public int doEndTag() throws JspException {
		try {
			getBodyContent().writeOut(getPreviousOut());
			return EVAL_PAGE;
		} catch (IOException e) {
			e.printStackTrace();
			return SKIP_PAGE;
		}
	}



	

}
