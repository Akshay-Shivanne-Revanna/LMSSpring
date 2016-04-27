package com.gcit.lms.entity;



public class BookCopies {

	private Book book;
	private Branch branch;
	private int noOfCopies;
	
	
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * @return the branch
	 */
	public Branch getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	/**
	 * @return the noOfCopies
	 */
	public int getNoOfCopies() {
		return noOfCopies;
	}
	/**
	 * @param noOfCopies the noOfCopies to set
	 */
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	

}
