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
	public static final String CADENA = "jdbc:mysql://82.223.202.137:3306/CHAT";
	public static final String USUARIO = "curso";
	public static final String PASWORD = "Cursocurso1;";
	
	@Override
	public int doStartTag() throws JspException {
		Connection conexion =null;
		try {
			DriverManager.registerDriver((Driver) new ConexionBodyTag());
			conexion = DriverManager.getConnection(ConexionBodyTag.CADENA, ConexionBodyTag.USUARIO,ConexionBodyTag.PASWORD);
			return EVAL_BODY_BUFFERED;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
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
