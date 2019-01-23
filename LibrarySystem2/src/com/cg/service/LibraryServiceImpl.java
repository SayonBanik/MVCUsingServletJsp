package com.cg.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.cg.dao.LibraryDao;
import com.cg.dao.LibraryDaoImpl;
import com.cg.entities.Book;
import com.cg.entities.Member;
import com.cg.entities.Transaction;

public class LibraryServiceImpl implements LibraryService {

	LibraryDao lDao=null;
	
	@Override
	public boolean Login(int username, String password) throws SQLException 
	{
		lDao=new LibraryDaoImpl();
		return lDao.Login(username, password);
	}

	@Override
	public List<Book> FindAllBooks() throws SQLException 
	{
		lDao=new LibraryDaoImpl();
		return lDao.FindAllBooks();
	}

	@Override
	public Member FindMember(int id) throws SQLException 
	{
		lDao=new LibraryDaoImpl();
		return lDao.FindMember(id);
	}

	@Override
	public List<Book> FindBookById(String title) throws SQLException 
	{
		lDao=new LibraryDaoImpl();
		return lDao.FindBookById(title);
	}

	@Override
	public List<Transaction> FindBooksNotReturned() throws SQLException 
	{
		lDao=new LibraryDaoImpl();
		return lDao.FindBooksNotReturned();
	}

	@Override
	public List<Transaction> FindIssuedBooks() throws SQLException
	{
		lDao=new LibraryDaoImpl();
		return lDao.FindIssuedBooks(); 
	}

	@Override
	public List<Transaction> FindBookBetweenDates(Date sDate, Date eDate) throws SQLException 
	{
		lDao=new LibraryDaoImpl();
		return lDao.FindBookBetweenDates(sDate, eDate);
	}

}
