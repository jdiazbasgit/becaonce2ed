package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import lombok.Data;

@Data
public class ConexionBodyTag extends BodyTagSupport {
	private String cadena;
	private String usuario;
	private String clave;

	@Override
	public int doStartTag() throws JspException {
		DriverManager.registerDriver(new Driver());
		conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false",
				"curso", "Cursocurso1;");
		return EVAL_BODY_BUFFERED;
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
