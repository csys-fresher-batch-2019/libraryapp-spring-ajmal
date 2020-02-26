package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.model.BookDetails;

public class BookDetailsRowMapper implements RowMapper<BookDetails>{

	public BookDetails map(ResultSet rs, StatementContext ctx) throws SQLException {
		BookDetails ob= new BookDetails();
		ob.setBookId(rs.getInt("book_id"));
		ob.setBookName(rs.getString("book_name"));
		ob.setBookCategory(rs.getString("book_cat"));
		ob.setBookAutherName(rs.getString("book_author"));
		ob.setBookEdition(rs.getInt("book_edition"));
		ob.setBookPrice(rs.getInt("book_price"));
		ob.setBookPublishedDate(rs.getDate("published_date").toLocalDate());
		ob.setBookCopies(rs.getInt("no_of_bks"));
		ob.setBookPages(rs.getInt("no_of_pgs"));
		return ob;
	}

}
