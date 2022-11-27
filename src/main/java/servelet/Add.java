package servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;

/**
 * Servlet implementation class Add
 */
@WebServlet("/ajouter")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_NEW_USER = "/WEB-INF/new.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		getServletContext().getRequestDispatcher(VUE_NEW_USER).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getParameter("login") != null) {
			UserDao.add(new User(request.getParameter("lastname"),request.getParameter("firstname"), request.getParameter("login"), request.getParameter("password")));
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("message", "Erreur de creation");
		}
	}

}
