package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.model.Book;

public class BookRowMapper implements RowMapper<Book> {

	public Book map(ResultSet rs, StatementContext ctx) throws SQLException {
		Book ob = new Book();
		ob.setId(rs.getInt("book_id"));
		ob.setName(rs.getString("book_name"));
		ob.setCategory(rs.getString("book_cat"));
		ob.setAuthorName(rs.getString("book_author"));
		ob.setEdition(rs.getInt("book_edition"));
		ob.setPrice(rs.getInt("book_price"));
		ob.setPublishedDate(rs.getDate("published_date").toLocalDate());
		ob.setCopies(rs.getInt("no_of_bks"));
		ob.setPages(rs.getInt("no_of_pgs"));
		return ob;
	}

}
