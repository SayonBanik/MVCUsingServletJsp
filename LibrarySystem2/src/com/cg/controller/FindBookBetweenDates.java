package com.cg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cg.entities.Transaction;
import com.cg.service.LibraryServiceImpl;


@WebServlet("/FindBookBetweenDates")
public class FindBookBetweenDates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(Login.class);
	
	LibraryServiceImpl lSer=null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		lSer=new LibraryServiceImpl();
		
		String sDate=request.getParameter("sDate");
		String eDate=request.getParameter("eDate");
		
		try
		{
			Date startDate=new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
			Date endDate=new SimpleDateFormat("yyyy-MM-dd").parse(eDate);
			
			List<Transaction> tRecord=lSer.FindBookBetweenDates(startDate, endDate);
			
			if(tRecord.isEmpty())
			{
				logger.debug("List 'tRecord' is empty in Controller"); 
				String error="Sorry,No result found.";  
				request.setAttribute("error", error);
				request.getRequestDispatcher("TransactionCredentials.jsp").forward(request, response);
			}
			
			else
			{
				logger.debug("List found for 'Transaction Between Given Dates' in Controller and is being sent to view");
				request.setAttribute("tRecord", tRecord);
				request.getRequestDispatcher("Details.jsp").forward(request, response);
			}
		} 
		
		catch (ParseException | SQLException e) 
		{
			
			logger.error("SQL Exception occured"+e.getStackTrace());
			String error="Could not connect to database";
			request.setAttribute("error", error);
			request.getRequestDispatcher("Error.jsp").forward(request, response); 
		}
		
	}


}
