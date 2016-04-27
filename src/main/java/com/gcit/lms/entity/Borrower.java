package com.gcit.lms.entity;

import java.util.List;

public class Borrower {

	private int cardNo;
	private String name;
	private String Address;
	private String phone;
	private List<BookLoans> Bloans;
	
	
	/**
	 * @return the cardNo
	 */
	public int getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the bloans
	 */
	public List<BookLoans> getBloans() {
		return Bloans;
	}
	/**
	 * @param bloans the bloans to set
	 */
	public void setBloans(List<BookLoans> bloans) {
		Bloans = bloans;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
