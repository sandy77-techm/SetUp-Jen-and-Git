package com.qa.CROMPRO.Pages;

public class Credentials {

	String appusername;
	String apppassword;
	
	public Credentials(String appusername,String apppassword)
	{
		this.appusername = appusername;
		this.apppassword = apppassword;
				
	}
	
	public String getAppusername()
	{
		return appusername;
	}
	
	public void SetAppusername(String appusername)
	{
		this.appusername = appusername;
	}
	
	
	public String getApppassword()
	{
		return apppassword;
	}
	
	public void setApppassword(String apppassword)
	{
		this.apppassword = apppassword;
	}
}
