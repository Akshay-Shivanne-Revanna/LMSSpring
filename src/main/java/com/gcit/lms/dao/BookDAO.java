package com.gcit.lms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Publisher;



public class BookDAO extends BaseDAO implements ResultSetExtractor<List<Book>>{
	

	
	
	public void addBook(Book book) throws ClassNotFoundException, SQLException{
		template.update("insert into tbl_book (title, publisherId) values (?, ?)", new Object[] {book.getTitle(), book.getPublisher().getPublisherId()});
	}
	
		
	public void addBookAuthor(Book book,Author author) throws ClassNotFoundException, SQLException {
		template.update("insert into tbl_book_authors (bookId, authorId) values (?, ?)", new Object[] {book.getBookId(), author.getAuthorId()});
		
	}
	
	public void addBookGenre(Book book,Genre genre) throws ClassNotFoundException, SQLException {
		template.update("insert into tbl_book_genres (genre_id,bookId ) values (?, ?)", new Object[] {genre.getGenreId(), book.getBookId()});
		
	}
	
	
	//GET COUNT OF NUMBER OF AUTHORS
	public Integer getCount() throws ClassNotFoundException, SQLException{
		return template.queryForObject("select count(*) from tbl_book",Integer.class);
	}

	
	
	
	public void addBookWithID(Book book) {
		final String title = book.getTitle();
		final String INSERT_SQL = "insert into tbl_book (title, pubId) values (?, ?) ";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, title);
				ps.setInt(2, 2);
				return ps;
			}
		}, keyHolder);
		int bookId = keyHolder.getKey().intValue();
		for(Author a: book.getAuthors()){
			template.update("insert into tbl_book_authors (bookId, authorId) values (?, ?)", new Object[] {book.getBookId(), a.getAuthorId()});
		}
	}
	
	
	
	
	public void updateBook(Book book) throws ClassNotFoundException, SQLException{
		template.update("update tbl_book set title = ? where bookId = ?", new Object[] {book.getTitle(), book.getBookId()});
	}
	
	public void deleteBook(Book book) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_book where bookId = ?", new Object[] {book.getBookId()});
	}
	
	public List<Book> readAllBooks(int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		return (List<Book>) template.query("select * from tbl_book", this);
	}
	
	public Book readBookByID(Integer bookId) throws ClassNotFoundException, SQLException{
		List<Book> books = (List<Book>) template.query("select * from tbl_book where bookId =?", new Object[] {bookId},this);
		if(books!=null && books.size()>0){
			return books.get(0);
		}
		return null;
	}
	
	//READ AUTHORS BY NAME
	public List<Book> readBooksByName(String name,int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name="%"+name+"%";
		return (List<Book>) template.query("select * from tbl_book where title like ?", new Object[] {name},this);
	}
	
	//READ AUTHORS BY NAME
	public List<Book> readBooksByAuthor(String name,int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name="%"+name+"%";
		return (List<Book>) template.query("select * from tbl_author a inner join tbl_book_authors ba on a.authorId=ba.authorId inner join tbl_book b on ba.bookId = b.bookId where authorName like ?", new Object[] {name},this);
	}
	
	//READ AUTHORS BY NAME
	public List<Book> readBooksByAuthorOrTitle(String name,int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name="%"+name+"%";
		return (List<Book>) template.query("select * from tbl_author a inner join tbl_book_authors ba on ba.authorId=a.authorId inner join tbl_book b on b.bookId = ba.bookId where a.authorName like ? OR b.title like ?", new Object[] {name,name},this);
	}
	
	public List<Book> readBookByBranchID(Integer branchId) throws ClassNotFoundException, SQLException {
		return (List<Book>) template.query("select * from tbl_book where bookId in (select bc.bookId from tbl_book_copies as bc where bc.branchId = ? and noOfCopies>0)", new Object[] {branchId},this);
	}
	
	@Override
	public List<Book> extractData(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<Book>();
	
		while(rs.next()){
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			
			Publisher p = new Publisher();
			p.setPublisherId(rs.getInt("pubId"));
			b.setPublisher(p);
			
			books.add(b);
		}
		return books;
	}
	

	


	

	

}
