package com.chainsys.libraryapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.chainsys.libraryapp.model.AdminDetails;

public class AdminDetailsRowMapper implements RowMapper<AdminDetails>{

	public AdminDetails map(ResultSet rs, StatementContext ctx) throws SQLException {
		return null;

}
}
