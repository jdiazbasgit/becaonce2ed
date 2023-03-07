package tags;

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
		// TODO Auto-generated method stub
		return super.doStartTag();
	}


	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}



	public ConexionBodyTag() {
		// TODO Auto-generated constructor stub
	}

}
