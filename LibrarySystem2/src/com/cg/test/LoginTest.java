package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cg.service.LibraryServiceImpl;

class LoginTest {

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
	void testThatReturnsTrueIfTheUserGetsAuthentication() throws SQLException 
	{
		boolean resultActual=target.Login(1, "sayon@capg");
		
		assertEquals(true, resultActual);
	}
	
	@Test
	void testThatReturnsFalseIfTheUserDoesNotGetAuthentication() throws SQLException 
	{
		boolean resultActual=target.Login(5, "anypassword");
		
		assertEquals(false, resultActual);
	}

}
