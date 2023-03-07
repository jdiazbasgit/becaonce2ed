package tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ValorDatosTag extends TagSupport {
	
@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		//RepeticionesBodyTag papa = (RepeticionesBodyTag) getParent();
		ConexionBodyTag papa=null;
		try {
			papa = (ConexionBodyTag) findAncestorWithClass(this, Class.forName("tags.ConexionBodyTag"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			/*if (isTipo())
				pageContext.getOut().println(papa.getTexto().toUpperCase());
			else
				pageContext.getOut().println(papa.getTexto().toLowerCase());*/
			return EVAL_PAGE;
		} catch (IOException e) {
			e.printStackTrace();
			return SKIP_PAGE;
		}

	}

	
}
