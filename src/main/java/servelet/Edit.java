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
		HttpSession session = request.getSession();
		
		UserForm form = new UserForm(request);
		boolean status = form.handle(form.EDIT_MODE);
		
		request.setAttribute("status", status);
		request.setAttribute("statusMessage", form.getStatusMessage());
		
		if (status) 
		{
			response.sendRedirect("list");
		}
		else
		{
			request.setAttribute("user", form.getUser());
			request.setAttribute("errors", form.getErrors());
			this.doGet(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
