package tags;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import lombok.Data;

@Data
public class ConexionBodyTag extends BodyTagSupport {
	private String cadena;
	private String usuario;
	private String clave;

	@Override
	public int doStartTag() throws JspException {
/*
		Connection conexion = null;
		DriverManager.registerDriver(new Driver());
		conexion = DriverManager.getConnection(getCadena(), getUsuario(), getClave());
		PreparedStatement preparedStatement1 = conexion.prepareStatement(ConsultaTag.getSentencia());
*/		
		
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

}
