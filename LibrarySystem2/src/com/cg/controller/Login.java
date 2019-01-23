package com.cg.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.service.LibraryServiceImpl;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   LibraryServiceImpl lSer=null;
   
   static Logger logger = Logger.getLogger(Login.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		lSer=new LibraryServiceImpl();
		
		 PropertyConfigurator.configure("C:\\Users\\saybanik\\eclipse-workspace\\LibrarySystem\\Logs\\log4j.properties");
		
		int uId=Integer.parseInt(request.getParameter("uId")); 
		String pass=request.getParameter("pass");
		
		try 
		{
			if(lSer.Login(uId, pass)) 
			{
				request.setAttribute("userName", uId);
				request.getRequestDispatcher("Welcome.jsp").forward(request, response); 
			}
			
			else
			{
				String error="Invalid User Id or Password";
				request.setAttribute("error", error);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
		
		catch (SQLException e)
		{
			String error="Unable to connect to Database\n"+e.getStackTrace();
			request.setAttribute("error", error);
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
	}

}
