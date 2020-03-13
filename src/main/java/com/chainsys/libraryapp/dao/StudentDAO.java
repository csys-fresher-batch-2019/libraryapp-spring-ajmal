package com.chainsys.libraryapp.dao;

import java.time.LocalDate;
import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.libraryapp.dao.mapper.StudentRowMapper;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.model.Student;

public interface StudentDAO {

	@SqlUpdate("insert into student(std_name,std_dept,std_dob,std_mail_id,std_mob_no,joining_yr,std_id) values(:studentName,:studentDepatment,:dateOfBirth,:studentMailId,:mobileNumber,:yearOfJoin,std_seq.nextval)")
	public void save(@BindBean Student studentdetails) throws DbException;

	@SqlQuery("select * from student where std_id=?")
	@RegisterRowMapper(StudentRowMapper.class)
	public Student findById(int studentId) throws DbException;

	@SqlQuery("select * from student")
	@RegisterRowMapper(StudentRowMapper.class)
	public List<Student> findAll() throws DbException;

	@SqlQuery("select 1 from student where std_id=? and std_dob=?")
	public Boolean studentLogin(int studentId, LocalDate studentDOB) throws DbException;

	@SqlQuery("select 1 from student where std_id=?")
	public Integer checkStudentId(int studentId);

}
