package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;











import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Publisher;


@SuppressWarnings("unchecked")
public class BookLoansDAO extends BaseDAO implements ResultSetExtractor<List<BookLoans>> {

	
	
	public List<BookLoans> readAllBranches() throws ClassNotFoundException, SQLException{
		return (List<BookLoans>) template.query("select * from tbl_library_loans",this);
	}
	
	/*public List<Book> readBookBycardNo(Integer cardNo) throws ClassNotFoundException, SQLException{
		return(List<Book>) readAll("select * from tbl_book as b where b.bookId in (select bookId from tbl_book_loans where cardNo=? and dateIn is NULL)", new Object[] {cardNo});
	}*/
	
	
	public void addAuthor(Author author) throws ClassNotFoundException, SQLException{
		template.query("insert into tbl_author (authorName) values (?)", new Object[] {author.getAuthorName()},this);
	}
	
/*	public void checkIn(Integer bookId, Integer cardNo) throws ClassNotFoundException, SQLException {
	
		int branchId = getCount2("select branchId from tbl_book_loans where bookId=? and cardNo = ? and dateIn is NULL", new Object[] {bookId,cardNo});
		System.out.println("branch id: "+branchId);
		template.update("delete from tbl_book_loans where bookId=? and branchId=? and cardNo = ?",new Object[] {bookId,branchId,cardNo});
		System.out.println("book returned.");
		template.update("update tbl_book_copies set noOfCopies = noOfCopies+1 where bookId=? and branchId =?",new Object[] {bookId,branchId});
	}*/
	
	public void checkOut(int bookId, int cardNo, int branchId) throws ClassNotFoundException, SQLException {
	
	
		template.update("insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate ) "
				+ "values( ?, ?, ?,CURDATE(),DATE_ADD(CURDATE(),INTERVAL 15 DAY))",new Object[] {bookId,branchId,cardNo});
		System.out.println("entry added to the book loans table");
		template.update("update tbl_book_copies set noOfCopies = noOfCopies-1 where bookId=? and branchId =?", new Object[] {bookId,branchId});
		
	}
	
	@Override
	public List<BookLoans> extractData(ResultSet rs) throws SQLException {
		
		List<BookLoans> bookloans = new ArrayList<BookLoans>();
				
		while(rs.next()){
		
			BookLoans bl = new BookLoans();
		
			bl.setBookId(rs.getInt("bookId"));
			bl.setBranchId(rs.getInt("branchId"));
			bl.setCardNo(rs.getInt("cardNo"));
			bl.setDateOut(rs.getDate("dateOut"));
			bl.setDueDate(rs.getDate("dueDate"));
			bl.setDateIn(rs.getDate("dateIn"));
			
			bookloans.add(bl);
			
		}
	
		return bookloans;
	}


	


	


	
	
	
}

