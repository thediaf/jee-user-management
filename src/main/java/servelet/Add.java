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
import form.UserForm;

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
		HttpSession session = request.getSession();
		
		UserForm form = new UserForm(request);
		boolean status = form.handle(form.CREATE_MODE);
		
		request.setAttribute("status", status);
		request.setAttribute("statusMessage", form.getStatusMessage());
		
		if (status) 
		{
			session.setAttribute("isConnected", true);
			session.setAttribute("sessioned_user", form.getUser());
			response.sendRedirect("list");
		}
		else
		{
			request.setAttribute("user", form.getUser());
			request.setAttribute("errors", form.getErrors());
			this.doGet(request, response);
		}
//		 if (request.getParameter("login") != null) {
//		 	UserDao.add(new User(request.getParameter("lastname"),request.getParameter("firstname"), request.getParameter("login"), request.getParameter("password")));
//		 	response.sendRedirect("list");
//		 }
//		 else {
//		 	request.setAttribute("message", "Erreur de creation");
//		 }
	}

}
