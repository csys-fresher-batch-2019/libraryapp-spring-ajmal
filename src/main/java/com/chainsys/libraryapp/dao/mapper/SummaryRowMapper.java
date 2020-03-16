package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.model.SummaryDetails;

public class SummaryRowMapper implements RowMapper<SummaryDetails> {

	public SummaryDetails map(ResultSet rs, StatementContext ctx) throws SQLException {
		SummaryDetails ob = new SummaryDetails();
		ob.setBookCount(rs.getInt("book_count"));
		ob.setBookId(rs.getInt("book_id"));
		ob.setStudentId(rs.getInt("std_id"));
		ob.setFineAmount(rs.getInt("fine_amt"));
		ob.setActiveStatus(rs.getInt("status"));
		ob.setReturnedDate(rs.getDate("returned_date").toLocalDate());
		ob.setIssueDate(rs.getDate("issue_date").toLocalDate());
		ob.setDueDate(rs.getDate("due_date").toLocalDate());
		return ob;
	}

}
