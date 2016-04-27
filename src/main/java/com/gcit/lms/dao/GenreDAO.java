package com.gcit.lms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.entity.Genre;



public class GenreDAO extends BaseDAO implements ResultSetExtractor<List<Genre>>{

	//ADD GENRE
	public void addGenre(Genre genre) throws ClassNotFoundException, SQLException{
		template.update("insert into tbl_genre (genre_name) values (?)", new Object[] {genre.getGenreName()});
	}
	
	//UPDATE GENRE
	public void updateGenre(Genre genre) throws ClassNotFoundException, SQLException{
		template.update("update tbl_genre set genre_name = ? where genre_id = ?", new Object[] {genre.getGenreName(),genre.getGenreId()});
	}
	
	//DELETE GENRE
	public void deleteGenre(Genre genre) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_genre where genre_id = ?", new Object[] {genre.getGenreId()});
	}
	
	
	public List<Genre> readAllGenre() throws ClassNotFoundException, SQLException{
		return (List<Genre>) template.query("select * from tbl_genre", this);
	}
	
	
	
	@Override
	public List<Genre> extractData(ResultSet rs) throws SQLException {
		List<Genre> genres = new ArrayList<Genre>();
		
		
		while(rs.next()){
			Genre genr = new Genre();
			genr.setGenreId(rs.getInt("genre_id"));
			genr.setGenreName(rs.getString("genre_name"));
						
			genres.add(genr);
		}
		
		
		return genres;
	}



}

