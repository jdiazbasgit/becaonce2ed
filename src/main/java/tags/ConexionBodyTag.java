package tags;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import javafx.print.Collation;
import lombok.Data;

@Data
public class ConexionBodyTag extends BodyTagSupport {
	private String cadena;
	private String usuario;
	private String clave;

	@Override
	public int doStartTag() throws JspException {
		Connection conexion = null;

		try {
			conexion = DriverManager.getConnection(getCadena(), getUsuario(), getClave());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_BUFFERED;

	}

	@Override
	public int doEndTag() throws JspException {
		
		getConexion().close();
		try {
			
			getBodyContent().writeOut(getPreviousOut());
			return EVAL_PAGE;
		} catch (IOException e) {
			e.printStackTrace();
			return SKIP_PAGE;
		}
	}

}