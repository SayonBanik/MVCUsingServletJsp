package com.cg.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cg.entities.Member;
import com.cg.service.LibraryServiceImpl;


@WebServlet("/MemberId")
public class MemberDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(Login.class);
	
	 LibraryServiceImpl lSer=null;
	 Member mRecord=null;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		lSer=new LibraryServiceImpl();
		
		int id=Integer.parseInt(request.getParameter("mId"));
		
		try 
		{
			mRecord=lSer.FindMember(id);
			
			if(mRecord==null)
			{
				logger.debug("object 'mRecord' of type Member is null in Controller");
				String error="Invalid Member Id";
				request.setAttribute("error", error);
				request.getRequestDispatcher("MemberCredential.jsp").forward(request, response);
			}
			
			else
			{
				logger.debug("object 'mRecord' of type Member found in Controller and is being sent to view");
				request.setAttribute("mRecord", mRecord);
				request.getRequestDispatcher("MemberDetails.jsp").forward(request, response);
			}
		} 
		
		catch (SQLException e)  
		{
			logger.error("SQL Exception occured"+e.getStackTrace());
			String error="Could not connect to database";
			request.setAttribute("error", error);
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
	
	}


}
