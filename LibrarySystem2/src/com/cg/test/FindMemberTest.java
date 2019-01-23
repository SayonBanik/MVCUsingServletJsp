package com.cg.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.entities.Member;
import com.cg.service.LibraryServiceImpl;

class FindMemberTest {

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
	void testThatReturnsMemberObject() throws SQLException 
	{
		Member resultActual=target.FindMember(1);
		
		assertEquals("Sayon",resultActual.getMemberName());
	}
	
	
	@Test
	void testThatReturnsNullObject() throws SQLException 
	{
		Member resultActual=target.FindMember(100);
		
		assertNull(resultActual);
	}

}
