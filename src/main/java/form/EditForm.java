package form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.User;
import dao.UserDao;

public class EditForm 
{
	private static final String LASTNAME = "lastname";
	private static final String FIRSTNAME = "firstname";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String PASSWORD_CONFIRM = "confirm_password";
	
	private static final String ADD_ERROR_MESSAGE = "Erreur d'ajout";
	private static final String ADD_SUCCESS_MESSAGE = "Ajout effectue avec succes";
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Vous devez renseigner ce champ";
	private static final String PASSWORD_CONFIRMATION_FAILED = "Veuillez saisir des mots de passe identiques";
	
	private HttpServletRequest request;
	private Map<String, String> errors;
	private User user;
	private boolean status;
	private String statusMessage;

	public EditForm(HttpServletRequest request)
	{
		this.request = request;
		this.status = false;
		this.statusMessage = ADD_ERROR_MESSAGE;
		this.errors = new HashMap<String, String>();
	}

	public boolean add() 
	{
		String lastname = this.getParameter(LASTNAME);
		String firstname = this.getParameter(FIRSTNAME);
		String login = this.getParameter(LOGIN);
		String password = this.getParameter(PASSWORD);
		
		this.user = new User(lastname, firstname, login, password);
		this.inputsValidation(LASTNAME, FIRSTNAME, LOGIN, PASSWORD);
		this.passwordValidation();

		if (this.errors.isEmpty()) 
		{
			UserDao.add(user);
			this.status = true;
			this.statusMessage = ADD_SUCCESS_MESSAGE;
		}

		return this.status;
	}
 
	public String getParameter(String parameter)
	{
		String value = this.request.getParameter(parameter);
		
		return (value == null || value.trim().isEmpty()) ? null : value.trim();
	}

	public void inputsValidation(String...inputs)
	{
		for (String input : inputs) {
			if (this.getParameter(input) == null) 
			{
				errors.put(input, EMPTY_FIELD_ERROR_MESSAGE);	
			}
		}
	}

	public void passwordValidation()
	{
		String password = this.getParameter(PASSWORD);
		String passwordConfirm = this.getParameter(PASSWORD_CONFIRM);
		
		if (password != null && !password.equals(passwordConfirm)) 
		{
			errors.put(PASSWORD, PASSWORD_CONFIRMATION_FAILED);
			errors.put(PASSWORD_CONFIRM, PASSWORD_CONFIRMATION_FAILED);	
		}
	}

	public User getUser() 
	{
		return user;
	}

	public boolean isStatus()
	{
		return status;
	}

	public String getStatusMessage() 
	{
		return statusMessage;	
	}

	public Map<String, String> getErrors()
	{
		return errors;
	}

}
