package com.gcit.lms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;



public class AuthorDAO extends BaseDAO implements ResultSetExtractor<List<Author>>{

	
	//ADD AUTHOR
	public void addAuthor(Author author) throws ClassNotFoundException, SQLException{
		template.update("insert into tbl_author (authorName) values (?)", new Object[] {author.getAuthorName()});
	}

	//ADD AUTHOR BY ID
	public void addAuthorWithID(Author author) {
		final String authorName = author.getAuthorName();
		final String INSERT_SQL = "insert into tbl_author (authorName) values (?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, authorName);
				return ps;
			}
		}, keyHolder);
		int authorId = keyHolder.getKey().intValue();
		for(Book b: author.getBooks()){
			template.update("insert into tbl_book_authors (bookId, authorId) values (?, ?)", new Object[] {b.getBookId(), author.getAuthorId()});
		}
	}
	
	
	//UPDATE AUTHOR
	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException{
		template.update("update tbl_author set authorName = ? where authorId = ?", new Object[] {author.getAuthorName(), author.getAuthorId()});
	}
	
	//DELETE AUTHOR
	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_author where authorId = ?", new Object[] {author.getAuthorId()});
	}
	
	//READ ALL AUTHORS
	public List<Author> readAllAuthors(int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		return (List<Author>) template.query("select * from tbl_author", this);
	}
	
	//READ AUTHORS BY NAME
	public List<Author> readAuthorsByName(String name,int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name="%"+name+"%";
		return (List<Author>) template.query("select * from tbl_author where authorName like ?", new Object[] {name},this);
	}
	
	//READ AUTHOR BY ID
	public Author readAuthorsByID(Integer authorId) throws ClassNotFoundException, SQLException{
		List<Author> authors = (List<Author>) template.query("select * from tbl_author where authorId =?", new Object[] {authorId},this);
		if(authors!=null && authors.size()>0){
			return authors.get(0);
		}
		return null;
	}
	
	
	//GET COUNT OF NUMBER OF AUTHORS
	public Integer getCount() throws ClassNotFoundException, SQLException{
		return template.queryForObject("select count(*) from tbl_author",Integer.class);
		
	}
	
	//DELETE AUTHOR
	public void deleteAuthor(Integer authorId) throws ClassNotFoundException, SQLException {
		template.update("delete from tbl_author where authorId =?",new Object[]{authorId});
	}
	
	
	//READ AUTHORS BY NAME
	public List<Author> readAuthorsByAuthorName(String name,int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name="%"+name+"%";
		return (List<Author>) template.query("select * from tbl_author where authorName like ?", new Object[] {name},this);
	}
	
	//READ AUTHORS BY BOOK TITLE
	public List<Author> readAuthorsByBookTitle(String name,int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name="%"+name+"%";
		return (List<Author>) template.query("select * from tbl_author a inner join tbl_book_authors ba on ba.authorId = a.authorId inner join tbl_book b on b.bookId = ba.bookId where b.title like ?", new Object[] {name},this);
	}
	
	//READ AUTHORS BY NAME OR TITLE
	public List<Author> readAuthorsByBookTitleorName(String name,int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name="%"+name+"%";
		return (List<Author>) template.query("select * from tbl_author a inner join tbl_book_authors ba on ba.authorId = a.authorId inner join tbl_book b on b.bookId = ba.bookId where b.title like ? or a.authorName like ?", new Object[] {name,name},this);
	}
	
	@Override
	public List<Author> extractData(ResultSet rs) throws SQLException {
		List<Author> authors = new ArrayList<Author>();
		while(rs.next()){
			Author a = new Author();
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));
			authors.add(a);
		}
		return authors;
	}
	


}
