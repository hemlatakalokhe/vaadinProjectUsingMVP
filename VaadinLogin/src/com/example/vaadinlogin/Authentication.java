package com.example.vaadinlogin;
public class Authentication
{
	private String userName;
	private String password;
	
	public Authentication()
	{
		setUserName("Hemlata");
		setPassword("h123");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean authenticate(String userName,String password)
	{
		if(userName.equals(getUserName())&& password.equals(getPassword()))
		{
			return true;
		}
		return false;
	}
}