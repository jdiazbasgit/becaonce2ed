package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;

import lombok.Data;

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
			setConexion(DriverManager.getConnection(cadena,
					usuario, clave));
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
