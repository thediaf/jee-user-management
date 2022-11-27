package dao;

import java.util.ArrayList;

import beans.User;

public class UserDao 
{
	private static int lastId = 1;
	private static ArrayList<User> users = new ArrayList<User>();
	
	static {
		UserDao.add(new User("Camara", "Mady", "mady", "1234"));
		UserDao.add(new User("Ndiaye", "Serigne Fallou", "fallou", "1234"));
		UserDao.add(new User("Samb", "Abdalaye", "laye", "1234"));
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
	
	public static void add(User user)
	{
		user.setId(lastId++);
		users.add(user);
	}
	
	public static Boolean edit(User editing_user)
	{
		for(User user : users)
		{
			if (user.equals(editing_user))
			{
				user.setLastname(editing_user.getLastname());
				user.setFirstname(editing_user.getFirstname());
				user.setLogin(editing_user.getLogin());
				user.setPassword(editing_user.getPassword());
				return true;
			}
		}
		
		return false;		
	}
	
	public static Boolean delete(int id)
	{
		for(User user : users)
		{
			if (user.getId() == id)
			{
				users.remove(id);
				return true;
			}
		}
		
		return false;
	}
}
