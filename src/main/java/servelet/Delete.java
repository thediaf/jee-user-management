package servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/supprimer")
public class Delete extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	/**+
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));

		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("id") != null) {
			UserDao.delete(id);
		}
		response.sendRedirect("list");
	}

}
