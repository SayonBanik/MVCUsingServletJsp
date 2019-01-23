package com.cg.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.entities.Book;
import com.cg.service.LibraryServiceImpl;

class FindBookByIdTest {

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
	void testThatReturnsListOfBookObject() throws SQLException 
	{
		List<Book> resultActual=target.FindBookById("Java");
		assertFalse(resultActual.isEmpty());
	}
	
	@Test
	void testThatReturnsEmptyList() throws SQLException 
	{
		List<Book> resultActual=target.FindBookById("AnyBookName");
		assertTrue(resultActual.isEmpty());
	}

}
