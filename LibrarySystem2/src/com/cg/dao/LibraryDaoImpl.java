package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.dbconnection.DBConnect;
import com.cg.entities.Book;
import com.cg.entities.Member;
import com.cg.entities.Transaction;



public class LibraryDaoImpl implements LibraryDao {

	static Logger logger = Logger.getLogger(LibraryDaoImpl.class);
	
	@Override
	public boolean Login(int userId, String password) throws SQLException 
	{
	
		Connection conn=DBConnect.GetDBConnection();
		
		String sql="SELECT MemberId FROM Member WHERE MemberId=? AND MemberPassword=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, userId);
		pst.setString(2, password);
		ResultSet res=pst.executeQuery();
		
		if(res.next())
		{
			logger.info("The User has successfully logged in");
			return true;
		}
		
		else
		{
			logger.error("The User could not logged in");
			return false;
		}
	}

	@Override
	public List<Book> FindAllBooks() throws SQLException
	{
		List<Book> bList=new ArrayList<Book>();
		
		Connection conn=DBConnect.GetDBConnection();
		
		String sql="SELECT BookId,BookTitle,BookEdition,BookQuantity,BookCost FROM Book";
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery(sql);
		
		while(res.next())
		{
			Book book=new Book();
			book.setBookId(res.getInt("BookId"));
			book.setBookTitle(res.getString("BookTitle"));
			book.setBookEdition(res.getString("BookEdition"));
			book.setBookQuantity(res.getInt("BookQuantity"));
			book.setBookCost(res.getInt("BookCost"));
			
			logger.info("book object initialized with BookId:"+res.getInt("BookId")+",BookTitle:"+res.getString("BookTitle")+
					",BookEdition:"+res.getString("BookEdition")+",BookQuantity:"+res.getInt("BookQuantity")+
					",BookCost:"+res.getInt("BookCost"));
			
			bList.add(book);
			
			logger.info("book object added to List 'bList'");
			
		}
		
		logger.info("bList is being returned to caller");
		return bList;
	}

	@Override
	public Member FindMember(int id) throws SQLException 
	{
		Connection conn=DBConnect.GetDBConnection();
		
		String sql="SELECT * FROM Member WHERE MemberId=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet res=pst.executeQuery();
		Member mRecord=null;
		
		if(res.next())
		{
			mRecord=new Member();
			mRecord.setMemberId(res.getInt("MemberId"));
			mRecord.setMemberName(res.getString("MemberName"));
			mRecord.setMembershipType(res.getString("MembershipType"));
			mRecord.setBookHoldingTime(res.getInt("BookHoldingTime"));
			mRecord.setRegistrationDate(res.getDate("RegistrationDate"));
			
			logger.info("object mRecord of type Member is initialized with MemberId:"+res.getInt("MemberId")+
					",MemberName:"+res.getString("MemberName")+",MembershipType:"+res.getString("MembershipType")+
					",BookHoldingTime:"+res.getInt("BookHoldingTime")+",RegistrationDate"+res.getDate("RegistrationDate"));
		}
		
		logger.info("mRecord is being returned to caller");
		
		return mRecord;
	}

	@Override
	public List<Book> FindBookById(String title) throws SQLException
	{
		List<Book> bDetails=new ArrayList<Book>();
		
		Connection conn=DBConnect.GetDBConnection();
		
		String sql="SELECT * FROM Book WHERE BookTitle=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, title);
		ResultSet res=pst.executeQuery();
		
		while(res.next())
		{
			Book book=new Book();
			book.setBookId(res.getInt("BookId"));
			book.setBookTitle(res.getString("BookTitle"));
			book.setBookEdition(res.getString("BookEdition"));
			book.setBookQuantity(res.getInt("BookQuantity"));
			book.setBookCost(res.getInt("BookCost"));
			
			logger.info("book object initialized with BookId:"+res.getInt("BookId")+",BookTitle:"+res.getString("BookTitle")+
					",BookEdition:"+res.getString("BookEdition")+",BookQuantity:"+res.getInt("BookQuantity")+
					",BookCost:"+res.getInt("BookCost"));
			
			bDetails.add(book);
			
			logger.info("book object added to List 'bDetails'");
		}
		
		logger.info("bDetails is being returned to caller");
		
		return bDetails;
	}

