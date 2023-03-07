package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
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
public class ConsultaBodyTag extends BodyTagSupport {
	private String sentencia;
	private ResultSet resultSet;

	@Override
	public int doStartTag() throws JspException {			
		try {
			ConexionBodyTag conexion = (ConexionBodyTag) findAncestorWithClass(this, Class.forName("tags.ConexionBodyTag"));			
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sentencia);
			setResultSet(preparedStatement.executeQuery());
			getResultSet().next();			
		} catch (ClassNotFoundException |SQLException e1) {
			e1.printStackTrace();
		}
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public int doAfterBody() throws JspException {		
		try {
			while (getResultSet().next()) {				
				return EVAL_BODY_AGAIN;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return SKIP_BODY;		
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
