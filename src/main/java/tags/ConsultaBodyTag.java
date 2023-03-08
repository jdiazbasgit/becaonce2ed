package tags;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
//cambios de git para subir

public class ConsultaBodyTag extends BodyTagSupport {
	
	private ResultSet resultSet;

	@Override
	public int doStartTag() throws JspException {
		
		try {
			ConexionBodyTags conexion = (ConexionBodyTags) findAncestorWithClass(this, Class.forName("tags.ConexionBodyTag"));
			PreparedStatement preparedStatement = conexion.getConexion().preparedStatement(sentencia);
			setResultSet(preparedStatement.executeQuery());
			getResultSet().next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return super.EVAL_BODY_BUFFERED();
	}

	@Override
	public int doAfterBody() throws JspException {
		
		return super.doAfterBody();
	}
	@Override
	public int doEndTag() throws JspException {
		
		return super.doEndTag();
	}

	
	

}
