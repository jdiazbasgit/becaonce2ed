package tags;

import java.io.IOException;
import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import lombok.Data;

@Data
public class ConexionBodyTag extends BodyTagSupport {
	private String cadena;
	private String usuarios;
	private String clave;
	private Connection conexion =null;
	
	@Override
	public int doStartTag() throws JspException {
		//Connection conexion =null;//
		try {
			DriverManager.registerDriver(new Driver());
			setConexion(DriverManager.getConnection(getCadena(),getUsuarios(),getClave()));
			return EVAL_BODY_BUFFERED;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_PAGE;
		
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			getBodyContent().writeOut(getPreviousOut());
			return EVAL_PAGE;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return SKIP_PAGE;
		}
		
	}


}
