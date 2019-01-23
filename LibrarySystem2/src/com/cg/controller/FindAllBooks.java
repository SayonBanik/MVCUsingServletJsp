package com.cg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cg.entities.Book;
import com.cg.service.LibraryServiceImpl;


@WebServlet("/FindAllBooks")
public class FindAllBooks extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(Login.class);
	
	 LibraryServiceImpl lSer=null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		lSer=new LibraryServiceImpl();
		
		try 
		{ 
			List<Book> bList=lSer.FindAllBooks();
			
			if(bList.isEmpty()) 
			{
				logger.debug("List 'bList' is empty in Controller");
				String error="Book Table is empty";
				request.setAttribute("error", error);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
				
			else
			{
				logger.debug("List found for 'Find All Books' in Controller and is being sent to view");
				request.setAttribute("bList", bList);
				request.getRequestDispatcher("BookDetails.jsp").forward(request, response);
			}
		} 
		
		catch (SQLException e) 
		{
			logger.error("SQL Exception occured"+e.getStackTrace());
			String error="Unable to connect to Database";
			request.setAttribute("error", error);
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
	}



}
