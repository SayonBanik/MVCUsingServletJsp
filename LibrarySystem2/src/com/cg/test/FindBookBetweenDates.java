package com.cg.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.entities.Transaction;
import com.cg.service.LibraryServiceImpl;

class FindBookBetweenDates {

	LibraryServiceImpl target;
	Date sDate;
	Date eDate;
	
	@BeforeEach
	void setUp() throws Exception
	{
		target=new LibraryServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		target=null;
	}

	@Test
	void testThatReturnsListOfTransactionObjects() throws ParseException, SQLException 
	{
		sDate=new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-17");
		eDate=new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-19");
		
		List<Transaction> resultActual=target.FindBookBetweenDates(sDate, eDate);
		
		assertFalse(resultActual.isEmpty());
	}
	
	@Test
	void testThatReturnsEmptyListOfTypeTransaction() throws ParseException, SQLException 
	{
		sDate=new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-17");
		eDate=new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-19");
		
		List<Transaction> resultActual=target.FindBookBetweenDates(sDate, eDate);
		
		assertTrue(resultActual.isEmpty());
	}

}
