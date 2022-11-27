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
 * Servlet implementation class Update
 */
@WebServlet("/modifier")
public class Edit extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final String USER_EDIT_VIEW = "/WEB-INF/edit.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));

		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (id > 0) {
			User user = UserDao.get(id);
	        request.setAttribute("user", user);
	        getServletContext().getRequestDispatcher(USER_EDIT_VIEW).forward(request, response);
		}
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getParameter("login") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String lastname = request.getParameter("lastname");
			String firstname = request.getParameter("firstname");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			UserDao.edit(new User(id, lastname, firstname, login, password));
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("message", "Erreur de creation");
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}