package tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ConexionBodyTag extends BodyTagSupport {
	private String cadena;
	private String usuario;
	private String clave;

	@Override
	public int doStartTag() throws JspException {
		Connection conexion = null;
		
		try {
			conexion=DriverManager.getConnection(getCadena(), getUsuario(), getClave());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public int doAfterBody() throws JspException {
		
		
		
		/*if (getContador() < getCantidad()) {

			setContador(getContador() + 1);
			return EVAL_BODY_AGAIN;

		} else {
			return SKIP_BODY;
		}*/
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

