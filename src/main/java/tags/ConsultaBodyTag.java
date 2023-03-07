package tags;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import lombok.Data;

@Data
public class ConsultaBodyTag extends BodyTagSupport {
	private String sentencia;
	private ResultSet ResultSet;
	

	@Override
	public int doStartTag() throws JspException {
		try {
			ConexionBodyTag conexion = (ConexionBodyTag) findAncestorWithClass(this, Class.forName("tags.ConexionBodyTag"));			
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sentencia);
			setResultSet(preparedStatement.executeQuery());
			getResultSet().next();	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
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
