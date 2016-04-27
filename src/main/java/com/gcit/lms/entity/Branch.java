package com.gcit.lms.entity;

import java.util.List;

public class Branch {

	private int branchId;
	private String branchName;
	private String branchAddress;
	private List<BookCopies> copies;
	private List<BookLoans> loans;
	
	/**
	 * @return the copies
	 */
	public List<BookCopies> getCopies() {
		return copies;
	}
	/**
	 * @param copies the copies to set
	 */
	public void setCopies(List<BookCopies> copies) {
		this.copies = copies;
	}
	/**
	 * @return the loans
	 */
	public List<BookLoans> getLoans() {
		return loans;
	}
	/**
	 * @param loans the loans to set
	 */
	public void setLoans(List<BookLoans> loans) {
		this.loans = loans;
	}
	/**
	 * @return the branchId
	 */
	public int getBranchId() {
		return branchId;
	}
	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * @return the branchAddress
	 */
	public String getBranchAddress() {
		return branchAddress;
	}
	/**
	 * @param branchAddress the branchAddress to set
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	
	
	
}
