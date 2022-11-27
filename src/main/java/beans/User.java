package beans;

public class User {
	
	private int id;
	private String lastname, firstname, login, password;

	public User()
	{
		
	}
	
	public User(String lastname, String firstname, String login, String password)
	{
		this.setLastname(lastname);
		this.setFirstname(firstname);
		this.setLogin(login);
		this.setPassword(password);
	}

	public User(int id, String lastname, String firstname, String login, String password)
	{
		this(lastname, firstname, login, password);
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
