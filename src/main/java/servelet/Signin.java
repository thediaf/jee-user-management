package servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.UserDao;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/connexion")
public class Signin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final String SIGNIN_VIEW = "/WEB-INF/signin.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher(SIGNIN_VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		if (!("".equals(login) || "".equals(password))) 
		{
			User user = UserDao.getUser(login, password);
			session.setAttribute("isConnected", true);
			session.setAttribute("sessioned_user", user);
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("message", "Login ou mot de passe incorrect");
			response.sendRedirect("connexion");
		}
	}

}
