package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.model.StudentDetails;

public class StudentDetailsRowMapper implements RowMapper<StudentDetails>{

	public StudentDetails map(ResultSet rs, StatementContext ctx) throws SQLException {
		StudentDetails ob = new StudentDetails();
		ob.setStudentId(rs.getInt("std_id"));
		ob.setStudentName(rs.getString("std_name"));
		ob.setStudentDepatment(rs.getString("std_dept"));
		ob.setDateOfBirth(rs.getDate("std_dob").toLocalDate());
		ob.setStudentMailId(rs.getString("std_mail_id"));
		ob.setMobileNumber(rs.getLong("std_mob_no"));
		ob.setYearOfJoin(rs.getInt("joining_yr"));
		return ob;

}
}
