package com.cg.test;

import static org.junit.Assert.assertFalse;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.entities.Transaction;
import com.cg.service.LibraryServiceImpl;

class FindBooksNotReturnedTest {

	LibraryServiceImpl target;
	
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
	void testThatReturnsListOfTransactionObjects() throws SQLException 
	{
		List<Transaction> resultActual=target.FindBooksNotReturned();
		assertFalse(resultActual.isEmpty());
		
	}

}
