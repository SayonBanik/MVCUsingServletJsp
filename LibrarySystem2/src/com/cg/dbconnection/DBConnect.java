package com.cg.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
	public static Connection GetDBConnection()
	{
		Connection conn=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/mydatabase95","mydatabase95","Ni1q_wd~hUKz");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
