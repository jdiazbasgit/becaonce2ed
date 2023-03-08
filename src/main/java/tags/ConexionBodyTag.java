package tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.mysql.jdbc.Driver;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ConexionBodyTag extends BodyTagSupport {
	private String cadena;
	private String usuario;
	private String clave;
	private Connection conexion = null;

	@Override
	public int doStartTag() throws JspException {
		
		try {
			DriverManager.registerDriver(new Driver());
			setConexion(DriverManager.getConnection(getCadena(),getUsuario(), getClave()));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return EVAL_BODY_BUFFERED;
	}


	@Override
	public int doEndTag() throws JspException {
		try {
			getConexion().close();
			getBodyContent().writeOut(getPreviousOut());
			return EVAL_PAGE;
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return SKIP_PAGE;		 
		}
	}

}
