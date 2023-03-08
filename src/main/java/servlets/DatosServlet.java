package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import lombok.Data;

/**
 * Servlet implementation class DatosServlet
 */
@Data
public class DatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String variableAplicacion;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setAttribute("variableRequest", "soy variabel de request");
		// request.getSession(true).setAttribute("variableSesion", "soy variabel de
		// sesion");
		// setVariableAplicacion("soy variable de aplicacion");
		try {
			InitialContext ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/empresas");
			Connection conexion = dataSource.getConnection();
			ResultSet resultSet = conexion.prepareStatement("select id,descripcion from cargos").executeQuery();
			List<Cargo> cargos = new ArrayList();
			while (resultSet.next()) {
				Cargo cargo = new Cargo();
				cargo.setId(resultSet.getString(1));
				cargo.setDescripcion(resultSet.getString(2));
				cargos.add(cargo);
			}
			request.setAttribute("cargos", cargos);
			getServletContext().getRequestDispatcher("/el.jsp").forward(request, response);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/el.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
