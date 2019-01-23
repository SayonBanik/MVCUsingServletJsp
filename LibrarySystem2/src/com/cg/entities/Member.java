package com.cg.entities;

import java.sql.Date;

public class Member 
{
	private int memberId;
	
	private String memberPassword;
	
	private String memberName;
	
	private String membershipType;
	
	private int bookHoldingTime;
	
	private Date registrationDate;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public int getBookHoldingTime() {
		return bookHoldingTime;
	}

	public void setBookHoldingTime(int bookHoldingTime) {
		this.bookHoldingTime = bookHoldingTime;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
}
