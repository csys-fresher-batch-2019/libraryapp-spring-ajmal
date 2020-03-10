package com.chainsys.libraryapp.dao;

import java.util.ArrayList;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.libraryapp.dao.mapper.BookDetailsRowMapper;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.model.BookDetails;

public interface BookDetailsDAO {

	@SqlUpdate("insert into books(book_name,book_cat,book_author,book_edition,no_of_bks,no_of_pgs,published_date,book_price,book_id)values  (:bookName,:bookCategory,:bookAutherName,:bookEdition,:bookCopies,:bookPages,:bookPublishedDate,:bookPrice,id_seq.nextval)")
	public void addNewBook(@BindBean BookDetails bookdetails) throws DbException;

	@SqlUpdate("update books set no_of_bks=(no_of_bks+:bookCopies) where book_id=:bookId")
	public void updateBookCopies(@Bind("bookId") int bookId, @Bind("bookCopies") int bookCopies) throws DbException;

	@SqlQuery("select * from books where book_id=?")
	@RegisterRowMapper(BookDetailsRowMapper.class)
	public BookDetails displayBook(int bookId) throws DbException;

	@SqlQuery("select * from books")
	@RegisterRowMapper(BookDetailsRowMapper.class)
	public ArrayList<BookDetails> displayAllBooks() throws DbException;

	@SqlQuery("select * from books where lower(book_name)like lower('%'||?||'%')")
	@RegisterRowMapper(BookDetailsRowMapper.class)
	public ArrayList<BookDetails> searchByName(String bookName) throws DbException;

	@SqlQuery("select 1 from books where book_id=?")
	public Integer findByBookId(int bookId);

}
