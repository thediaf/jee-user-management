package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.User;

public class UserDao 
{
	private static ArrayList<User> users = new ArrayList<User>();
	
	private static final String CREATE_QUERY = "INSERT INTO user(lastname, firstname, login, password) VALUES (?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE user SET lastname=?, firstname=?, login=?, password=? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM user WHERE id = ?;";
    private static final String FINDALL_QUERY = "select * from user";
	
	static {
		Connection conn = DbConnection.openConnexion();
		Statement stm;
		if( conn != null) {
			
			try {
				stm = conn.createStatement();
				ResultSet res = stm.executeQuery(FINDALL_QUERY);
				while(res.next()) {
					User user = new User(res.getInt("id"), res.getString("lastname"), res.getString("firstname"), res.getString("login"), res.getString("password"));
					users.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static ArrayList<User> users()
	{	
		return users;
	}
	
	public static User get(int id)
	{
		for(User user : users)
		{
			if (user.getId() == id)
				return user;
		}
		
		return null;
	}
	
	public static User getUser(String login, String password)
	{
		for(User user : users)
		{
			if (user.getLogin().equals(login) && user.getPassword().equals(password))
				return user;
		}
		
		return null;
	}
	
	public static boolean add(User user)
	{
		Connection conn = DbConnection.openConnexion();
		try{
			PreparedStatement ps = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getLastname());
			ps.setString(2, user.getFirstname());
			ps.setString(3, user.getLogin());
			ps.setString(4, user.getPassword());
			if(ps.executeUpdate()!=0) {
				ResultSet keys = ps.getGeneratedKeys();
				if(keys.next()) {
					user.setId(keys.getInt(1));
					users.add(user);
				}
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnexion(conn);
		}
		return true;
	}
	
	public static Boolean edit(User editing_user)
	{
		
		for (User user : users)
		{
			if (editing_user.getId() == user.getId())
			{
				user.setLastname(editing_user.getLastname());
				user.setFirstname(editing_user.getFirstname());
				user.setLogin(editing_user.getLogin());
				user.setPassword(editing_user.getPassword());
				// update on the DB
				Connection conn = DbConnection.openConnexion();
				try{
					PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);
					ps.setString(1, editing_user.getLastname());
					ps.setString(2, editing_user.getFirstname());
					ps.setString(3, editing_user.getLogin());
					ps.setString(4, editing_user.getPassword());
					ps.setInt(5, editing_user.getId());
					if(ps.executeUpdate()!=0) {
						return true;
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					DbConnection.closeConnexion(conn);
				}
			}
		}

		return false;
	}
	
	public static Boolean delete(int id)
	{
		for (User user : users)
		{
			if (user.getId() == id)
			{
				Connection conn = DbConnection.openConnexion();
				try{
					PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);
					ps.setInt(1, id);
					if(ps.executeUpdate()!=0) {
						users.remove(user);
						return true;
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					DbConnection.closeConnexion(conn);
				}
			}
		}

		return false;
	}
}
