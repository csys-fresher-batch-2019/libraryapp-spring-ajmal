package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.dto.SummaryStudentDetailsDTO;

public class SummaryStudentDetailsRowMapper implements RowMapper<SummaryStudentDetailsDTO> {

	@Override
	public SummaryStudentDetailsDTO map(ResultSet rs, StatementContext ctx) throws SQLException {
		SummaryStudentDetailsDTO ob = new SummaryStudentDetailsDTO();
		ob.setStudentName(rs.getString("std_name"));
		ob.setBookId(rs.getInt("book_id"));
		ob.setBookName(rs.getString("book_name"));
		ob.setIssueDate(rs.getDate("issue_date").toLocalDate());
		ob.setDueDate(rs.getDate("due_date").toLocalDate());
		return ob;

	}
}