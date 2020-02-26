package com.chainsys.libraryapp.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.libraryapp.dao.mapper.StudentDetailsStudentFineRowMapper;
import com.chainsys.libraryapp.dao.mapper.SummaryDetailsDueDateRowMapper;
import com.chainsys.libraryapp.dao.mapper.SummaryDetailsStudentDetailsRowMapper;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.model.StudentFineSummaryDetails;
import com.chainsys.libraryapp.model.SummaryDetailsDueDate;
import com.chainsys.libraryapp.model.SummaryDetailsStudentDetails;

public interface SummaryDetailsDAO {
	
	
	
	@SqlUpdate("insert into details(std_id,book_id,book_count) values(?,?,book_count_sq.nextval)")
	public boolean addNewEntry(int studentId, int bookId) throws DbException;

	@SqlQuery("select due_date from details where book_id=:bookId and std_id=:stdId and status=0")
	public LocalDate returnDueDate(@Bind("stdId") int studentId,@Bind("bookId") int BookId) throws DbException;

	@SqlUpdate("update details set fine_amt=:fineAmount ,status=1,returned_date=sysdate where book_id =:bookId and std_id =:studentId and status=0")
	public void updateReturnRecord(@Bind("studentId")int studentId,@Bind("bookId") int bookId, @Bind("fineAmount")Integer fineAmount) throws DbException;

	@SqlQuery("select  d.std_id,s.std_name,s.std_dept,s.std_mob_no,d.book_id,b.book_name,d.issue_date,d.due_date from details d,books b ,student s where s.std_id=d.std_id and d.status=0 and b.book_id=d.book_id and d.book_id=?")
	@RegisterRowMapper(SummaryDetailsDueDateRowMapper.class)
	public ArrayList<SummaryDetailsDueDate> unReturnedBookDetails(int bookId) throws DbException;

	@SqlQuery("select sum(fine_amt) from details")
	@RegisterRowMapper(SummaryDetailsDueDateRowMapper.class)
	public int totalFineAmount() throws DbException;

	@SqlQuery("select  s.std_name,b.book_name,b.book_id,d.issue_date,d.due_date from details d,books b ,student s where s.std_id=d.std_id and d.status=0 and b.book_id=d.book_id and d.std_id=?")
	@RegisterRowMapper(SummaryDetailsStudentDetailsRowMapper.class)
	public ArrayList<SummaryDetailsStudentDetails> unReturnedStudentBookDetails(int studentId) throws DbException;

	@SqlQuery("select 1 from details where  std_id=? and book_id=?  and status=0")
	public Integer bookTaken(int studentId, int bookId) throws DbException;
	
	

	@SqlQuery("select  s.std_name,b.book_name,b.book_id,b.book_cat,d.issue_date,d.due_date from details d,books b ,student s where s.std_id=d.std_id and d.status=0 and b.book_id=d.book_id and d.std_id=?")
	@RegisterRowMapper(StudentDetailsStudentFineRowMapper.class)
	public ArrayList<StudentFineSummaryDetails> totalFineAmountOfStudent(int studentId) throws DbException;

	@SqlQuery("select fn_rem_bks(?) as total from dual")
	public Integer noOfBooksAvailable(int bookId) throws DbException;

	@SqlQuery("select count(std_id) from details where std_id=? and status=0")
	@RegisterRowMapper(SummaryDetailsDueDateRowMapper.class)
	public int limitForStudent(int studentId) throws DbException;
}
