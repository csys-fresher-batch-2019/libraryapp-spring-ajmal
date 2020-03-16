package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	public Student map(ResultSet rs, StatementContext ctx) throws SQLException {
		Student ob = new Student();
		ob.setId(rs.getInt("std_id"));
		ob.setName(rs.getString("std_name"));
		ob.setDept(rs.getString("std_dept"));
		ob.setDob(rs.getDate("std_dob").toLocalDate());
		ob.setMailId(rs.getString("std_mail_id"));
		ob.setMobileNumber(rs.getLong("std_mob_no"));
		ob.setYearOfJoin(rs.getInt("joining_yr"));
		return ob;

	}
}
