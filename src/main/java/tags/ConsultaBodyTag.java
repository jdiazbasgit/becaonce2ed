package tags;


import javax.servlet.jsp.tagext.BodyTagSupport;

public class ConsultaBodyTag extends BodyTagSupport {

	private String sentencia;
	
	
	public ConsultaBodyTag() {
		
	}

=======
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import lombok.Data;

@Data
public class ConsultaBodyTag extends BodyTagSupport {

	private ResultSet resultSet;
	private String sentencia;
	@Override
	public int doStartTag() throws JspException {
		ConexionBodyTag papa=(ConexionBodyTag) getParent();
		try {
			setResultSet(papa.getConexion().prepareStatement(getSentencia()).executeQuery());
			getResultSet().next();
		} catch (SQLException e) {
			e.printStackTrace();
			return SKIP_PAGE;
		}
		return EVAL_BODY_BUFFERED;
	}

	

	@Override
	public int doAfterBody() throws JspException {
		try {
			while(getResultSet().next()) {
				return EVAL_BODY_AGAIN;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			return SKIP_PAGE;
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
