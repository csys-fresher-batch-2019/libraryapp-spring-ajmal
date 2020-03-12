package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.model.Book;

public class BookDetailsRowMapper implements RowMapper<Book>{

	public Book map(ResultSet rs, StatementContext ctx) throws SQLException {
		Book ob= new Book();
		ob.setId(rs.getInt("book_id"));
		ob.setName(rs.getString("_name"));
		ob.setCategory(rs.getString("_cat"));
		ob.setAuthorName(rs.getString("_author"));
		ob.setEdition(rs.getInt("_edition"));
		ob.setPrice(rs.getInt("_price"));
		ob.setPublishedDate(rs.getDate("published_date").toLocalDate());
		ob.setCopies(rs.getInt("no_of_bks"));
		ob.setPages(rs.getInt("no_of_pgs"));
		return ob;
	}

}
