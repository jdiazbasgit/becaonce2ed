package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class PrimerServlet extends HttpServlet {

	private int contador;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().println("<h1>estamos en un curso</h1>");
		// response.getWriter().flush();
		
		setContador(getContador()+1);
		String texto = request.getParameter("texto");
		// response.getWriter().println("<script>alert('estamos a punto de irnos a
		// casa')</script>");
		String salida = "<h1 style='color:#00ff00'>has escrito " + texto.toUpperCase() + " y tiene " + texto.length()
				+ " letras</h1>";
		response.getWriter().println(salida);
		
		
		
		response.getWriter().println("<h1>ERES EL VISITANTE NUMERO: " + getContador() + "</h1>");
		HttpSession mochila=request.getSession(true);
		if(mochila.getAttribute("visitas")==null) {
			mochila.setAttribute("visitas", 1);
		}
		else {
			int visitas=(Integer) mochila.getAttribute("visitas");
			visitas++;
			mochila.setAttribute("visitas", visitas);
		};
		response.getWriter().println("<h1>TU HAS VIENIDO A VERME:"+mochila.getAttribute("visitas")+" VECES</h1>");
		
		response.getWriter().flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

}
