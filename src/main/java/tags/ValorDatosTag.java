package tags;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import lombok.Data;

@Data
public class ValorDatosTag extends TagSupport { 
	//También valdría SimpleTagSupport nos da herencia de etiqueta sin cuerpo y sin doStart ni doAfter, en su lugar ejecuta doTag()
	private int campo;

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			ConsultaBodyTag consulta = (ConsultaBodyTag) findAncestorWithClass(this,
					Class.forName("tags.ConsultaBodyTag"));			
			//consulta.getResultSet().next();
			pageContext.getOut().println(consulta.getResultSet().getString(getCampo()));
			return EVAL_PAGE;
		} catch (ClassNotFoundException | IOException | SQLException e1) {
			e1.printStackTrace();
			return SKIP_PAGE;
		}

	}

}