	@Override
	public List<Transaction> FindBooksNotReturned() throws SQLException 
	{
		List<Transaction> txnList=new ArrayList<>();
		Connection conn=DBConnect.GetDBConnection();
		
		String sql="SELECT * FROM Transaction WHERE ReturnStatus='Not Returned'";
		
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery(sql);
		
		while(res.next())
		{
			Transaction txn=new Transaction();
			txn.setTransactionId(res.getInt("TransactionId"));
			txn.setBookId(res.getInt("BookId"));
			txn.setMemberId(res.getInt("MemberId"));
			txn.setBookName(res.getString("BookName"));
			txn.setBookQuantity(res.getInt("BookQuantity"));
			txn.setIssueDate(res.getDate("IssueDate"));
			txn.setReturnDate(res.getDate("ReturnDate"));
			txn.setReturnStatus(res.getString("ReturnStatus"));
			
			logger.info("object txn of type Transaction is initialized with TransactionId:"+res.getInt("TransactionId")+
					",BookId:"+res.getInt("BookId")+
					",MemberId:"+res.getInt("MemberId")+",BookName:"+res.getString("BookName")+
					",BookQuantity:"+res.getInt("BookQuantity")+",IssueDate:"+res.getDate("IssueDate")+
					",ReturnDate:"+res.getDate("ReturnDate")+",ReturnStatus:"+res.getString("ReturnStatus"));
			
			txnList.add(txn);
			
			logger.info("txn has been added to List 'txnList'");
		}
		
		logger.info("txnList is being returned to caller");
		
		return txnList;
	}

	@Override
	public List<Transaction> FindIssuedBooks() throws SQLException
	{
		
		List<Transaction> txnList=new ArrayList<>();
		Connection conn=DBConnect.GetDBConnection();
		
		String sql="SELECT * FROM Transaction";
		
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery(sql);
		
		while(res.next())
		{
			Transaction txn=new Transaction();
			txn.setTransactionId(res.getInt("TransactionId"));
			txn.setBookId(res.getInt("BookId"));
			txn.setMemberId(res.getInt("MemberId"));
			txn.setBookName(res.getString("BookName"));
			txn.setBookQuantity(res.getInt("BookQuantity"));
			txn.setIssueDate(res.getDate("IssueDate"));
			txn.setReturnDate(res.getDate("ReturnDate"));
			txn.setReturnStatus(res.getString("ReturnStatus"));
			
			logger.info("object txn of type Transaction is initialized with TransactionId:"+res.getInt("TransactionId")+
					",BookId:"+res.getInt("BookId")+
					",MemberId:"+res.getInt("MemberId")+",BookName:"+res.getString("BookName")+
					",BookQuantity:"+res.getInt("BookQuantity")+",IssueDate:"+res.getDate("IssueDate")+
					",ReturnDate:"+res.getDate("ReturnDate")+",ReturnStatus:"+res.getString("ReturnStatus"));
			
			txnList.add(txn);
			
			logger.info("txn has been added to List 'txnList'");
		}
		
		logger.info("txnList is being returned to caller");
		 
		return txnList;
	}

	@Override
	public List<Transaction> FindBookBetweenDates(Date sDate, Date eDate) throws SQLException
	{
		List<Transaction> txnList=new ArrayList<>();
		Connection conn=DBConnect.GetDBConnection();
		
		String sql="SELECT * FROM Transaction WHERE IssueDate BETWEEN ? AND ?";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setDate(1, new java.sql.Date(sDate.getTime()));
		pst.setDate(2, new java.sql.Date(eDate.getTime()));
		
		ResultSet res=pst.executeQuery();
		
		while(res.next())
		{
			Transaction txn=new Transaction();
			txn.setTransactionId(res.getInt("TransactionId"));
			txn.setBookId(res.getInt("BookId"));
			txn.setMemberId(res.getInt("MemberId"));
			txn.setBookName(res.getString("BookName"));
			txn.setBookQuantity(res.getInt("BookQuantity"));
			txn.setIssueDate(res.getDate("IssueDate"));
			txn.setReturnDate(res.getDate("ReturnDate"));
			txn.setReturnStatus(res.getString("ReturnStatus"));
			
			logger.info("object txn of type Transaction is initialized with TransactionId:"+res.getInt("TransactionId")+
					",BookId:"+res.getInt("BookId")+
					",MemberId:"+res.getInt("MemberId")+",BookName:"+res.getString("BookName")+
					",BookQuantity:"+res.getInt("BookQuantity")+",IssueDate:"+res.getDate("IssueDate")+
					",ReturnDate:"+res.getDate("ReturnDate")+",ReturnStatus:"+res.getString("ReturnStatus"));
			
			txnList.add(txn);
			
			logger.info("txn has been added to List 'txnList'");
		}
		
		logger.info("txnList is being returned to caller");
		 
		return txnList;
	}

}
