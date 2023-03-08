package tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ConexionBodyTags extends BodyTagSupport {
	
	private String cadena;
	private String usuario;
	private String clave;
	private Connection conexion = null;

	@Override
	public int doStartTag() throws JspException {
		
		try {
			DriverManager.registerDriver(new Driver());
			setConexion(DriverManager.getConnection(cadena, usuario, clave));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return EVAL_BODY_BUFFERED();
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			getConexion().close();
			getBodyContent().writeOut(getPreviousOut());
		} catch (IOException |SQLException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
