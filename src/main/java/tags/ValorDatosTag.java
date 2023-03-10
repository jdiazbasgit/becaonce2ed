package tags;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import lombok.Data;

@Data
public class ValorDatosTag extends TagSupport {

	private int campo;
	
	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		ConsultaBodyTag papa= (ConsultaBodyTag) getParent();
		try {
			pageContext.getOut().println(papa.getResultSet().getString(getCampo()));
			return EVAL_PAGE;
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return SKIP_PAGE;
		}	
	}
	
	

}
