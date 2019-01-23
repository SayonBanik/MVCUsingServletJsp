package com.cg.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.cg.entities.Book;
import com.cg.entities.Member;
import com.cg.entities.Transaction;

public interface LibraryDao 
{
	public boolean Login(int username, String password) throws SQLException;
	
	public List<Book> FindAllBooks() throws SQLException;
	
	public Member FindMember(int id) throws SQLException;
	
	public List<Book> FindBookById(String title) throws SQLException;
	
	public List<Transaction> FindBooksNotReturned() throws SQLException;
	
	public List<Transaction> FindIssuedBooks() throws SQLException;
	
	public List<Transaction> FindBookBetweenDates(Date sDate, Date eDate) throws SQLException;
}
