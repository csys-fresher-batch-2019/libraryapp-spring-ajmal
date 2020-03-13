package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.dto.StudentFineSummary;

public class StudentStudentFineRowMapper implements RowMapper<StudentFineSummary>{
	public StudentFineSummary map(ResultSet rs, StatementContext ctx) throws SQLException {
		StudentFineSummary ob=new StudentFineSummary();
		ob.setStudentName(rs.getString("std_name"));
		ob.setBookId(rs.getInt("book_id"));
		ob.setBookName(rs.getString("book_name"));
		ob.setBookCategory(rs.getString("book_cat"));
		ob.setIssueDate(rs.getDate("issue_date").toLocalDate());
		ob.setDueDate(rs.getDate("due_date").toLocalDate());
		
		return ob;
		
	}

}
