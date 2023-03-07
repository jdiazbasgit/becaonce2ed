package tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
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
	
	
	@Override
	public int doStartTag() throws JspException {
		Connection conexion =null;
		try {
			DriverManager.registerDriver((Driver) new ConexionBodyTag());
			conexion = DriverManager.getConnection("jdbc:mysql://82.223.202.137:3306/CHAT","curso","Cursocurso1;");
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

	public Object getConexion() {
		// TODO Auto-generated method stub
		return null;
	}

}
