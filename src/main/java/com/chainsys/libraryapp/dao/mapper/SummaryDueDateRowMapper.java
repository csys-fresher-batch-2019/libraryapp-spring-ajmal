package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.dto.SummaryDueDateDTO;

public class SummaryDueDateRowMapper implements RowMapper<SummaryDueDateDTO>{

	public SummaryDueDateDTO map(ResultSet rs, StatementContext ctx) throws SQLException {
		SummaryDueDateDTO ob = new SummaryDueDateDTO();
		ob.setBookId(rs.getInt("book_id"));
		ob.setStudentId(rs.getInt("std_id"));
		ob.setStudentName(rs.getString("std_name"));
		ob.setStudentDept(rs.getString("std_dept"));
		ob.setMobileNumber(rs.getLong("std_mob_no"));
		ob.setBookId(rs.getInt("book_id"));
		ob.setBookName(rs.getString("book_name"));
		ob.setIssueDate(rs.getDate("issue_date").toLocalDate());
		ob.setDueDate(rs.getDate("due_date").toLocalDate());
		return ob;
		
	}

}
