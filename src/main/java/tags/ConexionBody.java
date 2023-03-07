package tags;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import lombok.Data;


@SuppressWarnings("serial")
@Data
public class ConexionBody extends BodyTagSupport {

	private String cadena;
	private String usuario;
	private String clave;
	
	@SuppressWarnings("unused")
	@Override
	public int doStartTag() throws JspException {
	//return super.doStartTag();
	Connection conexion = null;
	try {
		conexion = DriverManager.getConnection(getCadena(), getUsuario(), getClave());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return EVAL_BODY_BUFFERED;
	}
	public int doAfterBody() throws JspException {
		if (getUsuario() == getClave()) {

			setClave(getClave() +1);
			return EVAL_BODY_AGAIN;

		} else {
			return SKIP_BODY;
		}
	}
	
	
	 @Override
	 public int doEndTag() throws JspException{
		 return super.doStartTag();
	 }
	
	public ConexionBody() {
		
	}

}
